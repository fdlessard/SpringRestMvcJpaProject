# RestSpringMvcJpaApp

[![License](http://img.shields.io/:license-mit-blue.svg)](https://github.com/fdlessard/maven_template_app/blob/master/LICENSE)

Run the tests:
===

$ mvn test


Start the tomcat application server:
===

mvn clean install tomcat7:run

mvn clean install jetty:run


Tomcat vm args (for instrumentation)
====================================

-javaagent:/.../.../.m2/repository/org/springframework/spring-instrument/4.3.1.RELEASE/spring-instrument-4.3.1.RELEASE.jar -noverify


Url of the Application:
===

http://localhost:8080/RestSpringMvcJpaApp/hello
