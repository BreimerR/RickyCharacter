package com.miyansoft.rickycharacter.data.api

class ApiHelper(private val apiService: ApiService) {
      fun getUsers() = apiService.getUsers()
}