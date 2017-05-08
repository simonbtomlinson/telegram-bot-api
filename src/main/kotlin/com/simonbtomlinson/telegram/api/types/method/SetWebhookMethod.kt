package com.simonbtomlinson.telegram.api.types.method

import com.fasterxml.jackson.annotation.JsonProperty

data class SetWebhookMethod(
		@JsonProperty("url") val url: String? = null
) : Method {
	override @get:JsonProperty("method") val method: String = "setWebhook"
}