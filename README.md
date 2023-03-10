# Maven setup project.

[Maven](https://maven.apache.org) is a widely used build tool for Java projects.
[Clone](https://github.com/sgra64/setup.hello-maven)
this project and perform the steps described below.

References:

- Tim van Baarsen, *"Maven Cheat Sheet"*,
    [link](https://medium.com/@TimvanBaarsen/maven-cheat-sheet-45942d8c0b86).

- Digital Ocean, *"20+ Maven Commands and Options"*,
    [link](https://www.digitalocean.com/community/tutorials/maven-commands-options-cheat-sheet).



&nbsp;

---
## Maven project structure

The project structure follows the maven scaffold:

- All source code is under path `./src/main/java` (own package directories start here).

- JUnit test code is under path `./src/test/java` (with same package structure as in src).

- All artefacts compiled or generated by maven are in `./target`.

The project structure is:

```perl
--<setup.hello-maven>:      # project directory
 |
 +--<git>                   # local git repository
 +--.gitignore              # git .gitignore file
 +--pom.xml                 # maven project file
 |
 +--<src>:                  # source folder for code and tests
 |    +--<main>
 |    |    +--<java>        # src/main/java: package structure starts here
 |    |          |
 |    |          +--<de>
 |    |              +--<freerider>
 |    |                    + HelloMaven.java        # source code
 |    |
 |    +--<test>
 |         +--<java>        # src/test/java: test packages start here
 |               |
 |               +--<de>
 |                   +--<freerider>
 |                         + HelloMavenTest.java    # unit test code
 |     
 +--<target>:               # compiled and generated artefacts
 |    |
 |    +--hello-maven-0.0.1-SNAPSHOT.jar     # packaged build artefact (.jar)
 |    |
 |    +--<classes>          # compiled classes
 |    |
 |    +--<test-classes>     # compiled test classes
 |    |
 |    +--<surefire-reports> # test reports
 |    |
```

&nbsp;

---

## Maven Installation

Maven is implemented in Java and distributed as Java packages and scripts that
need to be unpacked in a local directory,
[download](https://maven.apache.org/download.cgi)
the binary .zip or .tar archive and unpack in a local directory on your system.
Set directory path into variable `MAVEN_HOME` and add to `$PATH`.

Add lines to `.bashrc`:

```sh
# set Maven environment variables
export M2_HOME="~/.m2"                      # local .m2 maven repository (maven will create)
export MAVEN_HOME="/c/opt/maven"            # enter path on your system
export PATH="${PATH}:${MAVEN_HOME}/bin"     # add maven path to PATH
```

Test that maven is available:

```
mvn --version
Apache Maven 3.8.6 (84538c9988a25aec085021c365c560670ad80f63)
Maven home: C:\opt\maven
Java version: 19, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk
-19
Default locale: en_US, platform encoding: UTF-8
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```


&nbsp;

---

## Maven Build Process

The build process begins for *ready-to-compile* source and test code.
It ends with a final artefact, here: `hello-maven-0.0.1-SNAPSHOT.jar`.

The .jar file contains all compiled classes and a MANIFEST that specifies
the class with the `main()` function to execute when started.

The maven build process consists of several stages
([link](https://www.digitalocean.com/community/tutorials/maven-commands-options-cheat-sheet)):

- `mvn validate` - validate project and pom.xml file for errors

- `mvn dependency:tree` - show tree of dependencies

- `mvn dependency:analyze` - analyse used and unused dependencies

- `mvn compile` - compile all source files

- `mvn test-compile` - compile unit tests

- `mvn test` - run unit tests

- `mvn package` - package compiled code into final artefact (.jar file in target)

- `mvn -DskipTests package` - package with not running unit tests
    (same as skipTests: false in pom.xml)

<!-- 1. `mvn site:site` - generate project web site with test reports -->


&nbsp;

---

## Building the Project

Perform the stages of the build process:

```
mvn compile
mvn test-compile
mvn test
mvn package
```

Artefacts have been created in the `target` directory.

```perl
ls -la
```

Output shows the `target` directory:

```sh
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 21 00:07 .git/
-rw-r--r--+ 1 svgr2 Kein  717 Nov  1 19:26 .gitignore
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 20 21:59 .vscode/
-rwxrwxr-x+ 1 svgr2 Kein 4086 Dec 21 00:53 README.md*
-rw-r--r--+ 1 svgr2 Kein 3054 Dec 20 23:57 pom.xml
drwxr-xr-x+ 1 svgr2 Kein    0 Dec 20 23:58 src/
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 21 00:53 target/      # <-- generated artefacts
```

Show the content of target directory with generated artefacts:

```perl
ls -la target
```

The `target` directory contains the generated artefacts, including the
main artefact: `hello-maven-0.0.1-SNAPSHOT.jar`:

```sh
total 12
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 21 00:45 ./
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 21 00:45 ../
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 21 00:45 classes/
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 21 00:45 generated-sources/
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 21 00:45 generated-test-sources/
-rwxrwxr-x+ 1 svgr2 Kein 3469 Dec 21 00:45 hello-maven-0.0.1-SNAPSHOT.jar*  # <-- .jar
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 21 00:45 maven-archiver/
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 21 00:45 maven-status/
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 21 00:45 surefire-reports/
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 21 00:45 test-classes/
```

The `target` directory can be removed any time and artefacts recreated with
maven build steps.

Execute the artefact:

```
java -jar target/hello-maven-0.0.1-SNAPSHOT.jar
```

Output:

```
Hello Maven!
```

```
java -jar target/hello-maven-0.0.1-SNAPSHOT.jar --withQuotes=true
```

Output:

```
"Hello Maven!"
```

Clean up the project:

```perl
mvn clean       # removes all generated artefacts and target directory
```

```perl
ls -la          # project directory in clean (pre-build) state
```

Output:

```
total 24
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 21 00:52 .
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 20 21:52 ..
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 21 00:07 .git
-rw-r--r--+ 1 svgr2 Kein  717 Nov  1 19:26 .gitignore
drwxrwxr-x+ 1 svgr2 Kein    0 Dec 20 21:59 .vscode
-rwxrwxr-x+ 1 svgr2 Kein 3629 Dec 21 00:52 README.md
-rw-r--r--+ 1 svgr2 Kein 3054 Dec 20 23:57 pom.xml
drwxr-xr-x+ 1 svgr2 Kein    0 Dec 20 23:58 src
```


Rebuild the project:

```sh
mvn package     # perform all build stages: compile -> test -> package
```

Run the executable artefact again:

```
java -jar target/hello-maven-0.0.1-SNAPSHOT.jar
Hello Maven!
```
