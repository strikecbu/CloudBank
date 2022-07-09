pipeline {
  agent {label 'Linux_GO'}
  tools {
      maven 'Maven_3.8.6'
      jdk 'jdk17'
  }
  stages {
    stage('mvn build') {
      steps {
        dir(path: 'accounts') {
          sh 'pwd'
          sh 'mvn spring-boot:build-image'
        }
      }
    }
  }
}
