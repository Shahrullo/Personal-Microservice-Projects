import json
from unittest.mock import patch


def test_home(test_app):
    response = test_app.get("/")
    assert response.status == 200