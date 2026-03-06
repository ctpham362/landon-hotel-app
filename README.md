# 🏨 Landon Hotel Scheduling Application

A full-stack hotel reservation scheduling application built with a **Java Spring Boot** backend and **Angular** frontend. The application was extended to support internationalization, multi-timezone scheduling, multi-currency pricing, and cloud containerization via Docker.

---

## 📋 Project Overview

This project was developed as part of WGU's Advanced Java course (D387). Starting from a base Spring Boot + Angular application, I implemented several real-world enterprise features including multithreaded language localization, timezone-aware scheduling, and Docker containerization for cloud deployment.

---

## ✨ Features

- **Bilingual Support (EN/FR)** — Displays welcome messages in both English and French simultaneously using separate Java threads, fulfilling Canadian bilingual requirements
- **Multi-Currency Pricing** — Reservation prices displayed in USD ($), Canadian Dollars (C$), and Euros (€)
- **Timezone Conversion** — Live presentation times displayed across Eastern (ET), Mountain (MT), and UTC time zones
- **Dockerized Deployment** — Full application containerized into a single Docker image, runnable with a single command
- **Angular Frontend** — Responsive UI connected to the Spring Boot REST backend

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java, Spring Boot |
| Frontend | Angular, TypeScript |
| Build Tool | Maven |
| Containerization | Docker |
| Version Control | Git / GitLab |
| IDE | IntelliJ IDEA |

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Node.js & npm
- Maven
- Docker (for containerized run)

### Run Locally

```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/landon-hotel.git
cd landon-hotel

# Build with Maven
mvn clean install

# Run the Spring Boot backend
mvn spring-boot:run
```

The Angular frontend will be served alongside the backend. Navigate to `http://localhost:8080` in your browser.

### Run with Docker

```bash
# Build the Docker image
docker build -t landon-hotel .

# Run the container
docker run --name D387_[studentID] -p 8080:8080 landon-hotel
```

---

## 🔑 Key Implementation Details

### Multithreaded Localization
Two Java threads run concurrently at startup — one displaying the English welcome message and one displaying the French welcome message — using `ResourceBundle` for locale-specific string management.

```java
Thread englishThread = new Thread(() -> displayWelcome(Locale.ENGLISH));
Thread frenchThread  = new Thread(() -> displayWelcome(Locale.CANADA_FRENCH));
englishThread.start();
frenchThread.start();
```

### Timezone Conversion
A dedicated Java method converts a single source time into ET, MT, and UTC using `ZoneId` and `ZonedDateTime`.

### Docker Deployment
A single `Dockerfile` builds the full application — compiling the Spring Boot backend, bundling the Angular frontend, and exposing the application on port 8080.

---

## ☁️ Cloud Deployment

The application is designed to be deployable to cloud platforms such as **AWS Elastic Beanstalk** or **Google Cloud Run** using the Docker image. The containerized build ensures consistent behavior across environments.

---

## 📁 Project Structure

```
landon-hotel/
├── src/
│   └── main/
│       ├── java/          # Spring Boot backend
│       └── resources/     # i18n resource bundles, application.properties
├── frontend/              # Angular frontend source
├── Dockerfile
└── pom.xml
```

---

## 📚 Course

**WGU D387 — Advanced Java**
Competencies: Multithreaded Programming · Cloud Deployment · Java Frameworks