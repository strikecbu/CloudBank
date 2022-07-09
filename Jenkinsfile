pipeline {
  agent any
  tools {
      maven 'Maven_3.8.6'
  }
  stages {
    stage('showDir') {
      steps {
        dir(path: 'accounts') {
          sh 'pwd'
        }

      }
    }

    stage('mvn build') {
      steps {
        sh 'mvn spring-boot:build-image'
      }
    }

  }
}
