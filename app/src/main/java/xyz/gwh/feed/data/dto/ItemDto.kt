package xyz.gwh.feed.data.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ItemDto(
    @JsonProperty("headline") val text: String
)