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
        //  stage('Nexus') {
        //            steps {
        //              sh 'mvn deploy -Dmaven.test.skip=true -e'
        //            }
        //          }
        
       
       
        // stage('Build Docker Image') {  
        //     steps{                     
	    //         sh'docker build -t hassene1212/devopsimage .'     
	    //         echo 'Build Image Completed'                
        //      }           
        // } 
        // stage('login dockerhub') {
        //                                 steps {
        //                               sh 'echo dckr_pat_-SnwrdC_ELsL6it2JT6cgIcAlrs | docker login -u hassene1212 --password-stdin'
        //                                     }
		//   }
        // stage('Push Docker Image') {  
        //     steps{   
        //         withDockerRegistry(credentialsId:"hassene1212-Dockerhub" ,url: "")                  
	    //         sh'docker push hassene1212/devopsimage'     
	    //         echo 'pushing Image Completed'                
        //      }           
        // } 
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