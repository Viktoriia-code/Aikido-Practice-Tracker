pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Viktoriia-code/Aikido-Practice-Tracker.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
