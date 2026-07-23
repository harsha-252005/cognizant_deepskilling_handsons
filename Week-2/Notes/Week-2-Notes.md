# Week-2 Notes — Spring Core, Maven, Spring Boot, Spring Data JPA, Hibernate

## Spring Core Key Concepts
| Concept | Description |
|---|---|
| IoC Container | Spring manages object creation and lifecycle |
| Dependency Injection | Constructor / Setter / Field injection |
| Bean Scope | Singleton (default), Prototype, Request, Session |
| @Component | Marks a class as a Spring-managed bean |
| @Autowired | Injects a dependency automatically |
| @Configuration + @Bean | Java-based bean configuration |
| AOP | Aspect-Oriented Programming — cross-cutting concerns |

## Spring Boot Key Concepts
| Concept | Description |
|---|---|
| @SpringBootApplication | Combines @Configuration + @EnableAutoConfiguration + @ComponentScan |
| Auto-configuration | Spring Boot configures beans based on classpath |
| application.properties | Externalized configuration |
| Embedded Server | Tomcat/Jetty bundled — no WAR deployment needed |
| Actuator | Production-ready monitoring endpoints |

## Spring Data JPA Key Concepts
| Concept | Description |
|---|---|
| JpaRepository | Extends CrudRepository + PagingAndSortingRepository |
| Derived Queries | findByName(), findByAgeGreaterThan() |
| @Query | Custom JPQL or native SQL |
| @Transactional | Wraps method in a DB transaction |
| Pageable | Pagination and sorting support |

## Maven Key Commands
```bash
mvn clean          # Delete target/
mvn compile        # Compile source
mvn test           # Run tests
mvn package        # Create JAR/WAR
mvn install        # Install to local repo
mvn spring-boot:run  # Run Spring Boot app
```

## Hibernate Entity States
1. Transient  — new object, not associated with Session
2. Persistent — associated with Session, changes tracked
3. Detached   — was persistent, Session closed
4. Removed    — marked for deletion
