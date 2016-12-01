
### Datasource configuration

To configure datasource go to the JBoss/Wildfly standalone.xml config file, find subsystem with "domain:datasource" namespace and add datasource

Add config like following in datasource subsystem:

```
<datasources>
  <datasource jndi-name="java:jboss/datasources/todojavaee" pool-name="todojavaee" enabled="true"  use-java-context="true">
  <connection-url>jdbc:mysql://localhost:3306/todojavaee</connection-url>
  <driver>mysql</driver>
    <security>
      <user-name>root</user-name>
      <password>root</password>
    </security>
  </datasource>
  <drivers>
    <driver name="mysql" module="com.mysql">
      <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
    </driver>
  </drivers>
</datasources>
```

And add com.mysql module in JBoss/Wildfly "modules". There is example of module.xml

```
<module xmlns="urn:jboss:module:1.1" name="com.mysql">
  <resources>
    <resource-root path="mysql-connector-java-5.0.8-bin.jar"/>
  </resources>
  <dependencies>
    <module name="javax.api"/>
    <module name="javax.transaction.api"/>
  </dependencies>
</module>
```