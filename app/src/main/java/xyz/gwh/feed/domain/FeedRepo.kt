package xyz.gwh.feed.domain

import xyz.gwh.feed.domain.entity.Feed

interface FeedRepo {
    suspend fun feed(): Result<Feed>
}