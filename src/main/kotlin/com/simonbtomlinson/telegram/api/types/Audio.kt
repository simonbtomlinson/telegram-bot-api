package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty


data class Audio(
		@JsonProperty("file_id") val fileId: String,
        @JsonProperty("duration") val duration: Int,
        @JsonProperty("performer") val performer: String?,
        @JsonProperty("title") val title: String?,
        @JsonProperty("mime_type") val mimeType: String?,
        @JsonProperty("file_size") val fileSize: Int?
)