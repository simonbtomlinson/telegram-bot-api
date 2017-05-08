package com.simonbtomlinson.telegram.types.method


data class SetWebhookMethod(
		val url: String? = null
) : Method {
	override val method: String = "setWebhook"
}