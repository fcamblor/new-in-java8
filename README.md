# What's new in Java 8 #
This project explores major new features of Java 8.

Note: The master branch contains code that compiles with the JDK jdk-8-ea-bin-b92-windows-x64-30_may.exe.

## Description ##
### Project Lambda - JSR 335
- **org.isk.lambda.old**: Getting a sub-list from a predefined condition.
- **org.isk.lambda.sams**: Getting a sub-list from an undefined condition using Fonctional Interfaces.
- **org.isk.lambda.references**: Using the [sort()] method of [ArrayList](http://download.java.net/jdk8/docs/api/java/util/ArrayList.html) with a reference of a static method
- **org.isk.lambda.functions**: Using Functional Interfaces from the package [java.util.function](http://download.java.net/jdk8/docs/api/java/util/function/package-summary.html).
- **org.isk.lambda.stream**: Exploring few method of the new [Stream](http://download.java.net/jdk8/docs/api/java/util/stream/Stream.html) interface.

### Date and Time - JSR 310
- **org.isk.datetime.MachineTimeTest**: Exploring [java.time.Instant](http://download.java.net/jdk8/docs/api/java/time/class-use/Instant.html) and [java.time.Duration](http://download.java.net/jdk8/docs/api/java/time/class-use/Duration.html) classes.
- **org.isk.datetime.HumanTimeTest**: Exploring [java.time.LocalDate](http://download.java.net/jdk8/docs/api/java/time/LocalDate.html), [java.time.LocalTime](http://download.java.net/jdk8/docs/api/java/time/LocalTime.html), [java.time.LocalDateTime](http://download.java.net/jdk8/docs/api/java/time/LocalDateTime.html), [ZoneId](http://download.java.net/jdk8/docs/api/java/time/ZoneId.html), [ZoneOffset](http://download.java.net/jdk8/docs/api/java/time/ZoneOffset.html), [ZonedDateTime](http://download.java.net/jdk8/docs/api/java/time/ZoneDateTime.html), and [OffsetDateTime](http://download.java.net/jdk8/docs/api/java/time/OffsetDateTime.html) classes.

### Nashorn - JEP 174
####Invoking JavaScript from Java
*org.isk.nashorn.NashornTest* and *<project>/src/test/resources/simple.js*

####Invoking Java from JavaScript
<project_path>/src/test/resources: jjs_*.js

To execute theses 4 scripts, you need to use jjs provided by the JDK8.

**Example**:

	<project_path>/src/test/resources$ jjs jjs_Packages.js

[sort()]: http://download.java.net/jdk8/docs/api/java/util/ArrayList.html#sort(java.util.Comparator)