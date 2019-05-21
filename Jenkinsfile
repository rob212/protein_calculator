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
            }
        }
    }
}