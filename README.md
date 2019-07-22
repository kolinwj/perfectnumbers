# perfectnumbers

Briefly describes the design and implementation of perfect number computation REST API based on the thought process having in mind thoughout the assignment.  
Listed technology stack, design, coding, testing , CICD, further enhancements, limitations and recommendations.  

###### Technology Stack
- Java 8
- Apache CXF 3.3.2
- Jetty  3.3.2
- Junit 4.2
- Log4j2.12.0


## REST Service 

Used Apache CXF to implement the REST API service. Defined and developed below mentioned two REST APIs to perform the given specific tasks separately.

1. Check if a given number is perfect

    GET /v1/perfectnumbers/{number}

2. Find all perfect numbers between a range (start-end)

    GET /v1/perfectnumbers?starNumber={number}&endNumber={number}

Respone : JSON

base endpoint URL :http://localhost:8080/

## Design and implementation

Used design patterns where its appropriate. Above two services objects are constructed by using factory pattern. RestServiceFactory provides the service objects based on the specific service type required at runtime.
Leverage Apache CXF and used singleton resource provider which returns the same resource instance per every request. Thus resource consumption of the application will optimized.  

Used OOP concepts, encapsulation and inheritance to increase the code reusability and extensibility as well as the privacy of data in instances.   

###### Algorithm
Researched the implementation of perfect number theory. Tried both iteration (using nested loops) as well as most recommended optimum approach of using mersenne prime numbers theory. Using iterations could only able to get 3rd perfect number in less than a minute. It took more time to get the 4th perfect time. Thus implemented using mersenne prime numbers algorithm 2n-1 (2n - 1). 

## Build and Run

Used Gradle for the dependency management, build(compile) and run the project. Used updated stable latest versions of log4j2 for logs writing of the application.  Jetty embedded server firing up (TearUp and TearDown)  at the main application startup/end as well as similar Init methods being leverage when runs Junit integration testing to run the testsuite. 



## Testing and Verification

Used Junit(4) to implement unit and integration tests in the application. Both the APIs are being tested with basic functionalities.  Written a unit test case using parameterized to verify the first API code logic, which is the verification of given number is perfect or not. Utilized basic test starting that application is extendable to add more test units to strengthen the quality.

## Recommendations and further optimizations

- Use static code analysis tool(Sonarqube) to optimize the code quality. This can be easily integrate to the CICD pipeline. 

- Use Junit5 to enhance the testing capabilities. Below mentioned benefits are highlighted to enrich the application testability, quality and API to be more robust. 
More methods being introduced to utilize for specific test scenarios in both functional and non functional. 
  - BeforeEach/AfterEach
  - BeforeAll/AfterAll
  - assertThrows
  - assertTimeouts


-  Enhance REST API helthcheck and monitoring, versioning and security. Improve documentation(using swagger) to improve readability.

## Limitations
- Range of java long primitive to compute and find the next level of big prime numbers. Biginteger can be tried out for further attempt. 
