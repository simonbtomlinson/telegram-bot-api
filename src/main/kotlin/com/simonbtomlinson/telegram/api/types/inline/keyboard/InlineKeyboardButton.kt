package com.simonbtomlinson.telegram.api.types.inline.keyboard

import com.fasterxml.jackson.annotation.JsonProperty


data class InlineKeyboardButton(
		val text: String,
        val url: String?,
        @JsonProperty("callback_data") val callbackData: String,
        @JsonProperty("switch_inline_query") val switchInlineQuery: String? = null
)