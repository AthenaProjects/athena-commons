package org.athenaprojects.commons.threading;

import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public final class ThreadBridge implements AutoCloseable {

    private final Plugin plugin;
    private final boolean isFolia;
    private final Set<ScheduledTask> activeFoliaTasks = ConcurrentHashMap.newKeySet();

    public ThreadBridge(@NotNull Plugin plugin) {
        this.plugin = plugin;
        this.isFolia = checkFolia();
    }

    private static boolean checkFolia() {
        try {
            Class.forName("io.papermc.paper.threadedregions.RegionizedServer");
            return true;
        } catch (ClassNotFoundException ignored) {
            return false;
        }
    }

    public void run(@NotNull Entity entity, @NotNull Consumer<Entity> action) {
        if (isFolia) {
            entity.getScheduler().run(plugin, task -> action.accept(entity), null);
        } else {
            Bukkit.getScheduler().runTask(plugin, () -> action.accept(entity));
        }
    }

    public void runAt(@NotNull Location location, @NotNull Runnable action) {
        if (isFolia) {
            Bukkit.getRegionScheduler().execute(plugin, location, action);
        } else {
            Bukkit.getScheduler().runTask(plugin, action);
        }
    }

    public void runAsync(@NotNull Runnable action) {
        if (isFolia) {
            Bukkit.getAsyncScheduler().runNow(plugin, task -> action.run());
        } else {
            Bukkit.getScheduler().runTaskAsynchronously(plugin, action);
        }
    }

    @Override
    public void close() {
        activeFoliaTasks.forEach(ScheduledTask::cancel);
        activeFoliaTasks.clear();
    }
}