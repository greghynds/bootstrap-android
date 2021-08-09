package xyz.gwh.feed.data.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class FeedResponse(
    @JsonProperty("headlines") val items: List<ItemDto>
)