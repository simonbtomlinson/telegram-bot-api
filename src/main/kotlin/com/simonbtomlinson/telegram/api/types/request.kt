package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty
import com.simonbtomlinson.telegram.api.types.inline.result.InlineQueryResult

data class GetUpdatesRequest(
		val offset: Int? = null,
		val limit: Int? = null,
		val timeout: Int? = null
)

data class SendMessageRequest(
		@JsonProperty("chat_id") val chatId: Long,
		val text: String
)

data class AnswerInlineQueryRequest(
		@JsonProperty("inline_query_id") val inlineQueryId: String,
		val results: List<InlineQueryResult>
)