package com.simonbtomlinson.telegram.types

import com.fasterxml.jackson.annotation.JsonProperty


data class Video(
		@JsonProperty("file_id") val fileId: String,
        val width: Int,
        val height: Int,
        val duration: Int,
        val thumb: PhotoSize?,
        @JsonProperty("mime_type") val mimeType: String?,
        @JsonProperty("file_size") val fileSize: Int?
)