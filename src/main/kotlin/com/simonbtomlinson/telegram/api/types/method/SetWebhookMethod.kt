package com.simonbtomlinson.telegram.api.types.method


data class SetWebhookMethod(
		val url: String? = null
) : Method {
	override val method: String = "setWebhook"
}