# Athena Commons

A lightweight Java utility library we use for our PaperMC (1.21+) and Folia plugins.

[![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square)](https://adoptium.net/)
[![PaperMC](https://img.shields.io/badge/PaperMC-1.21.4-blue?style=flat-square)](https://papermc.io/)
[![Folia](https://img.shields.io/badge/Folia-Supported-brightgreen?style=flat-square)](https://github.com/PaperMC/Folia)

### What's inside
- **ThreadBridge:** Safe execution for players and entities across Folia regional schedulers and Paper.
- **CooldownService:** Fast in-memory cooldowns with token reversion and persistence snapshots.
- **Text:** Clean MiniMessage formatting helpers with solid strikethrough dividers.

### Usage
```kotlin
dependencies {
    implementation("org.athenaprojects:athena-commons:1.0.0")
}
```
