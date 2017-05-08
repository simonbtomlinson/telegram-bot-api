package com.simonbtomlinson.telegram.types.method

import com.fasterxml.jackson.annotation.JsonProperty
import com.simonbtomlinson.telegram.types.inline.result.InlineQueryResult
import java.util.*


data class AnswerInlineQueryMethod(
		@JsonProperty("inline_query_id") val inlineQueryId: String,
        val results: Array<InlineQueryResult>,
        @JsonProperty("cache_time") val cacheTime: Int? = null,
        @JsonProperty("is_personal") val isPersonal: Boolean? = null,
        @JsonProperty("next_offset") val nextOffset: String? = null,
        @JsonProperty("switch_pm_text") val switchPmText: String? = null,
        @JsonProperty("switch_pm_parameter") val switchPmParameter: String? = null
) : Method {
	override val method: String = "answerInlineQuery"

	override fun hashCode(): Int{
		var result = inlineQueryId.hashCode()
		result = 31 * result + Arrays.hashCode(results)
		result = 31 * result + (cacheTime ?: 0)
		result = 31 * result + (isPersonal?.hashCode() ?: 0)
		result = 31 * result + (nextOffset?.hashCode() ?: 0)
		result = 31 * result + (switchPmText?.hashCode() ?: 0)
		result = 31 * result + (switchPmParameter?.hashCode() ?: 0)
		result = 31 * result + method.hashCode()
		return result
	}

	override fun equals(other: Any?): Boolean{
		if (this === other) return true
		if (other?.javaClass != javaClass) return false

		other as AnswerInlineQueryMethod

		if (inlineQueryId != other.inlineQueryId) return false
		if (!Arrays.equals(results, other.results)) return false
		if (cacheTime != other.cacheTime) return false
		if (isPersonal != other.isPersonal) return false
		if (nextOffset != other.nextOffset) return false
		if (switchPmText != other.switchPmText) return false
		if (switchPmParameter != other.switchPmParameter) return false
		if (method != other.method) return false

		return true
	}
}