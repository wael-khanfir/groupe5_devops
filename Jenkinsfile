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

        //  stage('Maven Clean') {
        //     steps {
        //         echo "Cleaning Project"
        //         sh 'mvn clean'
        //     }
        // }
        //  stage('Maven Build') {
        //     steps {
        //         echo "Building Project"
        //         sh 'mvn clean install'
        //     }
        // }
        //  stage('Unit Test') {
        //     steps {
        //         echo "Testing Project"
        //         sh 'mvn compile validate test'
        //     }
        }
        
        //  stage('Sonarqube') {
        //                     steps {
        //                       sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
        //                     }
        //            }
        //  stage('Nexus') {
        //            steps {
        //              sh 'mvn deploy -Dmaven.test.skip=true -e'
        //            }
        //          }
           stage('Login') {
                    steps {
                            sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'

                    }
          }
          stage('pushing to dockerhub') {
                       steps {

                        sh'docker push hassene1212/devopsimage'


                         }
                    }




    // }

}