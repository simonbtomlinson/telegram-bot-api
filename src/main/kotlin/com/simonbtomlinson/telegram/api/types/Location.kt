package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty

data class Location(
		@JsonProperty("longitude") val longitude: Float,
        @JsonProperty("latitude") val latitude: Float
)