package com.sharkdroid.tweetfy.api

import com.sharkdroid.tweetfy.model.QuoteListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface QuoteService {

    @GET("/v3/b/6623b2b5acd3cb34a83bbc10?meta=false")
  suspend  fun  getTweets(@Header("X-JSON-Path") category: String) :Response<List<QuoteListItem>>
  //@Header("X-JSON-Path"). This means that the value of the category parameter will be passed as a header with the key X-JSON-Path.

  @GET("/v3/b/6623b2b5acd3cb34a83bbc10?meta=false")
  @Headers("X-JSON-Path:tweets..category")
  suspend fun  getCategories():Response<List<String>>

}