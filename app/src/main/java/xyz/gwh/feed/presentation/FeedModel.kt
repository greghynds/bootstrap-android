package xyz.gwh.feed.presentation

import xyz.gwh.arch.domain.Params
import xyz.gwh.arch.presentation.Action
import xyz.gwh.arch.presentation.Dispatchers
import xyz.gwh.arch.presentation.Model
import xyz.gwh.feed.domain.FetchFeed


class FeedModel(
    private val fetchFeed: FetchFeed,
    dispatchers: Dispatchers,
) : Model<FeedState>(dispatchers) {

    override fun send(action: Action) = with(action) {
        when (type) {
            LOAD_FEED -> loadFeed()
        }
    }

    override fun onCoroutineError(error: Throwable) {
        emit(FeedState.error(error))
    }

    private fun loadFeed() {
        emit(FeedState.loading())

        main {
            emit(FeedState.from(
                io { fetchFeed.execute(Params.None) }
            ))
        }
    }
}