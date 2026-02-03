# Flickard Backend

A REST API backend for the Flickard flashcard application built with Kotlin and Spring Boot.

## Tech Stack

- Kotlin 2.2
- Spring Boot 4.0
- PostgreSQL
- Flyway (database migrations)
- MapStruct (object mapping)
- Java 21

## Prerequisites

- JDK 21
- Docker (for PostgreSQL)

## Getting Started

### 1. Start PostgreSQL

```bash
./postgresql_docker.sh
```

Or manually:

```bash
docker run -p 5432:5432 \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_DB=postgres \
  postgres:17
```

### 2. Run the application

```bash
./gradlew bootRun
```

The server starts at `http://localhost:8080`.

## Configuration

Environment variables (with defaults):

| Variable | Default | Description |
|----------|---------|-------------|
| `DB_URL` | `jdbc:postgresql://localhost:5432/postgres` | Database URL |
| `DB_USER` | `postgres` | Database username |
| `DB_PASSWORD` | `postgres` | Database password |

## API Endpoints

### Packs

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/packs` | Get all packs |
| GET | `/packs/{id}` | Get pack by ID |
| POST | `/packs` | Create a new pack |

**Create Pack Request:**
```json
{
  "name": "My Pack",
  "premium": false,
  "priceCents": 0
}
```

### Cards

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/cards` | Get all cards |
| POST | `/cards` | Create a new card |

**Create Card Request:**
```json
{
  "front": "Question",
  "back": "Answer",
  "packId": 1
}
```

## Project Structure

```
src/main/kotlin/com/gunesteker/flickardbackend/
├── controllers/    # REST controllers
├── services/       # Business logic
├── repositories/   # JPA repositories
├── models/         # JPA entities
├── dtos/           # Data transfer objects
└── mappers/        # MapStruct mappers
```
