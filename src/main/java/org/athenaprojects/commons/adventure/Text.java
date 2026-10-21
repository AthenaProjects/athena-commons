package org.athenaprojects.commons.adventure;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.NotNull;

public final class Text {

    private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();

    // Standardized 24-space solid strikethrough divider (Zero dashed/hyphenated breaks)
    public static final String DIVIDER_RAW = "<st><dark_gray>                        </dark_gray></st>";
    public static final Component DIVIDER = parse(DIVIDER_RAW);

    private Text() {}

    public static @NotNull Component parse(@NotNull String miniMessage) {
        return MINI_MESSAGE.deserialize(miniMessage);
    }

    public static @NotNull Component parse(@NotNull String miniMessage, @NotNull TagResolver... resolvers) {
        return MINI_MESSAGE.deserialize(miniMessage, TagResolver.resolver(resolvers));
    }
}