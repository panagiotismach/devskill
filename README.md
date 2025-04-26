
# DevSkill App

Fullstack application made of:
- **Backend**: Java Spring Boot ([`devskill-api`](https://github.com/panagiotismach/devskill-api))
- **Frontend**: Vue.js ([`devSkill-ui`](https://github.com/panagiotismach/devSkill-ui))
- **Database**: PostgreSQL
- **Deployment**: Docker

---

## Requirements

- Git
- Docker
- Docker Compose

---

## Clone the Repository

Clone **with submodules**:

```bash
git clone --recurse-submodules https://github.com/panagiotismach/devskill.git
cd devskill
```

> If you forgot `--recurse-submodules` during cloning:

```bash
git submodule update --init --recursive
```

---

## Environment Configuration

Create a `.env` file at the root level.

Example `.env`:

```dotenv
DB_HOST=postgres
DB_PORT=5432
DB_NAME=your_database_name
DB_USER=your_database_user
DB_PASSWORD=your_database_password
```

This file sets database credentials used by PostgreSQL and the backend.

---

## Build and Run with Docker

Start everything (frontend, backend, and database):

```bash
docker compose up --build
```

Or run in detached mode:

```bash
docker compose up -d
```

---

## API Setup (Database Population)

After starting the Docker containers, **call the following API endpoints** to populate the database:

- **`GET /syncRepositories`** – Sync the repositories.
- **`GET /syncTrendingRepositories`** – Sync trending repositories.
- **`GET /aggregate-extensions`** – Aggregate extensions data.

These API calls will populate the database with the required data.

You can make the requests using **Postman** or any API client, or even **curl**. Example using `curl`:

```bash
curl -X GET http://localhost:8080/syncRepositories
curl -X GET http://localhost:8080/syncTrendingRepositories
curl -X GET http://localhost:8080/aggregate-extensions
```

---

## Access the Application

| Service    | URL                      |
|------------|---------------------------|
| Frontend   | [http://localhost:8081](http://localhost:8081) |
| Backend API| [http://localhost:8080](http://localhost:8080) |
| Database   | `localhost:5432` (PostgreSQL)

---

## Project Structure

```
/devskill-api     -> Java Spring Boot backend (submodule)
/devSkill-ui      -> Vue.js frontend (submodule)
/docker-compose.yml -> Docker orchestration file
/.env             -> Environment variables
```

---

## How It Works (Simple Architecture)

```
User -> Frontend (Vue.js, port 8081) -> Backend API (Spring Boot, port 8080) -> PostgreSQL DB (port 5432)
```

---

## Useful Docker Commands

- **Stop services**:

```bash
docker compose down
```

- **Rebuild cleanly**:

```bash
docker compose up --build --force-recreate
```

- **Follow logs**:

```bash
docker compose logs -f
```

- **Update submodules**:

```bash
git submodule update --remote --merge
```

---

## Notes

- Ensure ports **8080**, **8081**, and **5432** are free.
- PostgreSQL data persists via the `postgres_data` Docker volume.
- The backend and frontend use **multi-stage Docker builds** to keep images slim and production-ready.

---

# Quickstart for New Developers

```bash
git clone --recurse-submodules https://github.com/panagiotismach/devskill.git
cd devskill
cp .env.example .env  # Or create .env manually
docker compose up --build
```

Then open [http://localhost:8081](http://localhost:8081) 🚀
