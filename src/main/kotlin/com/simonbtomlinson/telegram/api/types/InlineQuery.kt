package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty

data class InlineQuery(
		val id: String,
		@JsonProperty("from") val sender: User,
		val query: String
)