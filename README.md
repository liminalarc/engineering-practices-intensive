# engineering-practices-intensive

- This repo holds content for a one-week, level-setting class on technical practices.
- Material here is course content (exercises, examples, and supporting docs) rather than a production application.

## Setup

Every project builds with its own Gradle wrapper (`./gradlew`), so the only thing to install is **JDK 17**. Newer JDKs (e.g. 27) can't run these Gradle versions.

We use [SDKMAN](https://sdkman.io/) to manage JDKs. The repo's `.sdkmanrc` switches to JDK 17 when you `cd` into it.

1. Install SDKMAN, then open a new terminal:
   ```
   curl -s "https://get.sdkman.io" | bash
   ```
2. Install Temurin 17:
   ```
   sdk install java 17.0.20-tem
   ```
3. Turn on auto-switching: set `sdkman_auto_env=true` in `~/.sdkman/etc/config`, then open a new terminal.
4. Check it: from inside the repo, `java -version` should print `17.0.20`.

Without auto-switching, run `sdk env` in the repo root instead.

## AI Disclosure Statement
Tool name and Developers/Authors: Claude AI was used as a tool. This was developed by Nora Van Vleet, Brent Velandra, Jeff Hoover, and Stephen Cavaliere.

Version: Sonnet 5.5 model, Opus 5.5 model​

Task performed: Claude AI provided first draft of code and other repository content based on provided standards and industry standard information on the internet. Changes were validated by Nora Van Vleet. Nora Van Vleet reviewed and refined content based on subject matter expertise to finalize against profession experience and human judgment. Jeff Hoover and Stephen Cavaliere reviewed and validated the AI-assisted content. Claude AI (Opus 5.5) split the bikeshare kata into independent per-service Java projects; Brent Velandra directed and validated that restructure.​
