#!/bin/bash

PORT=8080

CURRENT_PID=$(sudo lsof -t -i :$PORT)

if [ -z "$CURRENT_PID" ]; then
    echo "현재 실행 중인 애플리케이션이 없습니다."
else
    echo "현재 실행 중인 애플리케이션 종료: $CURRENT_PID"
    sudo kill -9 $CURRENT_PID
    sleep 5
fi
