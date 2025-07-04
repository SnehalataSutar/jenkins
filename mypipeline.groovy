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
                withSonarQubeEnv(installationName: 'sonar-server', credentialsId: 'sonar-token') {
                 sh'''  
                    export MAVEN_HOME=/opt/apache-maven-3.9.10
                    export MAVEN_HOME
                    PATH=$PATH:$MAVEN_HOME/bin 
                    mvn clean verify sonar:sonar \
                    -Dsonar.projectKey=Student \
                    -Dsonar.projectName='Student'
                   '''
                } 
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
