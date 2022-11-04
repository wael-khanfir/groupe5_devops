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
         
         stage('Maven Build'){
                steps{
                      mvn 'clean verify'
                      mvn 'clean jacoco:prepare-agent'
                      mvn 'clean jacoco:report'
                }
         }
    }

}