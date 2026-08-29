# MySpringBootSetGoal

Spring Boot app to store daily goals in a database so data is remembered day by day.

## Features
- Save or update one goal per day
- Fetch goals by date range
- Persistent storage (H2 file by default, PostgreSQL in deployment)

## API
- `POST /api/daily-goals`
  ```json
  {
    "goalDate": "2026-08-29",
    "goal": "Finish backend task",
    "completed": false
  }
  ```
- `GET /api/daily-goals?fromDate=2026-08-01&toDate=2026-08-31`

## Local run
```bash
mvn spring-boot:run
```

## Deployment-ready flow
1. Build and test in CI with GitHub Actions (`.github/workflows/ci.yml`)
2. Build Docker image and push to GHCR on `main` pushes
3. Run with PostgreSQL using:
```bash
docker compose up --build
```
