package com.example.todolistpractice.network

import com.example.todolistpractice.data.AllItems
import com.example.todolistpractice.data.Message
import com.example.todolistpractice.data.Task
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val BASE_URL = "https://eobhl4231e.execute-api.us-east-1.amazonaws.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DynamoApiService {
    @GET("/items")
    suspend fun getTasks(): AllItems

    @PUT("/items")
    suspend fun addTask(@Body task: Task): String

    @DELETE("/items/{id}")
    suspend fun deleteTask(@Path("id") id: Int): String
}

object DynamoApi {
    val retrofitService: DynamoApiService by lazy {
        retrofit.create(DynamoApiService::class.java)
    }
}