# Pasos para crear un proyecto en maven y utilizar mockito
**1- Crear el proyecto con maven**
Para crear el proyecto en maven utiliza el siguiente comando 
```
mvn archetype:generate -DgroupId=com.es.mockitoexamen -DartifactId=mockito-examen -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

o también puedes hacerlo con

```
mvn archetype:generate \
-DgroupId=com.es.mockitoexamen \
-DartifactId=mockito-examen \
-DarchetypeArtifactId=maven-archetype-quickstart \
-DinteractiveMode=false
```
Si van en diferentes líneas.

Esto te crea un directorio cuyo ruta hasta los ficheros es los especificado en groupid, su identificador único. El proyecto se llamará con lo que escribas en artifactid, y archetypeartifactid es el arquetipo, la plantilla usada para generar el proyecto. Después, te generá dependencies, pero eso las veremos en el siguiente commit.

**2- Configurar el pom.xml**
Lo primero, borra el contenido de los archivos App.java y AppTest.java, ya que vamos a hacer un pom con lo que lo utilizo el profesor en clase.

Vamos a repasar ahora el pom.xml
-**Properties**
```
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <junit-jupiter.version>5.10.0</junit-jupiter.version>
    <maven.version>3.8.0</maven.version>
    <java.version>11</java.version>
    <mockito.version>5.7.0</mockito.version>
</properties>
```
El properties define variables del proyecto:
- `project.build.sourceEncoding` es la codificación del proyecto, aquí UTF-8
- `junit-jupiter.version` la versión de junit que vamos a usar
- `maven.version` la versión de maven a usar
- `java.version` la versión de java a usar
- `mockito.version` la versión de mockito a usar

Luego, si escribes en algun punto estos nombres entre llaves, será como escribir su valor
- **Dependencies**

```
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>${junit-jupiter.version}</version>
    <scope>test</scope>
</dependency>
```
Esta dependencia la que permite ejecutar pruebas JUnit5

```
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>${junit-jupiter.version}</version>
    <scope>test</scope>
</dependency>
```
Esta dependencia la que permite anotaciones y API de pruebas JUnit5

```
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>${mockito.version}</version>
    <scope>test</scope>
</dependency>
```
Esta dependencia permite crear elementos de Mockito como los Mock

```
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-junit-jupiter</artifactId>
    <version>${mockito.version}</version>
    <scope>test</scope>
</dependency>
```
Esta dependencia la que permite integrar Mockito y JUnit5

```
<dependency>
  <groupId>org.hamcrest</groupId>
  <artifactId>hamcrest</artifactId>
  <version>2.2</version>
  <scope>test</scope>
</dependency>
```
Esta dependencia da métodos assert

- **Build**
Como se configura y ejecuta el proyecto
```
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>${maven.version}</version>
  <configuration>
    <release>${java.version}</release>
  </configuration>
</plugin>
```
Configura maven para utilizar la versión de java escrita en la variable

```
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-surefire-plugin</artifactId>
  <version>2.22.0</version>
</plugin>

```
Hace que, al compilar, se ejecuten las pruebas automáticamente.
