package com.simonbtomlinson.telegram.types.keyboard

import com.fasterxml.jackson.annotation.JsonProperty


data class KeyboardButton(
		val text: String,
        @JsonProperty("request_contact") val requestContact: Boolean = false,
        @JsonProperty("request_location") val requestLocation: Boolean = false
)