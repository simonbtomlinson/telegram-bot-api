package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty


data class Sticker(
		@JsonProperty("file_id") val fileId: String,
        @JsonProperty("width") val width: Int,
        @JsonProperty("height") val height: Int,
        @JsonProperty("thumb") val thumb: PhotoSize?,
        @JsonProperty("emoji") val emoji: String?,
        @JsonProperty("file_size") val fileSize: Int?
)