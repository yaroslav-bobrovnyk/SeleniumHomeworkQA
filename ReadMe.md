# Selenium Homework

## Installation
This assumes you have **Maven 3+**, **Git** and **Java 8** installed.

* Maven can be downloaded at: [link](http://maven.apache.org/download.html)
* Git can be downloaded at: [link](http://git-scm.com/download)
* Java 8 JDK can be downloaded at: [link](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Gherkin plugin can be download at: [link](https://plugins.jetbrains.com/plugin/9164-gherkin/)
## Run Auto Tests:

```
mvn clean test
```
## Run Auto-Tests on the different browsers

```
mvn test -Dcucumber.filter.tags="@<browser name>"
```

*Browsers:*
* Chrome;
* Firefox;
* Safari;
* IE;