package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty


data class Audio(
		@JsonProperty("file_id") val fileId: String,
        val duration: Int,
        val performer: String?,
        val title: String?,
        @JsonProperty("mime_type") val mimeType: String?,
        @JsonProperty("file_size") val fileSize: Int?
)