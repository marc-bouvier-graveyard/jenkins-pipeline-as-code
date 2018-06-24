pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
      }
    }
    stage('Build') {
      steps {
        echo 'Building..'
        sh 'mvn clean compile'
      }
    }
    stage('Tests') {
      parallel {
        stage('Unit tests') {
          steps {
            echo 'Testing..'
            sh 'mvn test'
          }
          post {
            always {
              junit '**/surefire-reports/**/*.xml'

            }

          }
        }
        stage('Integration test') {
          steps {
            echo 'Testing..'
            sh 'mvn test-compile failsafe:integration-test verify -Dskip.surefire.tests=true'
          }
          post {
            always {
              junit '**/surefire-reports/**/*.xml'

            }

          }
        }
      }
    }
    stage('Jacoco') {
      steps {
        jacoco()
      }
    }
    stage("Package"){
      steps{
        sh 'mvn package'
        archiveArtifacts(artifacts: '**/target/*.jar', fingerprint: true)
      }
    }
    stage('Sonar') {
      steps {
        sh '''mvn sonar:sonar \\
  -Dsonar.host.url=http://172.17.0.1:9000 \\
  -Dsonar.login=0309b3dc4d0ca5a4fc35d0f18428499c818616c6'''
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploying...'
      }
    }
  }
  tools {
    maven 'maven-3.5.3'
    jdk 'jdk8'
  }
}
