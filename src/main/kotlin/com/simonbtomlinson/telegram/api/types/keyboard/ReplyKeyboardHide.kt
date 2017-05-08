package com.simonbtomlinson.telegram.api.types.keyboard

import com.fasterxml.jackson.annotation.JsonProperty
import com.simonbtomlinson.telegram.api.types.method.ReplyMarkup


data class ReplyKeyboardHide(
		@JsonProperty("selective") val selective: Boolean = false
) : ReplyMarkup {
	@get:JsonProperty("hide_keyboard")
	val hideKeyboard = true
}