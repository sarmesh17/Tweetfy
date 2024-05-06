package com.sharkdroid.tweetfy.Repository

import com.sharkdroid.tweetfy.api.QuoteService
import com.sharkdroid.tweetfy.model.QuoteListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private var quoteService: QuoteService) {

    private val _categories= MutableStateFlow<List<String>>(emptyList())
    val categories:StateFlow<List<String>>
        get() = _categories

    suspend fun  getCategories(){

        val response= quoteService.getCategories()

        if (response.isSuccessful && response.body() != null ){

          _categories.emit(response.body()!!)

        }

    }

    private val  _tweets= MutableStateFlow<List<QuoteListItem>>(emptyList())
    val tweets:StateFlow<List<QuoteListItem>>
        get() = _tweets


    suspend fun getTweets(categories:String){

        val response=quoteService.getTweets("tweets[?(@.category==\"$categories\")]")

        if (response.isSuccessful && response.body() != null){

            _tweets.emit(response.body() !!)

        }

    }


}