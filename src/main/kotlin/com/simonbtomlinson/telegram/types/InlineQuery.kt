package com.simonbtomlinson.telegram.types

import com.fasterxml.jackson.annotation.JsonProperty
import com.simonbtomlinson.telegram.types.User

data class InlineQuery(
		val id: String,
		@JsonProperty("from") val sender: User,
		val query: String
)