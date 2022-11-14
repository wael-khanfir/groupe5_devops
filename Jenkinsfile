pipeline {
    agent any
    environment {
        TAG = '3.0'
        REGISTRY='hassene1212/devops'
    }
    
    
    
    

    stages{
        stage('git checkout'){
            steps{
                git branch: 'hassentest', url: 'https://github.com/wael-khanfir/groupe5_devops.git'
            }
        }

         stage('Maven Clean') {
            steps {
                echo "Cleaning Project"
                sh 'mvn clean'
            }
        }
         stage('Maven Build') {
            steps {
                echo "Building Project"
                sh 'mvn clean install'
            }
        }
         stage('Unit Test') {
            steps {
                echo "Testing Project"
                sh 'mvn compile validate test'
            }
        }
        
        //  stage('Sonarqube') {
        //                     steps {
        //                       sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
        //                     }
        //            }
         stage('Nexus') {
                   steps {
                     sh 'mvn -Dmaven.test.skip=true deploy'
                   }
                 }
        
       
       
      
             stage('build docker image') {
            steps {
                script {
                    echo "Docker build image"
                    dockerImage = docker.build("${REGISTRY}:${TAG}")
                    //  sh 'docker build -t tpachatproject -f Dockerfile .'
                }
            }
        }
        stage('push docker hub') {
            steps {
                script {
                    echo "Docker push"
                    // withCredentials([string(credentialsId: 'hassene1212-Dockerhub', variable: 'dockerhub')]) {
                        sh 'docker login -u hassene1212 -p 22550887h'
                        sh 'docker push ${REGISTRY}:${TAG}'
                        sh 'docker logout'
                    
                }
            }
        }


        




    }

}