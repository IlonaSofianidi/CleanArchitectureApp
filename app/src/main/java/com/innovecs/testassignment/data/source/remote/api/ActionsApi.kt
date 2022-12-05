package com.innovecs.testassignment.data.source.remote.api

import com.innovecs.testassignment.data.source.remote.model.ActionResponse
import retrofit2.http.GET

interface ActionsApi {

    @GET("/androidexam/butto_to_action_config.json")
    suspend fun getActions(): List<ActionResponse>?

}