package com.example.examplemvvm.data.network

import com.example.examplemvvm.core.RetrofitHelper
import com.example.examplemvvm.data.Model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val api:QuoteAPiClient) {

    suspend fun getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }

    }
}