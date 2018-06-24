pipeline {
    agent any
    tools { 
        maven 'maven-3.5.3' 
        jdk 'jdk8' 
    }
    stages {
        stage ('Initialize') {
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
                sh 'mvn clean install'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
        stage('Tests'){
            parallel{
                stage('Unit tests') {
                    steps {
                        echo 'Testing..'
                        sh 'mvn test'
                    }
                }
                stage('Integration test'){
                    steps {
                        echo 'Testing..'
                        sh 'mvn failsafe:integration-test'
                    }
                }
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}