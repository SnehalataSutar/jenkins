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
              mvn clean verify sonar:sonar \
              -Dsonar.projectKey=Student \
              -Dsonar.projectName='Student' \
              -Dsonar.host.url=http://35.173.122.178:9000 \
  -Dsonar.token=sqp_2b7a3211dc1a6b07caceb719028fd83a08a17e3d
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
