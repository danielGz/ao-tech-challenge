#!/bin/bash

# Check if Docker is running
if ! docker info > /dev/null 2>&1; then
    echo "Docker is not running. Please start Docker and try again."
    exit 1
fi

docker-compose -f docker-compose.yml up

echo "Ecommerce DB + Service started"