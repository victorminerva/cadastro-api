# Cadastro API

This project will provide services RESTFUL for registering people.
Using the Spring, Hibernate, JPA and Jersey frameworks.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* Eclipse IDE ([Download](http://www.eclipse.org/downloads/eclipse-packages/)) or another of the your preference.
* MySQL Server Installed. ([Download](https://dev.mysql.com/downloads/mysql/))
* Maven. ([Download](https://maven.apache.org/download.cgi))
* Tomcat 9. ([Download](https://tomcat.apache.org/download-90.cgi))
* The project to your directory.
```
git clone https://github.com/victorminerva/cadastro-api.git
```

I used the MySQL as database, but if you prefer another database feel free to change the files pom.xml and the db.properties.
e.g.
pom.xml:
```
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>5.1.38</version>
</dependency>
```
db.properties:
```
mysql.driver=com.mysql.jdbc.Driver
mysql.url=jdbc:mysql://localhost:3306/cadastro-api
mysql.user=<your user>
mysql.password=<your password>
```

### Installing

**Step 1.** Create a schema in database:
```
CREATE SCHEMA CADASTRO-API;
```
 
**Step 2.** Import your project as Existing Maven Projects to into IDE workspace.

**Step 3.** Add the Tomcat 9 Server in your IDE and after that add the project into Tomcat.

**Step 4.** Run Tomcat.


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Victor Minerva** - [victorminerva](https://github.com/victorminerva)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the Apache License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc

