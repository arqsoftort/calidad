# Laboratorio de Calidad de Código

## Objetivo
En varias materias anteriores se incentivó a que la calidad del código sea cada vez mejor a medida que los alumnos avanzan en la carrera y en su experiencia en el desarrollo de software. Por lo tanto, es esperable que en Arquitectura de Software ya tengan incorporadas las buenas prácticas de la programación en general y por lo menos conocer un mínimo del estándar de codificación en Java.

Dado que es un requerimiento para el obligatorio, este laboratorio explica cómo instalar una herramienta de análisis de calidad de código estático y poder encontrar y resolver fácilmente los defectos del código.

## Introducción

### Estándares de Codificación en Java

Se sabe que el 80% del tiempo de vida de una aplicación es de mantenimiento y difícilmente este mantenimiento sea hecho por el autor del código original. Por lo tanto, la legibilidad del código (junto con muchos otros aspectos de diseño y arquitectura) ayuda a que este trabajo sea menos tedioso.

Por este motivo, con el correr de los años la comunidad Java ha ido tomando decisiones con respecto a las convenciones de codificación para contribuir al entendimiento y facilidad de refactoreo.

Para poner un ejemplo muy rápido, si vemos estas líneas de código:

```java
public static Integer SOME_IMPORTANT_NUMBER = 35;

int count = 0;

boolean BadlyNamedVariable = false;
```

Podemos deducir que la primera es una constante, la segunda es seguramente una variable local a un método y la tercera tiene un problema de nomenclatura. Todas estas deducciones podemos hacerlas gracias a que sabemos que las constantes se escriben en [screaming snake case](http://en.wikipedia.org/wiki/Snake_case), las variables locales en [lower camel case](http://en.wikipedia.org/wiki/CamelCase) y que en Java no hay ninguna convención para variables en [upper camel case](http://en.wikipedia.org/wiki/CamelCase).

Esas convenciones, junto con muchas otras, están definidas en la Documentación oficial de Java:

- http://www.oracle.com/technetwork/java/codeconventions-150003.pdf

Sin embargo, esa documentación lleva muchos años sin actualizarse y no todas las convenciones definidas son respetadas hoy en día. Por ejemplo, existía una restricción para que el largo de las líneas no sea mayor a 80 caracteres. Esto se debía a que los monitores de la época no contaban con la suficiente resolución para ver toda la línea sin tener que scrollear horizontalmente. Actualmente, ese límite puede ser ampliado a 120 (o un poco más) sin afectar a la visibilidad en los monitores actuales.

Por otro lado, el equipo de desarrollo de Java en Google publicó sus propias convenciones y está bastante más actualizado y claro que la oficial:

- http://google-styleguide.googlecode.com/svn/trunk/javaguide.html

Entonces, durante el curso y para la corrección del obligatorio, tomaremos ésta como la convención de codificación a respetar.

### Herramientas de Análisis de Código

El análisis estático de software es un tipo de análisis de software que se realiza sin ejecutar el programa (el análisis realizado sobre los programas en ejecución se conoce como análisis dinámico de software). El término se aplica generalmente a los análisis realizados por una herramienta automática, el análisis realizado por un humano es llamado comprensión de programas (o entendimiento de programas) como también revisión de código.

Estas herramientas ayudan a obtener métricas del software, realizar ingeniería inversa, detectar puntos débiles de seguridad o código vulnerable a fallas, etc.

Existen [varias herramientas](http://es.wikipedia.org/wiki/Anexo:Herramientas_para_el_an%C3%A1lisis_est%C3%A1tico_de_software) que ayudan a detectar problemas en la calidad del código para distintos lenguajes y enfocándose en distintos puntos.

En este caso nos enfocaremos en [**CheckStyle**](http://checkstyle.sourceforge.net/), una herramienta especializada en Java y de [código abierto](https://github.com/checkstyle/checkstyle) que se integra a NetBeans como [plugin](http://www.sickboy.cz/checkstyle/download.html) y nos permite visualizar los defectos de manera cómoda y rápida. Además, la herramienta permite elegir cuáles reglas aplicar, por lo tanto se puede configurar para que respete el estándar de Google.

## Ejemplo
En este ejemplo agregaramos CheckStyle con la configuración de Google a una aplicación en Java.

### 1. La aplicación

No es necesario crear una aplicación desde cero. El proyecto llamado `CalidadLab` en este repositorio es una aplicación con código de ejemplo que sirve para comprobar el funcionamiento correcto de CheckStyle. Por lo tanto, les recomendamos clonar el repositorio (repasar [Laboratorio de Git](https://github.com/arqsoftort/git)) y abrir el proyecto con NetBeans.

Al abrirlo, el código de la clase `CurrencyConverter` debería de esta manera:

![currency converter before checkstyle](http://cl.ly/image/3h18353f1U2K/Image%202014-09-08%20at%2017%3A10%3A14.png)

### 2. Agregar Plugin de CheckStyle a NetBeans

En la página oficial del [Plugin de CheckStyle](http://www.sickboy.cz/checkstyle/download.html) se puede obtener la URL para la instalación online del plugin o directamente descargar un archivo comprimido para instalarlo offline.

Para instalarlo online, se debe copiar la URL al XML correspondiente a la versión que se tenga de NetBeans y agregarla como Update Center en la configuración de plugins en NetBeans.

Para esto, se debe ir a Tools -> Plugins y al tab de Settings. Hacer clic en Add y como nombre de Provider escribir 'CheckStyle' y como URL pegar la que copiamos anteriormente.

Luego de agregar el Update Center, en el tab de Available Plugins podemos buscar 'CheckStyle', checkear los resultados que aparecen y hacer clic en Install.

Reiniciar NetBeans.

Para comprobar que el plugin haya quedado correctamente instalado, podemos volver a la ventana de Plugins y verlo en el tab Installed de esta manera:

![netbeans plugins window](http://cl.ly/image/2Z3U2N2V2G0R/Image%202014-09-08%20at%2017%3A00%3A46.png)

NOTA: Es conveniente trabajar con la última versión, que no necesariamente es la del screenshot.

### 3. Agregar archivo de configuración de CheckStyle

Luego de instalar CheckStyle, en las Preferencias de NetBeans, en la sección Miscellaneous, tenemos un nuevo tab para la configuración de CheckStyle.

En el primer campo de texto se debe especificar el path al archivo XML de las reglas de Google (por defecto usa las reglas oficiales de Java). Este archivo se puede obtener en éste repositorio con el nombre `google_checkstyle.xml`, así que si está clonado, está en la root del directorio.

El mismo archivo de configuración será usado para la corrección del obligatorio. Por lo tanto, les recomendamos trabajar desde el principio con él y no realizarle modificaciones (por ejemplo, apagar o modificar reglas para liberarse de warnings molestos).

Luego de agregarlo, la configuración debería quedar de esta manera:

![checkstyle config](http://cl.ly/image/1B0g1R1J1g0j/Image%202014-09-08%20at%2016%3A54%3A06.png)

### 4. Comprobar los nuevos warnings

Quizás luego de reiniciar NetBeans y/o compilar la aplicación, veremos el nuevo estado de la clase `CurrencyConverter` de esta manera:

![currency converter after checkstyle](http://cl.ly/image/2T1b2n0W2a3w/Image%202014-09-08%20at%2017%3A17%3A26.png)

### 5. Comprobar los Action Items

En caso de que no esté abierta, para ver la ventana de Action Items se debe ir a Window -> Action Items.

En esta ventana se mostrarán todos los defectos encontrados por CheckStyle en el código.

Al principio, veremos algo como esto:

![initial action items](http://cl.ly/image/18051c1S3Q3c/Image%202014-09-08%20at%2017%3A19%3A55.png)

Los defectos se pueden filtrar por clase, paquete o proyecto. Además, se pueden crear distintos filtros para enfocarse en determinados defectos a la vez. Pero se debe recordar que uno de los criterios de corrección del obligatorio tiene que ver con la cantidad de defectos detectados por CheckStyle. Por lo tanto, se aconseja tener siempre en cuenta esta ventana y no dejar todo para corregir al final.

### 6. Corregir defectos y comprobar que desaparezca el Action Item

Muchas veces la explicación sobre el defecto que aparece en el tooltip a la izquierda del código es suficiente. Por ejemplo:

![empty if block](http://cl.ly/image/1d1m3B2V1N0L/Image%202014-09-08%20at%2017%3A23%3A41.png)

En caso de necesitar más detalles, se recomienda consultar la [documentación oficial de CheckStyle](http://checkstyle.sourceforge.net/availablechecks.html), en la sección que lista todos los checkeos disponibles y compararla con el [archivo de configuración](https://github.com/arqsoftort/calidad/blob/master/google_checkstyle.xml) que está siendo usado.

Si consideran que falta o sobra alguna regla o propiedad de las mismas, les pedimos que nos informen a través de la sección de [Issues](https://github.com/arqsoftort/calidad/issues) del repositorio y para que el cambio sea considerado.

## Feedback
Por cualquier consulta sobre el laboratorio, pueden crear un [Issue](https://github.com/arqsoftort/calidad/issues) en la sección correspondiente y lo responderemos a la brevedad.

Por aportes sobre el código o documentación, por favor realizar un [Pull Request](https://github.com/arqsoftort/calidad/pulls) para que podamos evaluarlo e incluirlo.
