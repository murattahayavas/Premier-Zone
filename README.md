# Premier Zone

A Spring Boot application for football fans to manage and explore Premier League player statistics and data.

## 🏈 About

Premier Zone is a RESTful API application built with Spring Boot that provides comprehensive player statistics for Premier League football players. The application allows users to manage player data, search for players by various criteria, and access detailed performance metrics.

## ✨ Features

- **Player Management**: Full CRUD operations for player data
- **Advanced Search**: Filter players by name, team, position, and nationality
- **Comprehensive Statistics**: Track various player metrics including:
  - Goals and assists
  - Minutes played and starts
  - Expected goals (xG) and expected assists (xA)
  - Cards (yellow and red)
  - Penalties
- **RESTful API**: Clean and intuitive API endpoints
- **PostgreSQL Database**: Robust data persistence with PostgreSQL

## 🛠️ Technology Stack

- **Backend**: Spring Boot 3.5.4
- **Database**: PostgreSQL
- **ORM**: Spring Data JPA with Hibernate
- **Java Version**: 21
- **Build Tool**: Maven

## 📋 Prerequisites

Before running this application, make sure you have the following installed:

- Java 21 or higher
- Maven 3.6+
- PostgreSQL 12 or higher

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd premier-zone_yeni
```

### 2. Database Setup

1. Create a PostgreSQL database named `pl_data`
2. Update the database configuration in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pl_data
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Run the Application

```bash
# Using Maven wrapper
./mvnw spring-boot:run

# Or using Maven directly
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 📚 API Documentation

### Base URL
```
http://localhost:8080/api/player
```

### Endpoints

#### Get All Players
```http
GET /api/player
```

#### Get Players with Filters
```http
GET /api/player?name={playerName}
GET /api/player?team={teamName}
GET /api/player?position={position}
GET /api/player?nation={nationality}
GET /api/player?team={teamName}&position={position}
```

#### Add New Player
```http
POST /api/player
Content-Type: application/json

{
  "playerName": "Player Name",
  "nationality": "Country",
  "age": 25,
  "position": "FW",
  "team": "Team Name",
  "mp": "30",
  "starts": 28,
  "min": 2520.0,
  "gls": 15.0,
  "ast": 8.0,
  "pk": 2.0,
  "crdy": 3.0,
  "crdr": 0.0,
  "xg": 12.5,
  "xag": 7.2
}
```

#### Update Player
```http
PUT /api/player
Content-Type: application/json

{
  "playerName": "Player Name",
  // ... other fields
}
```

#### Delete Player
```http
DELETE /api/player/{playerName}
```

### Player Statistics Fields

| Field | Description |
|-------|-------------|
| `playerName` | Player's full name (Primary Key) |
| `nationality` | Player's nationality |
| `age` | Player's age |
| `position` | Playing position (FW, MF, DF, GK) |
| `team` | Current team |
| `mp` | Matches played |
| `starts` | Number of starts |
| `min` | Total minutes played |
| `gls` | Goals scored |
| `ast` | Assists provided |
| `pk` | Penalties scored |
| `crdy` | Yellow cards received |
| `crdr` | Red cards received |
| `xg` | Expected goals |
| `xag` | Expected assists |

## 🧪 Testing

Run the test suite using Maven:

```bash
./mvnw test
```

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/tr/premier_zone/
│   │   ├── player/
│   │   │   ├── Player.java          # Entity class
│   │   │   ├── PlayerController.java # REST controller
│   │   │   ├── PlayerRepository.java # Data access layer
│   │   │   └── PlayerService.java   # Business logic
│   │   └── PremierZoneApplication.java # Main application class
│   └── resources/
│       └── application.properties   # Configuration
└── test/
    └── java/com/tr/premier_zone/
        └── PremierZoneApplicationTests.java
```

## 🔧 Configuration

The application uses the following key configurations:

- **Database**: PostgreSQL with automatic schema updates
- **JPA**: Hibernate with SQL logging enabled
- **Server**: Default Spring Boot embedded Tomcat server

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the terms specified in the LICENSE file.

## 👨‍💻 Author

Developed for football enthusiasts and Premier League fans.

---

**Note**: Make sure to replace placeholder values (database credentials, repository URL) with your actual configuration before running the application. 