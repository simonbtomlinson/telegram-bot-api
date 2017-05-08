package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties("chosen_inline_result", "callback_query")
data class Update(
		@JsonProperty("update_id") val updateId: Int,
		@JsonProperty("message") val message: Message?,
		@JsonProperty("edited_message") val editedMessage: Message?,
		@JsonProperty("inline_query") val inlineQuery: InlineQuery?
		// TODO: Add chosen_inline_result, callback_query
) {
	enum class Type {
		MESSAGE,
		EDITED_MESSAGE,
		INLINE_QUERY,
		CHOSEN_INLINE_RESULT,
		CALLBACK_QUERY,
		UNKNOWN
	}

	@get:JsonIgnore
	val type: Type = when {
			message != null -> Type.MESSAGE
			editedMessage != null -> Type.EDITED_MESSAGE
			inlineQuery != null -> Type.INLINE_QUERY
			// Need to handle inline_query, etc.
			else -> Type.UNKNOWN
		}
}