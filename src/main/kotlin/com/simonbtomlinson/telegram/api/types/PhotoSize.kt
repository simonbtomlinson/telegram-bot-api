package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty


data class PhotoSize(
		@JsonProperty("file_id") val fileID: String,
        val width: Int,
        val height: Int,
        @JsonProperty("file_size") val fileSize: Int?
)