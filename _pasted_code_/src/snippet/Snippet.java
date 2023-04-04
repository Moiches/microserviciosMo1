package snippet;

public class Snippet {
	spring:
	  application:
	    name: user-service
	  datasource:
	    url: jdbc:oracle:thin:PRUEBAS/PRUEBAS@localhost:1521:xe
	    username: PRUEBAS
	    password: 1234
	    driver-class-name: oracle.jdbc.OracleDriver
	  jpa:
	    database-platform: org.hibernate.dialect.Oracle10gDialect
	    properties:
	      hibernate:
	        format_sql: true
	    show-sql: true
	    hibernate:
	      ddl-auto: update
	
}
