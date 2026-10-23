# Wolverine

> Dear Wolverine,
>
> You must claw your way to testing excellence and help me become besties with Spiderman.
>
> Refine this code to pass mutation testing. Then and only then will you be my **TESTING HERO**.
>
> There is peril ahead....
>
> Good Luck, XOXO Deadpool
>
> PS
>
> In order to discover other mutants with PIT:
>
> run this in your terminal: `./gradlew pitest`
>
> then open `build/reports/pitest/index.html` in your browser
>
> PPS
>
> Oh One More thing: You can mutation test one class at a time if wanted.
>
> Run the following to mutation test only the spiderman class:
>
> `./gradlew pitest --targetTests='com.liminalarc.wolverine.SpidermanTests' --args='--targetClasses=com.liminalarc.wolverine.Spiderman'`
>


## The Challenge

Refine the code so it passes mutation testing with [PIT](https://pitest.org/).

## Prerequisites

- JDK 17 or newer (the project uses the included Gradle wrapper, so no separate Gradle install is needed)

## Getting Started

| Task                          | Command             |
|-------------------------------|---------------------|
| Build and run all tests       | `./gradlew build`   |
| Run just the tests            | `./gradlew test`    |
| Run mutation testing with PIT | `./gradlew pitest`  |


## AI Disclosure
### Tool name and Developers/Authors:
Claude AI was used as a tool. This kata was developed by Nora Van Vleet, Andy Slocum, Stephen Cavaliere, Brent Velandra​, and Jeff Hoover.
### Version:
Sonnet 5 model​, Sonnet 5.5 model, Opus 5 model, Opus 5.5 model

### Task performed:
Claude AI provided first draft of code content based on prior LA standard artifacts and industry standard information on the internet. Changes were validated by at least one developer/author; multiple authors reviewed and refined content based on subject matter expertise to finalize against profession experience and human judgment.​