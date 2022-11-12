pipeline {
    agent any
    environment {
        TAG = '3.0'
        REGISTRY='aymenouhiba/devops'
    }
    

    stages {
                stage('MVN clean') {
            steps {
                sh 'mvn clean'
                  }
        }
        stage('maven build') {
            steps {
                echo "build project"
                sh 'mvn -Dmaven.test.skip=true   package'
            }
        }

        stage('maven test') {
            steps {
                echo 'unit test'
                sh 'mvn test'
            }
        }
        stage('MVN SONARQUBE'){
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
             stage('deploy to nexus') {
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
                    withCredentials([string(credentialsId: 'docker', variable: 'dockerhub')]) {
                        sh 'docker login -u aymenouhiba -p ${dockerhub}'
                        sh 'docker push ${REGISTRY}:${TAG}'
                        sh 'docker logout'
                    }
                }
            }
        }
                     stage('docker compose up') {
            steps {
                sh 'docker-compose up -d'
            }
        }
        
    }
}
