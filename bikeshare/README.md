# bikeshare

**bikeshare** is an iterative kata. The same core problem is applied to a different tech topic each iteration (languages, testing approaches, frameworks, tooling, design patterns), so results can be compared and the kata can grow incrementally.

The domain is a city bike-share: riders check out bikes from a shared fleet, join group rides and cycling clubs, get notified of route hazards, and pay fares.

## Projects

This folder holds independent Java projects, one per service. Each has its own Gradle wrapper and build, and its own package named after the project. Types a project needs (records, ports) are copied into it rather than shared.

| Project | Classes |
| --- | --- |
| `bikecheckoutservice` | `BikeCheckoutService`, `Bike`, `RentalAudit` |
| `groupridequeueservice` | `GroupRideQueueService`, `Rider`, `RiderRepository` |
| `clubinviteservice` | `ClubInviteService`, `CyclingClub`, `ClubRepository` |
| `routehazardservice` | `RouteHazardService`, `RouteHazard`, `SendNotice` |
| `ridecalendarservice` | `RideCalendarService`, `Ride` |
| `riderservice` | `RiderService`, `Rider` |
| `farecalculator` | `FareCalculator` |
| `potholeimpact` | `PotholeImpact` |

## Tech

- Java
- Gradle (wrapper included in each project)
- JUnit 5 (Jupiter)

## Usage

Run from inside a project folder, e.g. `bikeshare/bikecheckoutservice`:

```
./gradlew build   # compile and test
./gradlew test    # run tests only
```

## AI Disclosure Statement
Tool name and Developers/Authors: Claude AI was used as a tool. This was developed by Nora Van Vleet, Brent Velandra, Jeff Hoover, and Stephen Cavaliere.

Version: Sonnet 5.5 model, Opus 5.5 model

Task performed: Claude AI provided first draft of code and other repository content based on provided standards and industry standard information on the internet. Changes were validated by Nora Van Vleet. Nora Van Vleet reviewed and refined content based on subject matter expertise to finalize against profession experience and human judgment. Jeff Hoover and Stephen Cavaliere reviewed and validated the AI-assisted content. Claude AI (Opus 5.5) split the kata into independent per-service Java projects; Brent Velandra directed and validated that restructure.
