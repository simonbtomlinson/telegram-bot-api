package com.simonbtomlinson.telegram.types.keyboard

import com.fasterxml.jackson.annotation.JsonProperty
import com.simonbtomlinson.telegram.types.method.ReplyMarkup
import java.util.*


data class ReplyKeyboardMarkup (
		val keyboard: Array<Array<KeyboardButton>>,
        @JsonProperty("resize_keyboard") val resizeKeyboard: Boolean = false,
        @JsonProperty("one_time_keyboard") val oneTimeKeyboard: Boolean = false,
        val selective: Boolean = false
) : ReplyMarkup {
	override fun hashCode(): Int{
		var result = Arrays.hashCode(keyboard)
		result = 31 * result + resizeKeyboard.hashCode()
		result = 31 * result + oneTimeKeyboard.hashCode()
		result = 31 * result + selective.hashCode()
		return result
	}

	override fun equals(other: Any?): Boolean{
		if (this === other) return true
		if (other?.javaClass != javaClass) return false

		other as ReplyKeyboardMarkup

		if (!Arrays.equals(keyboard, other.keyboard)) return false
		if (resizeKeyboard != other.resizeKeyboard) return false
		if (oneTimeKeyboard != other.oneTimeKeyboard) return false
		if (selective != other.selective) return false

		return true
	}
}