pipeline {
    agent any
    stages {
        stage('pull') {
            steps {
                git branch: 'main', url: 'https://github.com/Ashmirasheikh/studentapp-ui.git'
            }
        }
        stage('build') {
            steps {
                sh 'mvn package clean'
            }
        }
         stage('test') {
            steps { withsonarqube env ('sonar')
                sh 'mvn sonar:sonar'
            }
        }
    }
}