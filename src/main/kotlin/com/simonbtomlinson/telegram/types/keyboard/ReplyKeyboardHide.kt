package com.simonbtomlinson.telegram.types.keyboard

import com.fasterxml.jackson.annotation.JsonProperty
import com.simonbtomlinson.telegram.types.method.ReplyMarkup


data class ReplyKeyboardHide(
		val selective: Boolean = false
) : ReplyMarkup {
	@get:JsonProperty("hide_keyboard")
	val hideKeyboard = true
}