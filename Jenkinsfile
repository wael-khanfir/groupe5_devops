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
        //  stage('integration Testing'){
        //       steps{
        //            sh 'mvn verify -DskipUnitTests'
        //       }
        //  }
        //  stage("Build & Tests") {
        //         steps {
        //             sh 'mvn -Dmaven.test.failure.ignore=true clean install'
        //         }

        //  }
         stage('Sonarqube') {
                            steps {
                              sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
                            }
                   }
         stage('Nexus') {
                   steps {
                     sh 'mvn deploy -Dmaven.test.skip=true -e'
                   }
                 }
         stage("Push to DockerHub") { 
                    steps { 
                      script {
                    
                        withCredentials([string(credentialsId: 'DockerId', variable: 'Docker')]) {
                          sh 'docker login -u hassene1212 -p ${Docker}'
                          sh 'docker image push hassene1212/devopsimage:$BUILD_NUMBER'
                }
            } 
            }
            
        }





    }

}