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

        stage('loans') {
          steps {
            dir(path: 'loans') {
              sh 'mvn spring-boot:build-image -DskipTests'
            }
          }
        }
        stage('gateway-server') {
          steps {
            dir(path: 'gateway-server') {
              sh 'mvn spring-boot:build-image -DskipTests'
            }
          }
        }
        stage('eureka-server') {
          steps {
            dir(path: 'eureka-server') {
              sh 'mvn spring-boot:build-image -DskipTests'
            }
          }
        }
        stage('bank-config') {
          steps {
            dir(path: 'bank-config') {
              sh 'mvn spring-boot:build-image -DskipTests'
            }
          }
        }

        stage('accounts') {
          steps {
            dir(path: 'accounts') {
              sh 'mvn spring-boot:build-image -DskipTests'
            }
          }
        }

        stage('card') {
          steps {
            dir(path: 'cards') {
              sh 'mvn spring-boot:build-image -DskipTests'
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
        
        stage('loans') {
          steps {
            dir(path: 'loans') {
              sh 'docker push andychentw/loans:latest'
            }
          }
        }
        stage('gateway-server') {
          steps {
            dir(path: 'gateway-server') {
              sh 'docker push andychentw/gateway-server:latest'
            }
          }
        }
        stage('eureka-server') {
          steps {
            dir(path: 'eureka-server') {
              sh 'docker push andychentw/eureka-server:latest'
            }
          }
        }
        stage('bank-config') {
          steps {
            dir(path: 'bank-config') {
              sh 'docker push andychentw/bank-config:latest'
            }
          }
        }
        stage('accounts') {
          steps {
            dir(path: 'accounts') {
              sh 'docker push andychentw/accounts:latest'
            }
          }
        }

        stage('cards') {
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
