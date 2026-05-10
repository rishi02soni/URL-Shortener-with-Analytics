#  URL Shortener with Analytics

Production-grade URL Shortener built using **Java, Spring Boot, MySQL, JPA, REST APIs** with real-time click analytics, redirection engine, scalable architecture, and enterprise-ready backend design.

---

#  Problem Statement

Long URLs are difficult to share, track, and manage across platforms such as social media, emails, campaigns, and internal systems.

Businesses and developers need a system that can:

- Convert long URLs into short readable links
- Redirect users instantly
- Track click counts and usage metrics
- Manage millions of URLs efficiently
- Provide scalable and secure architecture

This project solves that by building a **production-ready URL Shortener Service** similar to Bitly / TinyURL.

---

#  Features

- Generate Short URLs  
- Fast Redirection Engine  
- Click Analytics Tracking  
- Unique Short Code Generator  
- MySQL Persistent Storage  
- REST APIs  
- Layered Architecture  
- Production Ready Codebase  
- Exception Handling  
- Scalable Design

---

# 🏗️ Tech Stack
```
| Technology | Usage |
|-----------|------|
| Java 17 | Core Backend |
| Spring Boot | REST APIs |
| Spring Data JPA | ORM |
| MySQL | Database |
| Maven | Build Tool |
| Lombok | Boilerplate Reduction |
```

---

# Project Structure

```
src/main/java/com/project/urlshortener/

├── controller/
│   └── UrlController.java

├── service/
│   └── UrlService.java

├── repository/
│   └── UrlRepository.java

├── entity/
│   └── UrlMapping.java

├── dto/
│   └── UrlRequest.java

└── UrlShortenerApplication.java
```
# System Workflow
```
User submits Long URL
        ↓
POST /shorten API
        ↓
Generate Unique Short Code
        ↓
Store in MySQL
        ↓
Return Short URL

User opens Short URL
        ↓
GET /{code}
        ↓
Fetch Original URL
        ↓
Increase Click Count
        ↓
302 Redirect User
```
---
# Request Flow Chart
```
 ┌───────────────┐
 │   User Client │
 └──────┬────────┘
        │
        ▼
┌──────────────────┐
│ Spring Controller│
└──────┬───────────┘
       │
       ▼
┌──────────────────┐
│ Service Layer    │
│ Business Logic   │
└──────┬───────────┘
       │
       ▼
┌──────────────────┐
│ Repository Layer │
└──────┬───────────┘
       │
       ▼
┌──────────────────┐
│ MySQL Database   │
└──────────────────┘
```
---
# 📊 Analytics Graph
> Sample Click Analytics
Clicks received by short URLs.
<img width="488" height="243" alt="image" src="https://github.com/user-attachments/assets/568f2a11-68e4-4f80-b562-bb64ff437f02" />


