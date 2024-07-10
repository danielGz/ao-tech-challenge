# Before you begin
This document includes the dependencies needed in your development environment to successfully build the project.

If you already have JDK 21 and docker+docker-compose installed you might skip this document. 
### 1. Infrastructure
#### 1.1 Install JDK 21:
**Debian**
```shell
sudo apt install openjdk-21-jdk
sudo update-java-alternatives --list
sudo update-java-alternatives --set java-1.21.0-openjdk-amd64
```

**MacOS**
```shell
brew tap homebrew/cask-versions
brew search openjdk
brew install --cask openjdk@21
```

#### 1.2 Docker:
**Debian & MacOS**
```shell
sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
```