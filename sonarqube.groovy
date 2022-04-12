pipeline {
    agent any
    stages {
        stage('pull') {
            steps {
                git 'https://github.com/Ashmirasheikh/webhook.git'
            }
        }
         stage('build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('test') {
            steps { withSonarQubeEnv('21') {
                mvn 'sonar:sonar'
                }
            }
        }
    }
}