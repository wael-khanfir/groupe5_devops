pipeline {
    agent any
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
         stage('maven Build'){
               steps{
                    sh 'mvn clean install'
               }
         }
         stage('maven Build'){
                steps{
                      sh 'mvn clean install'
                }
         }
          stage('Docker') {
                 steps {

                       sh 'docker-compose up --detach'

                 }
           }

    }

}