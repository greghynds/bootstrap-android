package xyz.gwh.feed.data

import xyz.gwh.feed.data.dto.FeedResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface FeedClient {

    @GET(FEED_ENDPOINT)
    fun feed(): Deferred<Response<FeedResponse>>
}