Předpoklady
- JDK 17, JDK 21
- Maven

Technologies
- AWS EC2 (Jenkins, Nexus, Sonar)
- Jenkins
- Nexus
- Sonar Sonatype

Pipeline:
Dev(git) –> Github -> Fetch code(git) Jenkins -> Build (Maven) -> Unit Test (Maven) -> Code Analysis (Sonarqube) -> Upload Artifact (Nexus Sonatype) 

Aplikace:
Jednoduchá aplikace sloužící pro výběr parkovacího místa v soukromém parkovacím domě.

In progress (development):
- front-end -> api
- připojení k databázi (SQL Oracle Developer) pomocí api
-objednávkový formulář místa
-správné validace - není plně funkční
-přihlašování
-zabezpečení
- testy

