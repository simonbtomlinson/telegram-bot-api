package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty

data class User(
		@JsonProperty("id") val id: Int,
		@JsonProperty("first_name") val firstName: String?,
		@JsonProperty("last_name") val lastName: String?,
		@JsonProperty("username") val username: String?
)