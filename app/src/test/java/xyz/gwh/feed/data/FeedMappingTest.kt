package xyz.gwh.feed.data

import com.github.writethemfirst.approvals.Approvals.verify
import org.junit.Test
import xyz.gwh.feed.data.dto.FeedResponse
import xyz.gwh.feed.data.dto.ItemDto


class FeedMappingTest {

    @Test
    fun `maps all fields when converting feed response to feed entity`() {
        val dto = ItemDto("text")
        val sut = FeedResponse(listOf(dto))

        val result = sut.toEntity()

        verify(result)
    }

    @Test
    fun `maps all fields when converting item dto to item entity`() {
        val sut = ItemDto("text")

        val result = sut.toEntity()

        verify(result)
    }
}