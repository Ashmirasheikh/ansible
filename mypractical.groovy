pipeline {
    agent any
    stages {
        stage('pull') {
            steps {
                echo 'Hello World'
            }
        }
    }
}