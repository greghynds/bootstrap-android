package xyz.gwh.feed.presentation

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import xyz.gwh.feed.domain.entity.Feed
import xyz.gwh.feed.domain.entity.Item
import kotlin.Result.Companion.failure
import kotlin.Result.Companion.success

class FeedStateTest {

    @Test
    fun `is renderable when not loading and no errors`() {
        val sut = FeedState(listOf(), null, false)

        val result = sut.isRenderable()

        assertThat(result).isTrue
    }

    @Test
    fun `is not renderable when contains error`() {
        val sut = FeedState(listOf(), UnknownError("!!!"), false)

        val result = sut.isRenderable()

        assertThat(result).isFalse
    }

    @Test
    fun `is not renderable when loading`() {
        val sut = FeedState(listOf(), null, loading = true)

        val result = sut.isRenderable()

        assertThat(result).isFalse
    }

    @Test
    fun `creates empty state`() {
        val expected = FeedState(listOf(), null, false)

        val result = FeedState.empty()

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `creates loading state`() {
        val expected = FeedState(listOf(), null, loading = true)

        val result = FeedState.loading()

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `creates error state`() {
        val error = UnknownError("network failure")
        val expected = FeedState(listOf(), error, false)

        val result = FeedState.error(error)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `creates state from feed entity`() {
        val items = listOf(Item("text"))
        val feed = Feed(items)
        val expected = FeedState(items, null, false)

        val result = FeedState.from(feed)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `creates state from success result`() {
        val items = listOf(Item("text"))
        val feed = Feed(items)
        val expected = FeedState(items, null, false)

        val result = FeedState.from(success(feed))

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `creates state from failure result`() {
        val error = UnknownError("network failure")
        val expected = FeedState(listOf(), error, false)

        val result = FeedState.from(failure(error))

        assertThat(result).isEqualTo(expected)
    }
}