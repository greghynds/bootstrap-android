package xyz.gwh.feed.presentation

import xyz.gwh.feed.domain.entity.Feed
import xyz.gwh.feed.domain.entity.Item

data class FeedState(
    val items: List<Item> = listOf(),
    val error: Throwable? = null,
    val loading: Boolean = false
) {

    fun isRenderable(): Boolean = !loading && error == null

    companion object {

        fun empty() = FeedState()
        fun loading() = FeedState(loading = true)
        fun error(error: Throwable) = FeedState(error = error)

        fun from(feed: Feed): FeedState {
            return FeedState(items = feed.items)
        }

        fun from(result: Result<Feed>): FeedState {
            return when {
                result.isSuccess -> from(result.getOrThrow())
                else -> error(result.exceptionOrNull() ?: UnknownError())
            }
        }
    }
}