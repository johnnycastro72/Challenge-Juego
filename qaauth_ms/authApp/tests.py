import json
import jwt

from django.test import TestCase
from rest_framework import status
from rest_framework.test import APIClient

# Create your tests here.
class TestAPI(TestCase):

    def test_signUp(self):
        client = APIClient()
        response = client.post(
                '/user/', 
                {
                    "username": "test_user_1",
                    "password": "test_password_1",
                    "name": "test user",
                    "email": "test_user_1@gmail.com",
                }, 
                format='json')
        self.assertEqual(response.status_code, status.HTTP_201_CREATED)
        self.assertEqual('refresh' in response.data.keys(), True)
        self.assertEqual('access' in response.data.keys(), True)

    def test_login(self):
        client = APIClient()
        response = client.post(
                '/login/', 
                { 
                    "username":"j2csofka", 
                    "password":"Sofka1234!"
                }, 
                format='json')
        self.assertEqual(response.status_code, status.HTTP_200_OK)
        self.assertEqual('refresh' in response.data.keys(), True)
        self.assertEqual('access' in response.data.keys(), True)

    def test_user(self):
        client = APIClient()

        token_access = client.post(
                    '/login/', 
                    {"username":"j2csofka", "password":"Sofka1234!"}, 
                    format='json'
                    ).data["access"]

        secret = 'django-insecure-w=vz499%48r_@4b)e&l*#fdvkjulw2hqa1w^30q98@83apvsu#'
        user_id = jwt.decode( token_access, secret, algorithms=["HS256"] )["user_id"]
        print(user_id)
        url = '/user/'+ str(user_id) + '/'
        auth_headers = {'HTTP_AUTHORIZATION': 'Bearer ' + token_access,}

        response = client.get(url, **auth_headers)

        self.assertEqual(response.status_code, status.HTTP_200_OK)
        self.assertEqual(response.data["username"], "j2csofka")
