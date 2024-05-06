package com.sharkdroid.tweetfy.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharkdroid.tweetfy.Repository.TweetRepository
import com.sharkdroid.tweetfy.model.QuoteListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetsViewModel @Inject constructor(private val repository:TweetRepository,
    private val savedStateHandle: SavedStateHandle
) :ViewModel() {

    val tweets: StateFlow<List<QuoteListItem>>
        get() = repository.tweets

    init {

        viewModelScope.launch {

            val category = savedStateHandle.get<String>("category") ?: "motivation"
            repository.getTweets(category)

        }

    }

}