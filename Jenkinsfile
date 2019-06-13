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