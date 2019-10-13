#!/usr/bin/env bash

mvn clean install -Dmaven.test.skip=true
docker build -t 192.168.0.229/library/demo-discovery:v1 .
docker login 192.168.0.229 --username=admin --password=harbor
docker push  192.168.0.229/library/demo-discovery:v1

