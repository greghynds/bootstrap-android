package xyz.gwh.feed.data

import xyz.gwh.arch.data.toResult
import xyz.gwh.feed.domain.FeedRepo
import xyz.gwh.feed.domain.entity.Feed

class FeedApi(private val client: FeedClient) : FeedRepo {

    override suspend fun feed(): Result<Feed> {
        return client.feed()
            .await()
            .toResult()
            .map { response -> response.toEntity() }
    }
}