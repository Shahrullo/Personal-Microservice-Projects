# Use official Python image based on Debian slim
FROM python:3.12-rc-slim-buster

# Set working directory in the container
WORKDIR /usr/src/app

# Set environment variables
ENV PYTHONDONTWRITEBYTECODE 1  # Prevent Python from writing pyc files
ENV PYTHONUNBUFFERED 1  # Ensure Python output is sent straight to terminal

# Install system dependencies
RUN apt-get update \
    && apt-get install -y --no-install-recommends gcc \
    && rm -rf /var/lib/apt/lists/*

# Install Python dependencies
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

# Copy project files
COPY . .