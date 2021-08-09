package xyz.gwh.feed.data

import xyz.gwh.feed.data.dto.FeedResponse
import xyz.gwh.feed.data.dto.ItemDto
import xyz.gwh.feed.domain.entity.Feed
import xyz.gwh.feed.domain.entity.Item

fun FeedResponse.toEntity(): Feed {
    return Feed(items.map { dto -> dto.toEntity() })
}

fun ItemDto.toEntity(): Item {
    return Item(text)
}