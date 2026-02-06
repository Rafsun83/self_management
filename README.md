## Spring-boot project run by command
``./mvnw spring-boot:run``
## Maven install in your application
``sudo apt install maven``
## Clean maven or build

``mvn clean``
## Added swagger for API Documentation 
``https://medium.com/javaguides/generate-rest-api-documentation-for-spring-boot-project-using-swagger-996e48fe0cea``
### Access Swagger
``http://localhost:8080/swagger-ui/index.html#/``

# (Spring security)
``Basic AUTH: Added spring security dependency and set password in application properties file instead of defaults user and password``
## 🔐 JWT Authentication Structure
```text
src/main/java
└── com/example/selfmanagement
    ├── config
    │   └── SecurityConfig.java       # Security filtering & filter chain setup
    ├── security
    │   └── jwt
    │       ├── JwtAuthFilter.java    # Request interceptor for token validation
    │       └── JwtService.java       # Token generation & parsing logic
    ├── controller
    │   └── AuthController.java       # Authentication endpoints (Login/Sign-up)
    └── dto
        ├── LoginRequest.java         # DTO for incoming credentials
        └── JwtResponse.java          # DTO for outgoing JWT tokens
```

### 📁 `config`
- **SecurityConfig.java**  
  Configures Spring Security, enables JWT-based authentication, disables session management, and registers the JWT filter.

### 📁 `security/jwt`
- **JwtService.java**  
  Responsible for generating, parsing, and validating JWT tokens.

- **JwtAuthFilter.java**  
  Intercepts incoming requests, extracts JWT from the `Authorization` header, validates it, and sets authentication in the security context.

### 📁 `controller`
- **AuthController.java**  
  Exposes authentication endpoints (e.g., login) and issues JWT tokens after successful authentication.

### 📁 `dto`
- **LoginRequest.java**  
  Data Transfer Object for receiving login credentials.

- **JwtResponse.java**  
  Data Transfer Object for returning the generated JWT token to the client.

### 📁 `JWT Generate note:`
- **JWT-**
  Pass userId and username for generate jwt token. Implemented here. 

#### `Why Utility Classes Should Be final`
- **Are not meant to be inherited** 
- **Contain static methods only** 
- **Represent helpers, not domain objects** 
- **No other class can extend this class** 