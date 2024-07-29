import os
import time

from celery import Celery


celery = Celery(__name__)
celery.conf.broker_url = os.getenv("CELERY_BROKER_URL", "redis://localhost:6379")
celery.conf.result_backend = os.getenv("CELERY_RESULT_BACKEND", "redis://localhost:6379")


@celery.task(name="create_task")
def create_task(task_type):
    time.sleep(int(task_type) * 10)
    return True