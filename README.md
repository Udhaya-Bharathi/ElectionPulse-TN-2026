# 🗳️ ElectionPulse TN 2026

A full-stack election analytics platform for the **Tamil Nadu 2026 Legislative Assembly Election**, providing constituency-level, district-level, alliance-level and party-level insights through an interactive dashboard.

Built using **Spring Boot**, **React**, and **PostgreSQL**, the project focuses on transforming raw election results into meaningful analytics and visualizations.

---

## 📌 Features

### 📊 Dashboard

- Statewide election statistics
- Total Regions
- Districts
- Constituencies
- Political Parties
- Alliances
- Candidates

---

### 🏆 Alliance Analytics

- Alliance-wise Seat Distribution
- Alliance Seat Share (%)
- Alliance Vote Share (%)
- TV-style Seat Strip Visualization
- Interactive Pie Charts

---

### 🏛️ Party Analytics

- Party-wise Seat Distribution
- Party Seat Share
- Party Vote Share
- Party Performance Comparison

---

### 🗺️ District Performance

- District-wise election summary
- Winning alliance
- Winning party
- Total seats won
- Vote share comparison
- District search with autocomplete

---

### 📈 Analytics

- Seat Distribution
- Vote Share Analysis
- Alliance Performance
- Party Performance
- District-level Performance
- Interactive Charts
- Dynamic REST APIs

---

## 🛠 Tech Stack

### Frontend

- React (Vite)
- Material UI
- Axios
- Recharts

### Backend

- Spring Boot 4
- Java 21
- Spring Data JPA
- REST APIs

### Database

- PostgreSQL

### Deployment

- Railway (Backend & PostgreSQL)
- GitHub

---

# 🏗 Project Architecture

```

React (Vite)
│
▼
REST APIs
(Spring Boot)
│
▼
Analytics Service
│
▼
Spring Data JPA
│
▼
PostgreSQL Database

```

---

# 📂 Project Structure

```

ElectionPulse

├── backend
│ ├── controller
│ ├── dto
│ ├── entity
│ ├── repository
│ ├── service
│ ├── config
│ └── util
│
├── frontend
│ ├── components
│ ├── pages
│ ├── services
│ ├── api
│ └── assets

```

---

# 📡 REST APIs

| Method | Endpoint | Description |
|----------|-----------------------------------------|-----------------------------------|
| GET | /api/dashboard/stats | Dashboard Statistics |
| GET | /api/analytics/district-performance | District Performance |
| GET | /api/analytics/district/{district} | District Details |
| GET | /api/analytics/alliance-performance | Alliance Seat Count |
| GET | /api/analytics/party-performance | Party Seat Count |
| GET | /api/analytics/alliance-vote-share | Alliance Vote Share |
| GET | /api/analytics/party-vote-share | Party Vote Share |

---

# 📊 Database Statistics

| Entity | Count |
|----------|------:|
| Regions | 6 |
| Districts | 38 |
| Assembly Constituencies | 234 |
| Political Parties | 105 |
| Alliances | 6 |
| Election Records | 4257 |

---

# 📷 Screenshots

## Dashboard

> Add screenshot here

---

## Alliance Analytics

> Add screenshot here

---

## Party Analytics

> Add screenshot here

---

## District Performance

> Add screenshot here

---

# 🚀 Getting Started

## Clone Repository

```bash
git clone https://github.com/Udhaya-Bharathi/ElectionPulse.git
```

Backend

```bash
cd backend

./mvnw spring-boot:run
```

Frontend

```bash
cd frontend

npm install

npm run dev
```

---

# 💡 Future Enhancements

- 🤖 AI-powered Election Insights
- 🗺️ Interactive Constituency Maps
- 📈 Multi-election Trend Analysis (2021 vs 2026)
- 📤 Export Reports (PDF / Excel)
- 🌙 Dark Mode
- 📱 Mobile Responsive Dashboard
- 🔍 Candidate-level Analytics
- 📊 Predictive Election Models

---

# 📚 Learning Outcomes

This project strengthened my understanding of:

- Full Stack Web Development
- REST API Design
- Spring Boot Architecture
- Database Design & Normalization
- React Component Design
- Data Visualization
- Election Data Analytics
- Backend Deployment
- PostgreSQL Query Optimization
- Git & GitHub Workflow

---

# 👨‍💻 Author

**Udhaya Bharathi N**

Final Year Undergraduate  
Department of Electrical and Electronics Engineering (EEE)  
SSN College of Engineering

GitHub: https://github.com/Udhaya-Bharathi

---

# ⭐ If you found this project interesting, consider giving it a star!
