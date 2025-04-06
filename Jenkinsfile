pipeline {
  agent any

  tools {
    maven "MAVEN3.9"
    jdk "JDK21"
  }
  
  stages {
      stage('Fetch code') {
        steps{
         git branch: 'main', url: 'https://github.com/SarkaLang/JavaDEVProject.git'
        }
       }

      stage('Build') {
       steps{
        sh 'mvn install -DskipTests'
        }
        post{
          success {
           echo "Archiving artifact"
            archiveArtifacts artifacts: '**/*.war'
          }
        }
       }
  }
}
