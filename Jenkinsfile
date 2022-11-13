pipeline {
    agent any
    
    

    stages{
        stage('git checkout'){
            steps{
                git branch: 'hassentest', url: 'https://github.com/wael-khanfir/groupe5_devops.git'
            }
        }
        //  stage('Unit Testing'){
        //       steps{
        //          sh 'mvn test'
        //       }
        //  }
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
        //  stage('Sonarqube') {
        //                     steps {
        //                       sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
        //                     }
        //            }
        //  stage('Nexus') {
        //            steps {
        //              sh 'mvn deploy'
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




    }

}