pipeline {
  agent any

  tools {
    maven "MAVEN3.9"
    jdk "JDK21"
  }


    environment {
        registryCredential = 'ecr:us-east-1:aswcreds'
        appRegistry = "207567776873.dkr.ecr.us-east-1.amazonaws.com/javadevprojectappimg"
        JavaDEVProjectRegistry = "https://207567776873.dkr.ecr.us-east-1.amazonaws.com"
    }
   
 stages {
        stage('Fetch code') {
            steps {
               git branch: 'docker1', url: 'https://github.com/SarkaLang/JavaDEVProject.git'
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

      stage('UNIT TEST'){
            steps {
                sh 'mvn test'
            }
        }

      stage('INTEGRATION TEST'){
            steps {
                sh 'mvn verify -DskipUnitTests'
            }
        }

      stage('Checkstyle Analysis'){
            steps {
                sh 'mvn checkstyle:checkstyle'
            }
        }

      stage('Sonar Code Analysis'){
            environment {
              scannerHome = tool 'sonar7'
            }
            steps {
                withSonarQubeEnv('sonarserver') {
                sh '''
                     ${scannerHome}/bin/sonar-scanner \
                     -Dsonar.projectKey=javaDEVproject \
                     -Dsonar.projectName=javaDEVproject \
                     -Dsonar.projectVersion=1.0 \
                     -Dsonar.sources=src/ \
                     -Dsonar.java.binaries=target/classes \
                     -Dsonar.junit.reportsPath=target/surefire-reports/ \
                     -Dsonar.jacoco.reportsPath=target/jacoco.exec \
                     -Dsonar.java.checkstyle.reportPaths=target/checkstyle-result.xml
                '''
                }
            }
        }

      stage ("Qualisty Gate") {
          steps {
            timeout(time: 10, unit: 'MINUTES') {
               waitForQualityGate abortPipeline: true
             }
            }
         }


      stage('UploadArtifact') {
          steps {
             nexusArtifactUploader(
              nexusVersion: 'nexus3',
              protocol: 'http',
              nexusUrl: '172.31.29.17:8081',
              groupId: 'QA',
              version: "${env.BUILD_ID}-${env.BUILD_TIMESTAMP}",
              repository: 'javadev-repo',
              credentialsId: 'nexus-devlog',
              artifacts: [
                [artifactId: 'JavaParkingProject',
                 classifier: '',
                 file: 'target/JavaParkingProject-1.0.war',
                 type: 'war']
               ]
            )
          }
        }

      stage('Build App Image') {
          steps {
       
            script {
                dockerImage = docker.build( appRegistry + ":$BUILD_NUMBER", "./Docker-files/app/multistage/")
                }
          }
    
        }

        stage('Upload App Image') {
          steps{
            script {
              docker.withRegistry( JavaDEVProjectRegistry, registryCredential ) {
                dockerImage.push("$BUILD_NUMBER")
                dockerImage.push('latest')
              }
            }
          }
        }



   }
}
