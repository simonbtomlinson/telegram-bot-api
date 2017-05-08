package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty


data class Voice(
		@JsonProperty("file_id") val fileId: String,
        val duration: Int,
        @JsonProperty("mime_type") val mimeType: String?,
        @JsonProperty("file_size") val fileSize: Int?
)