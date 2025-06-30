pipeline {
    agent {
        label 'node1'
    }
    stages {
        stage('pull') {
            steps {
                echo "Pulling Successful"
            }
        }
        stage('building') {
            steps {
                echo "Building Successful"
            }
        }
        stage('Test') {
            steps {
                echo "Testing Successful"
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploy Successful"
            }
        }
    }
}
