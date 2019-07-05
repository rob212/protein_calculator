pipeline {
    agent { docker { image 'rob212/jenkins-java-git-slave'}}
    stages {
        stage("Compile") {
            steps {
                sh "./gradlew compileJava"
            }
        }

        stage("Unit tests") {
            steps {
                sh "./gradlew test"
                publishHTML (target: [
                    reportDir: 'build/reports/tests/test',
                    reportFiles: 'index.html',
                    reportName: "Unit test report"
                ])
            }
        }

        stage("Code coverage") {
            steps {
                sh "./gradlew jacocoTestReport"
                publishHTML (target: [
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: "Jacoco Code Coverage Report"
                ])
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }

        stage("Static analysis") {
            steps {
                sh "./gradlew checkstyleMain"
            }
        }

         stage('Package') {
            steps {
                sh "./gradlew build"
            }
        }

        stage("Docker build") {
            steps {
                sh "docker build -t rob212/calculator ."
            }
        }

        stage('Docker push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh "docker login -u=${USERNAME} -p=${PASSWORD}"
                    sh "docker push rob212/protein_calculator"
                }
            }
        }
    }
     post { 
        always { 
            publishHTML (target: [
                    reportDir: 'build/reports/checkstyle',
                    reportFiles: 'main.html',
                    reportName: "Checkstyle Static Analsis Report"
                ])
        }
    }
}