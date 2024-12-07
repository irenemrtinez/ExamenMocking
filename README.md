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
