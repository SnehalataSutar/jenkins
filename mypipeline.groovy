pipeline {
    agent {
        label 'node1'
    }
    stages {
        stage('pull') {
            steps {
                git 'https://github.com/SnehalataSutar/EKSCluster.git'
                echo "Pull is Successful"
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
