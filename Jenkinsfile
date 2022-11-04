pipeline {
    agent any
    environment{
        DOCKERHUB_CREDENTIALS = credential('hassene1212-Dockerhub')
    }
    stages{
        stage('git checkout'){
            steps{
                git branch: 'hassentest', url: 'https://github.com/wael-khanfir/groupe5_devops.git'
            }
        }
         stage('Unit Testing'){
              steps{
                 sh 'mvn test'
              }
         }
         stage('integration Testing'){
              steps{
                   sh 'mvn verify -DskipUnitTests'
              }
         }
         stage("Build & Tests") {
                steps {
                    sh 'mvn -Dmaven.test.failure.ignore=true clean install'
                }

         }





    }

}