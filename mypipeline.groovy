pipeline {
    agent {
        label 'node1'
    }
    stages {
        stage('pull') {
            steps {
                git branch: 'main', url: 'https://github.com/SnehalataSutar/studentdata.git'
                echo "Pull is Successful"
            }
        }
        stage('building') {
            steps {
                sh 'sudo mvn clean package'
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
