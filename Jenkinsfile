pipeline {
    agent any
    stages {
        stage('test') {
            steps {
                echo '애플리케이션 테스트'
                sh './gradlew test'
                echo '애플리케이션 테스트 완료'
            }
        }
        stage('build') {
            steps {
                echo '애플리케이션 빌드'
                sh './gradlew clean build'
                echo '애플리케이션 빌드 완료'
            }
        }
        stage('zip') {
            steps {
                echo '프로젝트 압축 시작'
                sh 'zip -r project.zip .'
                echo '프로젝트 압축 완료'
            }
        }
        stage('upload') {
            steps {
                echo 'S3 버킷에 업로드 시작'
                sh "aws s3 cp project.zip s3://recipesns-bucket/build/project.zip"
                echo 'S3 버킷에 업로드 완료'
            }
        }
    }
}
