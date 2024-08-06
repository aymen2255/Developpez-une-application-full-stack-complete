
# Projet Openclassroom: Développez une application full-stack complète

 

Generated with Java 11 and Angular CLI version 17.




## Installation

Clone the repository

```bash
git clone https://github.com/aymen2255/Developpez-une-application-full-stack-complete.git
```

### Install Backend

```bash
cd back
mvn clean install
```
### Run Backend Application 

```bash
mvn spring-boot:run
```

## Environment Variables

To run this project, you will need to add the following environment variables to your application.properties file

`db_name`

`db_username`

`db_password`

`secretKey`

`jwt_expiration`

### MySQL

SQL script for creating the schema is available ressources/data.sql

### Install Frontend

```bash
cd front
npm install
```
### Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200`. The application will automatically reload if you change any of the source files.


### Build Frontend Application 

```bash
Run ng build to build the project. The build artifacts will be stored in the dist/ directory.
```

#### If you use sql data file, there are a user for demonstration

```bash
    email: user@user.com
    password:  Start1234!
```