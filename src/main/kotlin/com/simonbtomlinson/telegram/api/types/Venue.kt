package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty


data class Venue(
		val location: Location,
        val title: String,
        val address: String,
        @JsonProperty("foursquare_id") val foursquareId: String?
)