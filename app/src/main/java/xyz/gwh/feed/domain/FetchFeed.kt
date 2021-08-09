package xyz.gwh.feed.domain

import xyz.gwh.arch.domain.Params
import xyz.gwh.arch.domain.UseCase
import xyz.gwh.feed.domain.entity.Feed

class FetchFeed(private val repo: FeedRepo) : UseCase<Params, Feed>() {

    override suspend fun operation(params: Params): Result<Feed> {
        return repo.feed()
    }
}