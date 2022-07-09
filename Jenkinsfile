pipeline {
  agent any
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