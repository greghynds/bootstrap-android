package xyz.gwh.feed

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import org.koin.android.ext.android.inject
import xyz.gwh.feed.presentation.FeedDelegate
import xyz.gwh.feed.presentation.FeedModel
import xyz.gwh.feed.presentation.createLoadFeedAction
import xyz.gwh.feed.ui.FeedUi

class FeedActivity : AppCompatActivity(), FeedDelegate {

    private val model: FeedModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                FeedUi(model, this)
            }
        }

        refresh()
    }

    override fun refresh() {
        model.send(createLoadFeedAction())
    }
}