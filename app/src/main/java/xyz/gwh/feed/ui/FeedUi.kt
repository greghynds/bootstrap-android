package xyz.gwh.feed.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import xyz.gwh.feed.presentation.FeedDelegate
import xyz.gwh.feed.presentation.FeedModel
import xyz.gwh.feed.presentation.FeedState


@Composable
fun FeedUi(model: FeedModel, actions: FeedDelegate) {
    val state: FeedState by model.updates().observeAsState(FeedState.empty())

    when {
        state.loading -> LoadingScreen()
        state.isRenderable() -> ItemList(state.items)
        else -> ErrorScreen(actions::refresh)
    }
}