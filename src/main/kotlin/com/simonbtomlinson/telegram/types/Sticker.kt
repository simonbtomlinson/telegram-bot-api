package com.simonbtomlinson.telegram.types

import com.fasterxml.jackson.annotation.JsonProperty


data class Sticker(
		@JsonProperty("file_id") val fileId: String,
        val width: Int,
        val height: Int,
        val thumb: PhotoSize?,
        val emoji: String?,
        @JsonProperty("file_size") val fileSize: Int?
)