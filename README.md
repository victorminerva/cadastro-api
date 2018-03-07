# Cadastro API

This project will provide services for registering people.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Clone this project to your directory.

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
mysql.user=root
mysql.password=root
```

### Installing

...


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

