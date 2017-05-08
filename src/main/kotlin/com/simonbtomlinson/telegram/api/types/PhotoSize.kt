package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty


data class PhotoSize(
		@JsonProperty("file_id") val fileID: String,
        @JsonProperty("width") val width: Int,
        @JsonProperty("height") val height: Int,
        @JsonProperty("file_size") val fileSize: Int?
)