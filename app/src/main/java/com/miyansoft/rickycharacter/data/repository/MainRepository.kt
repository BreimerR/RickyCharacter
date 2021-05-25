package com.miyansoft.rickycharacter.data.repository

import com.miyansoft.rickycharacter.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
   fun getUsers() = apiHelper.getUsers()
}