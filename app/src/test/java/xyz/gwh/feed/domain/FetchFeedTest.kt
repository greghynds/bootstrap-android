package xyz.gwh.feed.domain

import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.BDDMockito.given
import xyz.gwh.arch.domain.Params
import xyz.gwh.feed.domain.entity.Feed
import xyz.gwh.feed.domain.entity.Item
import kotlin.Result.Companion.success


class FetchFeedTest {

    @Test
    fun `returns a result when feed fetched successfully`() {
        runBlocking {
            val item = Item("text")
            val feed = createFeed(item)
            val repo = mock<FeedRepo>()
            val sut = FetchFeed(repo)
            given(repo.feed()).willReturn(success(feed))

            val result = sut.execute(Params.None)

            assertThat(result.getOrThrow()).isEqualTo(feed)
        }
    }

    @Test
    fun `returns an error when failed to fetch feed`() {
        runBlocking {
            val item = Item("text")
            val feed = createFeed(item)
            val repo = mock<FeedRepo>()
            val sut = FetchFeed(repo)
            given(repo.feed()).willReturn(success(feed))

            val result = sut.execute(Params.None)

            assertThat(result.getOrThrow()).isEqualTo(feed)
        }
    }

    private fun createFeed(vararg items: Item): Feed {
        return Feed(items.toList())
    }
}