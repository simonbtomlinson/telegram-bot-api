package com.simonbtomlinson.telegram.api.types.inline.keyboard

import com.fasterxml.jackson.annotation.JsonProperty

import com.simonbtomlinson.telegram.api.types.Message
import com.simonbtomlinson.telegram.api.types.User


data class CallbackQuery(
		@JsonProperty("id") val id: String,
        @JsonProperty("from") val from: User,
        @JsonProperty("message") val message: Message?
)