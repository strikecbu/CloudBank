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
              sh 'mvn clean package -DskipTests'
            }
          }
        }
        stage('gateway-server') {
          steps {
            dir(path: 'gateway-server') {
              sh 'mvn clean package -DskipTests'
            }
          }
        }
        stage('eureka-server') {
          steps {
            dir(path: 'eureka-server') {
              sh 'mvn clean package -DskipTests'
            }
          }
        }
        stage('bank-config') {
          steps {
            dir(path: 'bank-config') {
              sh 'mvn clean package -DskipTests'
            }
          }
        }

        stage('accounts') {
          steps {
            dir(path: 'accounts') {
              sh 'mvn clean package -DskipTests'
            }
          }
        }

        stage('card') {
          steps {
            dir(path: 'cards') {
              sh 'mvn clean package -DskipTests'
            }
          }
        }

      }
    }
    stage('docker build') {
      parallel {

        stage('loans') {
          steps {
            dir(path: 'loans') {
              sh 'docker build -t andychentw/loans --no-cache .'
            }
          }
        }
        stage('gateway-server') {
          steps {
            dir(path: 'gateway-server') {
              sh 'docker build -t andychentw/gateway-server --no-cache .'
            }
          }
        }
        stage('eureka-server') {
          steps {
            dir(path: 'eureka-server') {
              sh 'docker build -t andychentw/eureka-server --no-cache .'
            }
          }
        }
        stage('bank-config') {
          steps {
            dir(path: 'bank-config') {
              sh 'docker build -t andychentw/bank-config --no-cache .'
            }
          }
        }

        stage('accounts') {
          steps {
            dir(path: 'accounts') {
              sh 'docker build -t andychentw/accounts --no-cache .'
            }
          }
        }

        stage('card') {
          steps {
            dir(path: 'cards') {
              sh 'docker build -t andychentw/cards --no-cache .'
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
