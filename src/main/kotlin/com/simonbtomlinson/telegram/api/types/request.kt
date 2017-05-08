package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty
import com.simonbtomlinson.telegram.api.types.inline.result.InlineQueryResult

data class GetUpdatesRequest(
		@JsonProperty("offset") val offset: Int? = null,
		@JsonProperty("limit") val limit: Int? = null,
		@JsonProperty("timeout") val timeout: Int? = null
)

data class SendMessageRequest(
		@JsonProperty("chat_id") val chatId: Long,
		@JsonProperty("text") val text: String
)

data class AnswerInlineQueryRequest(
		@JsonProperty("inline_query_id") val inlineQueryId: String,
		@JsonProperty("results") val results: List<InlineQueryResult>
)