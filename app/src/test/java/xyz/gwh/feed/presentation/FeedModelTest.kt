package xyz.gwh.feed.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import xyz.gwh.arch.data.ApiError
import xyz.gwh.arch.domain.Params
import xyz.gwh.feed.domain.FetchFeed
import xyz.gwh.feed.domain.entity.Feed
import xyz.gwh.feed.domain.entity.Item
import xyz.gwh.util.TestDispatchers
import kotlin.Result.Companion.failure
import kotlin.Result.Companion.success

class FeedModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val fetchFeed = mock<FetchFeed>()
    private val sut = FeedModel(fetchFeed, TestDispatchers())
    private val observer = mock<Observer<FeedState>>()

    @Before
    fun `start observing`() {
        sut.updates().observeForever(observer)
    }

    @After
    fun `stop observing`() {
        sut.updates().removeObserver(observer)
    }

    @Test
    fun `emits loading state when loading feed`() {
        runBlocking {
            val state = FeedState(loading = true)
            val action = createLoadFeedAction()

            sut.send(action)

            verify(observer).onChanged(state)
        }
    }

    @Test
    fun `emits state with list of items when fetch successful`() {
        runBlocking {
            val items = listOf(Item("text"))
            val state = FeedState(items)
            val feed = Feed(items)
            val action = createLoadFeedAction()
            given(fetchFeed.execute(Params.None)).willReturn(success(feed))

            sut.send(action)

            verify(observer).onChanged(state)
        }
    }

    @Test
    fun `emits error state when fetch failed`() {
        runBlocking {
            val error = ApiError(404, "Not found")
            val state = FeedState(error = error)
            val action = createLoadFeedAction()
            given(fetchFeed.execute(Params.None)).willReturn(failure(error))

            sut.send(action)

            verify(observer).onChanged(state)
        }
    }
}