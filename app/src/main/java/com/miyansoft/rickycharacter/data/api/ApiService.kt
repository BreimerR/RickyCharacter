package com.miyansoft.rickycharacter.data.api

import com.miyansoft.rickycharacter.data.model.Response
import com.miyansoft.rickycharacter.data.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {


    /**@Description
     * Used response instead of users/characters since our data object
     * must be similar to the response json i.e
     * {
     *  info :{
     *
     *  },
     *  results : [
     *     {
     *        id:1,
     *        ...
     *     }
     *  ]
     * }
     * Thus
     * data class Response(
     *    val info:Info,
     *    val results: List<Users>
     * )
     * data class User(
     *   val id:Int
     *   ...
     * )
     * */
    @GET("/api/character")
    fun getUsers(): Call<Response>
}