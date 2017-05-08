package com.simonbtomlinson.telegram.types.inline.keyboard

import com.fasterxml.jackson.annotation.JsonProperty
import com.simonbtomlinson.telegram.types.method.ReplyMarkup
import java.util.*


data class InlineKeyboardMarkup(
		@JsonProperty("inlineKeyboard") val inlineKeyboard: Array<Array<InlineKeyboardButton>>
) : ReplyMarkup {
	override fun hashCode(): Int = Arrays.deepHashCode(inlineKeyboard)

	override fun equals(other: Any?): Boolean{
		if (this === other) return true
		if (other?.javaClass != javaClass) return false

		other as InlineKeyboardMarkup

		if (!Arrays.deepEquals(inlineKeyboard, other.inlineKeyboard)) return false

		return true
	}
}