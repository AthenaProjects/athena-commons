<div align="center">

# ğŸ›ï¸ Athena Commons

**Multi-Threaded Foundation & Utilities for PaperMC (1.21+), Folia, and Leaf Server Architectures**

[![Java 21+](https://img.shields.io/badge/Java-21%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://adoptium.net/)
[![PaperMC](https://img.shields.io/badge/PaperMC-1.21.4-1A1A1A?style=for-the-badge&logo=minecraft&logoColor=white)](https://papermc.io/)
[![Folia / Leaf](https://img.shields.io/badge/Folia%20%2F%20Leaf-Multi--Threading-3B82F6?style=for-the-badge)](https://github.com/PaperMC/Folia)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)](LICENSE)

<br/>

`athena-commons` provides the enterprise building blocks for modern Minecraft plugins: universal cross-region thread dispatchers, atomic in-memory rate-limiters, and Adventure MiniMessage helpers with standardized UI dividers.

</div>

---

### âš¡ Core Architecture

#### 1. ğŸŒ Universal ThreadBridge (`ThreadBridge`)
Ensures every entity, player, and block operation executes strictly on the thread that owns it across Leaf, Folia, and traditional Paper.
* **Region-Safe Execution:** Eliminates `RegionizedServer` threading violations.
* **Player & Entity Safety:** `run(player, action)` and `runOrRetired(player, action, fallback)`.
* **Automatic Reload Cleanup:** Implements `AutoCloseable` with task lifecycle tracking to eliminate orphaned scheduler tasks on `/reload` or plugin shutdown.

#### 2. â±ï¸ Scoped & Reversible Cooldowns (`CooldownService`)
Pure in-memory, high-throughput cooldown and rate-limiting engine.
* **Reversible Tokens:** If an action fails or is aborted, `token.revert()` rolls back the exact previous timestamp.
* **Multi-Scope Queries:** Check cooldowns globally (`"global"`) or per-feature/world (`remainingAny(uuid, "world_nether", "global")`).
* **Persistence Snapshots:** Direct `snapshot()` and `restore()` methods to persist active cooldowns to SQLite/MySQL/Redis across restarts.

#### 3. ğŸ§© Native 1.21.4 Data Components (`ItemComponentBuilder`)
Modern item component manipulation without brittle NMS internals:
* Custom max stack sizes (`maxStackSize(1-99)`), fire resistance, edible item properties, and equipment slot binding.

---

### ğŸ“¦ Installation

#### Gradle (Kotlin DSL)
```kotlin
repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation("org.athenaprojects:athena-commons:1.0.0")
}
```

---

<div align="center">
  <sub>Part of the <a href="https://github.com/AthenaProjects">Athena Development</a> distributed server ecosystem.</sub>
</div>