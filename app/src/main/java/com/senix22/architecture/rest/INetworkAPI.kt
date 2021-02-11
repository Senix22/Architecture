package com.senix22.architecture.rest

import com.senix22.architecture.DTO.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface INetworkAPI {
    @GET("posts/")
    fun getAllPosts(): Observable<List<Post>>
}