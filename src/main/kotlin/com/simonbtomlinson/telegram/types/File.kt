package com.simonbtomlinson.telegram.types

import com.fasterxml.jackson.annotation.JsonProperty


data class File(
		@JsonProperty("file_id") val fileId: String,
        @JsonProperty("file_size") val fileSize: Int?,
        @JsonProperty("file_path") val filePath: String?
)