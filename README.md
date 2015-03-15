# EJB Testing
This project started as a testing environment for practising EJB situations for the Java EE 6 Enterprise JavaBeans Developer certification.

## Interceptors
This component demonstrates the invocation order of interceptors.

## Exception Handling
This component demonstrates what happens when runtime and application exceptions occur within EJB's.

## Deployment
Start a standard wildfly instance and run: mvn clean install wildfly:deploy
Invoke operations via http://localhost:8080/<component>/rest/<operation>
See jboss-web.xml for the component name and the Service class for the actual REST end-points.

## Remarks
The components use REST-ful end-points as clients so they are easy to invoke via a browser (GET request). The components are standalone
and can be run individually.