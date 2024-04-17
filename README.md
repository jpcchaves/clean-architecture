# Spring Boot - Clean Architecture

![CleanArchitecture.jpg](https://blog.cleancoder.com/uncle-bob/images/2012-08-13-the-clean-architecture/CleanArchitecture.jpg)

This document outlines the process used to develop a Spring Boot application using Clean Architecture.

The application's architecture was developed using Java Modularity to construct its various layers. They include:

1. **Enterprise Business Rules**: Also referred to as the domain model, this layer encapsulates all the business rules specific to the system.
2. **Application Business Rules**: Also known as use cases, these rules are not system-specific but application-specific.
3. **Interface Adapters**: These adapters convert data from the format most convenient for use cases and entities to the format most convenient for databases or the web.
4. **Frameworks and Drivers**: The outermost layer, including frameworks and tools such as the database and web server.

This layer segregation ensures that business rules govern the system, with technology-specific code existing at the periphery.

For this implementation, I chose the following Java Modules:

1. **Core Module**: Housing all the business rules, domain entities, and exceptions, this module forms the heart of the application. By keeping it independent of other modules, the business logic remains decoupled and reusable.
2. **Usecase Module**: This module implements application-specific use cases. Its separation from the core business logic ensures that use case changes do not directly impact the domain logic. It acts as an intermediary between the Core module and the outer layers, providing a business operations interface.
3. **Application Module**: This module focuses on use case implementation and gateway interface definition. Our approach breaks down into:
    1. **Use Case Implementation**: We encapsulate the business logic by implementing concrete use case classes that correspond to the interfaces defined in the Use Case Module. This ensures each use case is precisely defined and isolated from infrastructure concerns.
    2. **Gateway Interfaces**: We establish gateway interfaces that serve as contracts for infrastructure-specific detail implementation. By defining clear contracts, we maintain separation of concerns and facilitate interchangeable implementations in the Infrastructure Module.
4. **Infrastructure Module**: This module implements the interfaces defined in the Core module, specifically those related to data access or external services. It's where integration with databases, external APIs, or other infrastructure components occurs, commonly using Spring Boot for infrastructure-related concerns.
