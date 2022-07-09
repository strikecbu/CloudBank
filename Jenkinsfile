pipeline {
  agent {
    label 'Linux_GO'
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

  }
  tools {
    maven 'Maven_3.8.6'
    jdk 'jdk17'
  }
}