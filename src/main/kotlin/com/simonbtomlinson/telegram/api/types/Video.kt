package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty


data class Video(
		@JsonProperty("file_id") val fileId: String,
        @JsonProperty("width") val width: Int,
        @JsonProperty("height") val height: Int,
        @JsonProperty("duration") val duration: Int,
        @JsonProperty("thumb") val thumb: PhotoSize?,
        @JsonProperty("mime_type") val mimeType: String?,
        @JsonProperty("file_size") val fileSize: Int?
)