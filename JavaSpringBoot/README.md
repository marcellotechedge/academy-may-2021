# Overview
In questo branch c'è la versione del progetto realizzata live durante il corso.
In fase di lancio del progetto **receiver** si ottiene un errore:

```
***************************
APPLICATION FAILED TO START
***************************

Description:

Parameter 0 of constructor in com.te.accademy.webapi.client.api.CaseDistributionControllerApi required a single bean, but 2 were found:
        - com.te.accademy.webapi.client.invoker.ApiClient: defined in URL [jar:file:/C:/TE/Accademy/academy-may-2021/JavaSpringBoot/receiver/target/receiver-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/webapi-restclient-codegen-0.0.1-SNAPSHOT.jar!/com/te/accademy/webapi/client/invoker/ApiClient.class]
        - webApiClient: defined by method 'webApiClient' in class path resource [com/te/accademy/config/WebApiConfig.class]


Action:

Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
```


Questo errore è dovuto al fatto che swagger genera il progetto  **restapi** generando anche le annotation per Spring. 
Per esempio nel file

```
restapi/src/main/java/com/te/accademy/webapi/client/invoker/ApiClient.java
```
la classe è annotata come segue
```java
package com.te.accademy.webapi.client.invoker;
...

@Component("com.te.accademy.webapi.client.invoker.ApiClient")
public class ApiClient {
    public enum CollectionFormat {
```

Nel progetto **receiver**  la classe LoaderApplication è definita come

```java
package com.te.accademy;
...
@SpringBootApplication
public class LoaderApplication {
...
```

Spring quindi effetttua lo scan di tutti i subpackeges (tra cui **com.te.accademy.webapi.client.invoker**) trovando così già definita la classe ApiClient (annotata come @Component) e provocando quindi l'errore.

La soluzione è modificare il path del progetto **receiver** come **com.te.accademy.receiver**
