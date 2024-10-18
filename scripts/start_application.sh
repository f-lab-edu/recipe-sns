#!/bin/bash

JAR_PATH=/home/ec2-user/build/libs/demo-0.0.1-SNAPSHOT.jar

if ! command -v jq &> /dev/null
then
    sudo yum install -y jq
fi

SECRET=$(aws secretsmanager get-secret-value --secret-id recipesns-database-secrets --query SecretString --output text --region ap-northeast-2)

export DB_URL=$(echo $SECRET | jq -r '.DATABASE_URL')
export DB_USERNAME=$(echo $SECRET | jq -r '.DATABASE_USERNAME')
export DB_PASSWORD=$(echo $SECRET | jq -r '.DATABASE_PASSWORD')

echo $DB_URL
echo $DB_USERNAME
echo $DB_PASSWORD

echo "Spring Boot 애플리케이션 시작: $JAR_PATH"
nohup java -jar $JAR_PATH --spring.profiles.active=prod > /home/ec2-user/app.log 2>&1 &

sleep 15

echo "애플리케이션이 시작된 후 15초 대기 완료"
