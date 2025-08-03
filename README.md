Předpoklady
- JDK 17, JDK 21
- Maven

Technologies
- AWS EC2 (Jenkins, Nexus, Sonar)
- Jenkins
- Nexus
- Sonar Sonatype
- Oracle SQL DB

Pipeline:
Dev(git) –> Github -> Fetch code(git) Jenkins -> Build (Maven) -> Unit Test (Maven) -> Code Analysis (Sonarqube) -> Upload Artifact (Nexus Sonatype) 

Aplikace:
Jednoduchá aplikace sloužící pro výběr parkovacího místa v soukromém parkovacím domě.

In progress (development):
- front-end (react) -> api ?
-přihlašování
-zabezpečení
- testy

