package xyz.gwh.feed.data

import xyz.gwh.arch.data.ApiError
import xyz.gwh.feed.data.dto.FeedResponse
import xyz.gwh.feed.domain.entity.Feed
import xyz.gwh.feed.data.dto.ItemDto
import xyz.gwh.feed.domain.entity.Item
import xyz.gwh.util.failureResponse
import xyz.gwh.util.successResponse
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FeedApiTest {

    @Test
    fun `returns a response when request is successful`() {
        runBlocking {
            val text = "text"
            val item = Item(text)
            val dto = ItemDto(text)
            val feed = Feed(listOf(item))
            val response = FeedResponse(listOf(dto))
            val client = mock<FeedClient>()
            val sut = FeedApi(client)
            given(client.feed()).willReturn(successResponse(response))

            val result = sut.feed()

            assertThat(result.getOrThrow()).isEqualTo(feed)
        }
    }

    @Test
    fun `returns an error when request is not successful`() {
        runBlocking {
            val errorMsg = "Request failed"
            val code = 500
            val client = mock<FeedClient>()
            val sut = FeedApi(client)
            val expected = ApiError(code, errorMsg)
            given(client.feed()).willReturn(failureResponse(errorMsg, code))

            val result = sut.feed()

            assertThat(result.exceptionOrNull()).isEqualTo(expected)
        }
    }
}