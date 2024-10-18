#!/bin/bash

PORT=8080

if sudo lsof -i :$PORT; then
    echo "애플리케이션이 정상적으로 실행 중입니다."
    exit 0
else
    echo "애플리케이션이 실행되지 않았습니다."
    exit 1
fi