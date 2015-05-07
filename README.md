# sipt
Version 0.1 - SIPT es un proyecto empresarial enfocado a administrar la informacion de la empresa.

## Requerimientos
* JDK 7
* JEE 7
* JSF 2.2
* JPA 2.1
* EJB 3.0
* para el diagrama de ER se está usando la herramienta SQL Power Architect, esta como tal nos permite, diseñar el modelo y exportarlo a un script o a la base de datos directamente.
* como base de datos se esta usando Postgres 9.2.
* como IDE, se propone usar NetBeans v8.*. Aunque como el proyecto es maven, debe funcionar en cualquier IDE.
* como servidor de aplicaciones se recomienda usar Glassfish v4.2. Aunque el proyecto respeta la arquitectura JEE, por lo cual deberia correr sobre culquier servidor de aplicaciones que soporte JEE 7. 

## Que hacen los proyectos?
- **sipt:** proyecto maven que sirve para empaquetar todo lo correspondiente al proyecto, como documentos, diagramas, scripts, etc.
- **sipt-app:** proyecto java que contiene todos los fuentes del proyecto.

## Empezando
- Ejecutar el script db/create-database.sql
- Ejecutar el script db/create-objects.sql
- Ejecutar el script db/init-data.sql
- Si se requieren datos de pruebas, ejecutar el script db/init-testdata.sql
- Crear el datasource jdbc/SIPT en el servidor Glassfish [este paso se puede obviar, ya que dentro del proyecto existe un archivo de configuracion para glassfish, que cuando se ejecuta el proyecto, el se encarga de configurar los recursos JDBC].
- Realizar Build whit dependencies del proyecto **sipt**.
- Desplegar aplicativo en el servidor Glassfish.

## Roadmap
[ Disponible en google drive ] - https://docs.google.com/document/d/1rGqSOLp2SGu21I-RwBKa6hi09QXoeYq7CX1pE7IAjng/edit

**Con quien debo hablar?**
Fredy Wilches, fredy.wilches@softstudio.co - Diego Poveda, diego.poveda@softstudio.co
