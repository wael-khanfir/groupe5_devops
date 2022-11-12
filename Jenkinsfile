pipeline {
    agent any

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
    }
}
