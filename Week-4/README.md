# Week 4 — Microservices with Spring Boot and Spring Cloud

The hand-on is split into an **Eureka discovery server**, an **account service**,
and a **loan service**. Each service exposes a health-style endpoint and uses
`spring.application.name` so it can be registered with Eureka when the Spring
Cloud dependencies are added to its Maven build.

The source below is deliberately framework-light at the domain boundary: the
controllers can be run as independent Spring Boot applications and are ready
to be wired to API Gateway/Eureka in the course environment.
