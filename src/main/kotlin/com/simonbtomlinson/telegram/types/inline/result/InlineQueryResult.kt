package com.simonbtomlinson.telegram.types.inline.result

import com.fasterxml.jackson.annotation.JsonProperty

interface InlineQueryResult {
	val type: Type
	val id: String

	enum class Type {
		@JsonProperty("article") ARTICLE,
		@JsonProperty("photo") PHOTO
	}
}

