# perfectnumbers

Briefly describes the design and implementation of perfect number computation REST API based on the thought process having in mind throughout the assignment.  
Listed technology stack, design, coding, testing , CICD, further enhancements, limitations and recommendations.  

###### Technology Stack
- Java 8
- Apache CXF 3.3.2
- Jetty  3.3.2
- Junit 4.2
- Log4j2.12.0


## REST Service 

Used Apache CXF to implement the REST API service. Defined and developed below mentioned two REST APIs to perform given specific tasks separately.

1. Check if a given number is perfect

    GET /v1/perfectnumbers/{number}

2. Find all perfect numbers between a range (start-end)

    GET /v1/perfectnumbers?startNumber={number}&endNumber={number}

Response Type : JSON

base endpoint URL :http://localhost:8080/

## Design and implementation

Used design patterns where its appropriate during implementation. Above two API services' objects are constructed by using factory pattern. RestServiceFactory provides the service objects based on the specific service type required at runtime.
Leverage Apache CXF and used singleton resource provider which returns the same resource instance per every request. Thus resource consumption of the application will optimized.  

Used OOP concepts, encapsulation and inheritance to increase the code reusability and extensibility as well as the privacy of data in instances.   

###### Algorithm
Researched the implementation of perfect number theory. Tried both iteration (using nested loops) as well as most recommended optimum approach of using [mersenne primes](https://en.wikipedia.org/wiki/Mersenne_prime) number theory. Using iterations could only able to get third perfect number in less than a minute. It took more time to get the fourth perfect time. Thus implemented using mersenne prime numbers algorithm 2n-1 (2n - 1) which retuns 4th perfect number in subseconds. There could be some other algorithms exists which enhance the accuracy and timing this require further research.    

## Build and Run

Used Gradle for the dependency management, build(compile) and run the project. Used log4j2 for logs writing of the application.  Jetty embedded server firing up (TearUp and TearDown)  at the main application startup/end as well as when runs Junit integration testing to run the testsuite. Leverage and reuse same server Init methods both testing and deployment.



## Testing and Verification

Used Junit(4) to implement unit and integration tests in the application. Both the APIs are being tested with basic functionalities.  Written a unit test case using parameterized to verify the first API code logic, which is the verification of given number is perfect or not. Utilized basic test starting that application is extendable to add more test units to strengthen the quality.

## Recommendations and further optimizations

- Use static code analysis tool(Sonarqube) to optimize the code quality. This can be easily integrate to the CICD pipeline using gradle. 

- Use Junit5 to enhance the testing capabilities. Below mentioned benefits are highlighted to enrich the application testability, quality and API to be more robust. 
More methods being introduced by Junit5 to utilize for specific test scenarios in both functional and non functional. 
  - BeforeEach/AfterEach
  - BeforeAll/AfterAll
  - assertThrows
  - assertTimeouts

-  Further enhancement of REST API, 
   - Helthcheck and monitoring
   - Versioning, use correlation-id/token in messages
   - Security(use JAX-RS Token Authorization)
   - Documentation(using swagger) to improve readability
-  Specific to Apache CXF,
   - Simplicity and code first approach of Apache CXF allows build robust java REST APIs in both SOA and Microservice architectures. Feasible to write lightweight standard java REST APIs without using framworks.
   - In JAX-RS REST APIs resources are normally the nouns and coarse grained. Defining URIs should be descriptive, well structured and scoping information. Recommend always follow best practice of Resources and URIs.
   - Use Asynchronous client/server APIs to enhance the REST service throughput by non-blocking request handling. This would enhance the concurrency support when model operations are takes time.

## Limitations
- Range of java long primitive to compute and find the next level of big perfect numbers. Biginteger can be tried out for further attempt. 
