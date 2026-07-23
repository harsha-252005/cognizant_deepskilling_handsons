# Java FSE Mandatory Hands-ons

This repository is organised in the course delivery order. Every week has a
`README.md` that names the workbook exercises and gives a repeatable way to run
the code. Java projects use Java 17; Spring projects use Maven and H2 so no
external database is required for the demos.

| Week | Topics | Mandatory workbook coverage |
| --- | --- | --- |
| 1 | Design patterns, DSA, PL/SQL | Singleton, Factory Method, e-commerce search, financial forecasting, control structures, stored procedures |
| 2 | TDD, Mockito, SLF4J, Spring Core/Maven | JUnit setup/assertions/AAA, mocking/verifying, warning/error logs, IoC/DI/Maven |
| 3 | Spring Data JPA, Hibernate, Spring REST | Country service, query methods/mapping/HQL, country REST endpoints |
| 4 | Spring Cloud microservices | Account/loan services and Eureka registration |
| 5 | React foundations | React HOL 1–5 |
| 6 | React applications | React HOL 6–8 |
| 7 | React completion, Git, Angular | React HOL 9–17, Git HOL 1–5, Angular hands-on |

## Verification

Compile a plain Java exercise with `javac src/*.java` and run its demo class
from `src`. For Maven exercises use `mvn test`. JavaScript examples are
self-contained source exercises; install dependencies with `npm install` in an
individual app before starting it.

## Submission checklist

- Do not commit generated `target/`, `node_modules/`, IDE, or database files.
- Run the verification commands documented in each week before pushing.
- Commit only the `Java-FSE-Masterclass` folder and this repository's source
  changes; preserve any unrelated work already staged by the learner.
