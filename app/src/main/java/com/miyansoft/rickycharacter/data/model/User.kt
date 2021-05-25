package com.miyansoft.rickycharacter.data.model






data class Origin(val name: String, val url: String)
data class Location(val name: String, val url: String)
data class Info(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: Int?
)


data class Response(
    val info: Info,
    val results: List<User>
)

data class User(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val url: String,
    val created: String
)
