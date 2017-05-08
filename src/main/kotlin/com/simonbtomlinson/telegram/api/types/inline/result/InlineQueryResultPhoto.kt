package com.simonbtomlinson.telegram.api.types.inline.result

import com.fasterxml.jackson.annotation.JsonProperty

data class InlineQueryResultPhoto(
		override @JsonProperty("id") val id: String,
		@JsonProperty("photo_url") val photoUrl: String,
		@JsonProperty("thumb_url") val thumbUrl: String,
		@JsonProperty("photo_width") val photoWidth: Int? = null,
		@JsonProperty("photo_height") val photoHeight: Int? = null
) : InlineQueryResult {
	override val type = InlineQueryResult.Type.PHOTO
}