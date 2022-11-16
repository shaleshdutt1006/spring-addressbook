# Address-Book







UseCase1-Create a Address book Spring
Project to cater to Crud operations instead of making REST call to JSONServer will now
make server calls to Address book Spring App
- Also test the REST API using CURL Commandsista 

















UseCase 2-Introducing DTO and Model to AddressBook
App - Note that we have kept the DTO and Model fairly
simplistic with only Name and Salary
- This is because we are still in the setup of the
Layers and once set we would make Employee
Payroll as full -fledged Object for Front End to make REST Call.
- Currently we will do CURL Call to ensure











 
UseCase3-Use Lombok Library to auto generate getters and setters for the DTO
- For Eclipse and IntelliJ Download Lombok Executable Jar and run the jar.
This will identify the IDE and install the add on 
- For VS Code Install Lombok 
- Add Lombok Dependency to POM File






















UseCase4-Use Lombok Library for
Logging and use data validation
- Note using Annotation @Slf4j at Class Level,
Logging is activated
- Note Logging Levels, Files and Patterns are
handled in application.properties
























UseCase5-Provide User Friendly Error Response in case validation fails Create a Custom Exception Handlers class and 
use @ControllerAdvice Annotation so that Spring Framework can call this class to handle Exceptions thrown during processing REST API Request.
To handle Validation Errors create @ExceptionHandler method for MethodArgumentNotValidException class is defined.






UseCase6-Add Logger to the Program




UseCase7-Ability to get addressbook by its pincode,mobile number using custom query in repository
