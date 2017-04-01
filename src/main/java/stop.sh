#!/bin/bash
PID=$(ps -ef | grep /root/usr/lc_dream_real/work/LC_DR/target/dream-real-1.0.0-SNAPSHOT.jar | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
    echo Application is already stopped
else
    echo kill $PID
    kill $PID
fi