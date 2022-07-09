pipeline {
  agent {
    label 'Linux_GO'
  }

  environment {
    DOCKERHUB_CREDENTIALS=credentials('DockerHub')
  }
  

  stages {
    stage('mvn build') {
      parallel {
        stage('mvn build accounts') {
          steps {
            dir(path: 'accounts') {
              sh 'pwd'
              sh 'mvn spring-boot:build-image'
            }

          }
        }

        stage('mvn build card') {
          steps {
            dir(path: 'cards') {
              sh 'mvn spring-boot:build-image'
            }

          }
        }

      }
    }

    stage('docker login') {
      steps {
        sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin' 
      }
    }

    stage('push image') {
      parallel {
        
        stage('push image') {
          steps {
            dir(path: 'accounts') {
              sh 'docker push andychentw/accounts:latest'
            }
          }
        }

        stage('push cards images') {
          steps {
            dir(path: 'cards') {
              sh 'docker push andychentw/cards:latest'
            }

          }
        }

      }
    }

  }

  post {
    always {
      sh 'docker logout'
    }
  }
  tools {
    maven 'Maven_3.8.6'
    jdk 'jdk17'
  }
}