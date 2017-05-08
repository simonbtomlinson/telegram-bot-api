package com.simonbtomlinson.telegram.api.types.method

import com.fasterxml.jackson.annotation.JsonProperty


data class SendMessageMethod (
		@JsonProperty("chat_id") val chatId: Long,
        val text: String,
        @JsonProperty("parse_mode") val parseMode: String? = null,
        @JsonProperty("disable_web_page_preview") val disableWebPagePreview: Boolean = false,
        @JsonProperty("disable_notification") val disableNotification: Boolean = false,
        @JsonProperty("reply_to_message_id") val replyToMessageId: Int? = null,
        @JsonProperty("reply_markup") val replyMarkup: ReplyMarkup? = null
) : Method {
	override val method = "sendMessage"
}

interface ReplyMarkup