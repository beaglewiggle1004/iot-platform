# iot-platform
Spring Boot 기반 센서데이터 조회 기능 구현

## Database
H2 Database Engine (in-memory)  
Console Endpoint - /api/h2-console

## API Documentation
Swagger  
Swagger UI Endpoint - /api/swagger-ui.html

### File Structure
```
.
├── main
│   ├── java
│   │   └── com
│   │       └── jtkim
│   │           └── iotplatform
│   │               ├── IotPlatformApplication.java
│   │               ├── config
│   │               │   ├── PersistenceConfig.java
│   │               │   ├── SecurityConfig.java
│   │               │   ├── SwaggerConfig.java
│   │               │   ├── WebInitializer.java
│   │               │   └── WebMvcConfig.java
│   │               ├── controller
│   │               │   ├── BaseController.java
│   │               │   ├── DeviceController.java
│   │               │   └── DeviceDataController.java
│   │               ├── demo
│   │               │   └── DeviceDataGenerator.java
│   │               ├── domain
│   │               │   ├── BaseAuditableEntity.java
│   │               │   ├── BaseEntity.java
│   │               │   ├── Data.java
│   │               │   ├── Device.java
│   │               │   └── DeviceData.java
│   │               ├── exception
│   │               │   ├── IoTPlatformError.java
│   │               │   ├── IoTPlatformErrorCode.java
│   │               │   ├── IoTPlatformErrorResponseHandler.java
│   │               │   └── IoTPlatformException.java
│   │               ├── interceptor
│   │               │   └── MeasurementInterceptor.java
│   │               ├── repository
│   │               │   ├── DeviceDataRepository.java
│   │               │   └── DeviceRepository.java
│   │               └── service
│   │                   ├── DeviceDataService.java
│   │                   └── DeviceService.java
│   └── resources
│       ├── application.properties
│       ├── data.sql
│       ├── logback.xml
│       ├── persistence-h2.properties
│       ├── static
│       │   ├── css
│       │   └── js
│       └── templates
└── test
    └── java
        └── com
            └── jtkim
                └── iotplatform
                    ├── DeviceDataServiceTest.java
                    ├── DeviceServiceTest.java
                    └── IotPlatformApplicationTests.java
```
