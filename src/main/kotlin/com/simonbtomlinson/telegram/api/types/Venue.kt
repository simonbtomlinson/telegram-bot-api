package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty


data class Venue(
		@JsonProperty("location") val location: Location,
        @JsonProperty("title") val title: String,
        @JsonProperty("address") val address: String,
        @JsonProperty("foursquare_id") val foursquareId: String?
)