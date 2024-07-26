# Casumo

## Overview

Casumo is a Maven-based Java project for testing a vowel removal service API using RestAssured and JUnit 5.
It provides parameterized tests for various scenarios to ensure the service correctly processes input strings 
by removing vowels and handling special cases.


## Prerequisites

JDK, Maven, Docker, clone repository

## Setup
1. **Start Docker service:** docker run -p 8080:8080 -it casumo/devowelizer:latest
2. **Install Maven dependencies:** mvn install
3. **Run tests:** mvn test
