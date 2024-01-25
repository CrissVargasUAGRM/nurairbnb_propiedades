#!/bin/bash
hostname=$(curl http://169.254.169.254/metadata/v1/hostname)
docker run -d -p 8081:8080 --name commends-"$hostname" cristhian1995/ms-commend:"$hostname"
