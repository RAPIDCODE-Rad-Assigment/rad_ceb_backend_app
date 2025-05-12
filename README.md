# rad_ceb_backend_app
Rapidcode ceb backend app

## How to set up the projects 

### Requirements

- JDK 17
- Maven 3.6.3
- Docker 20.10.17
- Docker Compose 1.29.2
- PostgreSQL 14.1

### Steps

1. Clone the repository
2. Open the application-dev.yml file and update the database url, username and password. Make sure to make a database as ceb_backend in postgresql
3. Navigate to the root directory of the project
4. Run the services in the docker compose file it will make a container in the docker desktop
5. Run `mvn clean install` to build the project
6. Start the application
7. Navigate to http://localhost:8080/api/v1/swagger-ui/index.html to see the api documentation
8. Navigate to http://localhost:1080/ to see the mails

!! But wait !!  The application is not ready to be used yet !!
Set the ddl-auto in the application-dev.yml to create drop from update and uncomment the command line runner in the ApiApplication main class and run the application,
This will create the admin user and roles see ApiApplication main class for future details,
Next stop the application and comment the command line runner and set the ddl-auto in the application-dev.yml to update back again and run the application again

Now the admin user and roles are made, and you are ready to use the application


!Important for frontend development!

### Complaint Enums 
Category :  BILLING, TECHNICAL, OTHER
Status:  PENDING, IN_PROGRESS, RESOLVED, REJECTED

### Meter enums
MeterStatus: ACTIVE, INACTIVE, FAULTY


### Meter Reading enums
ReadingStatus: PENDING, APPROVED, REJECTED, FLAGGED


### Role enums
RoleName : USER, ADMIN, METER_READER


### Token enums
TokenType : BEARER , PASSWORD_RESET












