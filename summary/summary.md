<a id="top"></a>

<p style="font-size: 24px;"><img src="./qct-icons/transform-logo.svg" style="margin-right: 15px; vertical-align: middle;"></img><b>Code Transformation Summary by Amazon Q </b></p>
<p><img src="./qct-icons/transform-variables-dark.svg" style="margin-bottom: 1px; vertical-align: middle;"></img> Lines of code in your application: 438 <p>
<p><img src="./qct-icons/transform-clock-dark.svg" style="margin-bottom: 1px; vertical-align: middle;"></img> Transformation duration: 13 min(s) <p>
<p><img src="./qct-icons/transform-dependencies-dark.svg" style="margin-bottom: 1px; vertical-align: middle;"></img> Planned dependencies replaced: 4 of 6 <p>
<p><img src="./qct-icons/transform-dependencyAnalyzer-dark.svg" style="margin-bottom: 1px; vertical-align: middle;"></img> Additional dependencies added: 9 <p>
<p><img src="./qct-icons/transform-smartStepInto-dark.svg" style="margin-bottom: 1px; vertical-align: middle;"></img> Planned deprecated code instances replaced: 0 of 0 <p>
<p><img src="./qct-icons/transform-listFiles-dark.svg" style="margin-bottom: 1px; vertical-align: middle;"></img> Files changed: 5 <p>
<p><img src="./qct-icons/transform-build-dark.svg" style="margin-bottom: 1px; vertical-align: middle;"></img> Build status in Java 17: <span style="color: #00CC00">SUCCEEDED</span> <p>

### Table of Contents

1. <a href="#build-log-summary">Build log summary</a> 
1. <a href="#planned-dependencies-replaced">Planned dependencies replaced</a> 
1. <a href="#additional-dependencies-added">Additional dependencies added</a> 
1. <a href="#deprecated-code-replaced">Deprecated code replaced</a> 
1. <a href="#other-changes">Other changes</a> 
1. <a href="#all-files-changed">All files changed</a> 
1. <a href="#next-steps">Next steps</a> 


### Build log summary <a style="float:right; font-size: 14px;" href="#top">Scroll to top</a><a id="build-log-summary"></a>

Amazon Q successfully built the upgraded code in Java 17. Here is a relevant snippet from the build log. To view the full build log, open [`buildCommandOutput.log`](./buildCommandOutput.log)

```
The Maven build was successful but generated some warnings. It scanned the project, cleaned it, compiled 10 source files to target/classes with some deprecation warnings, skipped test resources, compiled 3 test source files to target/test-classes, and reported overall build success in 4.938 seconds.
```


### Planned dependencies replaced <a style="float:right; font-size: 14px;" href="#top">Scroll to top</a><a id="planned-dependencies-replaced"></a>

Amazon Q updated the following dependencies that it identified in the transformation plan

| Dependency | Action | Previous version in Java 8 | Current version in Java 17 |
|--------------|--------|--------|--------|
| `io.springfox:springfox-swagger2` | Removed | 2.0.3 | - |
| `junit:junit` | Removed | 4.13.2 | - |
| `org.springdoc:springdoc-openapi-starter-webmvc-ui` | Added | - | 2.6.0 |
| `org.springframework.boot:spring-boot-starter-parent` | Updated | 2.7.2 | 3.3.7 |

### Additional dependencies added <a style="float:right; font-size: 14px;" href="#top">Scroll to top</a><a id="additional-dependencies-added"></a>

Amazon Q updated the following additional dependencies during the upgrade

| Dependency | Action | Previous version in Java 8 | Current version in Java 17 |
|--------------|--------|--------|--------|
| `com.amazonaws:aws-java-sdk-bom` | Updated | 1.12.405 | 1.12.772 |
| `com.fasterxml.jackson.core:jackson-databind` | Updated | 2.14.2 | - |
| `com.fasterxml.jackson.datatype:jackson-datatype-jsr310` | Updated | 2.13.2 | - |
| `io.springfox:springfox-swagger-ui` | Removed | 2.3.0 | - |
| `io.swagger.core.v3:swagger-annotations` | Added | - | 2.2.8 |
| `org.apache.commons:commons-lang3` | Updated | 3.12.0 | - |
| `org.apache.maven.plugins:maven-compiler-plugin` | Updated | 3.10.1 | - |
| `org.projectlombok:lombok` | Updated | 1.18.30 | - |
| `org.springframework.boot:spring-boot-starter-hateoas` | Updated | 2.1.4.RELEASE | - |

### Deprecated code replaced <a style="float:right; font-size: 14px;" href="#top">Scroll to top</a><a id="deprecated-code-replaced"></a>


Amazon Q replaced the following instances of deprecated code. An instance with 0 files changed
indicates Amazon Q wasn't able to replace the deprecated code.

| Deprecated code | Files changed |
|----------------|----------------|
| `java.lang.Boolean.Boolean(boolean)` | 1 |
| `java.lang.Byte.Byte(String)` | 1 |
| `java.lang.Character.Character(char)` | 1 |
| `java.lang.Double.Double(double)` | 1 |
| `java.lang.Float.Float(float)` | 1 |
| `java.lang.Integer.Integer(int)` | 1 |
| `java.lang.Short.Short(String)` | 1 |
| `java.math.BigDecimal.divide(BigDecimal,int)` | 1 |
| `java.math.BigDecimal.divide(BigDecimal,int,int)` | 1 |
| `java.math.BigDecimal.setScale(int,int)` | 1 |



### Other changes <a style="float:right; font-size: 14px;" href="#top">Scroll to top</a><a id="other-changes"></a>



### All files changed <a style="float:right; font-size: 14px;" href="#top">Scroll to top</a><a id="all-files-changed"></a>

| File | Action |
|----------------|--------|
| [pom.xml](../pom.xml) | Updated |
| [src/main/java/com/sample/qwords/QWordsApplication.java](../src/main/java/com/sample/qwords/QWordsApplication.java) | Updated |
| [src/main/java/com/sample/qwords/utils/Math.java](../src/main/java/com/sample/qwords/utils/Math.java) | Updated |
| [src/test/java/com/sample/qwords/controller/GameControllerTest.java](../src/test/java/com/sample/qwords/controller/GameControllerTest.java) | Updated |
| [src/test/java/com/sample/qwords/service/WordSelectionServiceTest.java](../src/test/java/com/sample/qwords/service/WordSelectionServiceTest.java) | Updated |

### Next steps <a style="float:right; font-size: 14px;" href="#top">Scroll to top</a><a id="next-steps"></a>

1. Please review and accept the code changes using the diff viewer.If you are using a Private Repository, please ensure that updated dependencies are available.
1. 
1. In order to successfully verify these changes on your machine, you will need to change your project to Java 17. We verified the changes using [Amazon Corretto Java 17](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/what-is-corretto-17.html
) build environment.
1. If this project uses Maven CheckStyle, Enforcer, FindBugs or SpotBugs plugins, Q Code Transformation will disable those plugins when we build the project to verify proposed upgrades.