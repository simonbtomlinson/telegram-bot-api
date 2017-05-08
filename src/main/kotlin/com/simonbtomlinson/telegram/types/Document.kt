package com.simonbtomlinson.telegram.types

import com.fasterxml.jackson.annotation.JsonProperty

data class Document(
		@JsonProperty("file_id") val fileId: String,
        val thumb: PhotoSize?,
        @JsonProperty("file_name") val fileName: String?,
        @JsonProperty("mime_type") val mimeType: String?,
        @JsonProperty("file_size") val fileSize: Int?
)


