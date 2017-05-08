package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty

data class InlineQuery(
		@JsonProperty("id") val id: String,
		@JsonProperty("from") val sender: User,
		@JsonProperty("query") val query: String
)