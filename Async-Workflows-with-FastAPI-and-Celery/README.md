# Asynchronous Workflows with FastAPI and Celery

In web applications, it's crucial to handle time-consuming operations efficiently. Instead of processing lengthy tasks within the main request/response cycle, it's often better to manage them asynchronously in the background.

Consider a scenario where users must provide a profile picture and verify their email during registration. Processing these tasks directly within the request handler would result in unnecessary delays for the user. A more efficient approach is to delegate these operations to a task queue, allowing for immediate response to the client while a separate worker handles the processing. This method enhances user experience by enabling client-side activities during processing and improves overall application responsiveness.

This project will guide you through implementing background task processing in a [FastAPI](https://fastapi.tiangolo.com/) application using [Celery](https://docs.celeryq.dev/en/stable/getting-started/introduction.html) and [Redis](https://redis.io/docs/latest/). We'll utilize [Docker and Docker Compose](https://www.docker.com/) for seamless integration of all components. The guide will also cover testing strategies for Celery tasks, including both unit and integration tests.

**Key Goals:**

1. Implement Celery within a FastAPI framework and define tasks.
2. Use Docker to containerize FastAPI, Celery, and Redis services.
3. Execute background processes using dedicated worker instances.
4. Configure Celery logging to file.
5. Implement [Flower](https://flower.readthedocs.io/en/latest/) for Celery task and worker monitoring.
6. Develop comprehensive tests for Celery tasks, including unit and integration testing approaches.

## How to run
* Make sure [docker](https://docs.docker.com/engine/install/) and [docker-compose](https://docs.docker.com/compose/install/) is installed in your local machine
* Start the containers
    ```
    $ docker-compose up -d --build
    ```
* Open your browser to http://localhost:8000 to view the app or to http://localhost:5555 to view the Flower dashboard.
* Trigger a new task
    ```
    $ curl http://localhost:8000/tasks -H "Content-Type: application/json" --data '{"type": 0}'
    ```
* Check the status
    ```
    $ curl http://localhost:8000/tasks/<TASK_ID>
    ```