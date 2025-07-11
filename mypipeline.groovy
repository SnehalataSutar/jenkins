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
                sh 'sudo rm -rf target/'         // <-- Manually clean
                sh 'sudo mvn clean package'
                echo "Building Successful"
            }
        }
        // stage('building') {
        //     steps {
                
        //         sh 'sudo mvn clean package'
        //         echo "Building Successful"
        //     }
        // }
        // stage('Test') {
        //     steps {
        //         withSonarQubeEnv(installationName:'sonar-server', credentialsId: 'sonar-token') {
        //           sh'''
        //           mvn clean verify sonar:sonar \
        //           -Dsonar.projectKey=Student \
        //           -Dsonar.projectName='Student' \
        //           '''
        //     } 
        //       echo "Testing Successful"
        //     }        
        // }
        

        stage('Test') {
            steps {
                 withSonarQubeEnv(installationName:'sonar-server', credentialsId: 'sonar-token') {
                 sh '''
                 sudo mvn clean verify sonar:sonar \
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
