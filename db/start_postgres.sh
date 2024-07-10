#!/bin/bash

# Check if Docker is running
if ! docker info > /dev/null 2>&1; then
    echo "Docker is not running. Please start Docker and try again."
    exit 1
fi

#!/bin/bash

# Check if the environment is set to 'dev'
if [ "$APP_ENV" == "prod" ]; then
  docker-compose -f docker-compose.prod.yml up
else
  docker-compose -f docker-compose.yml up
fi

echo "PostgreSQL has been started."