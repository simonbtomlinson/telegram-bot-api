package com.simonbtomlinson.telegram.types.method


data class GetUpdatesMethod(
	val offset: Int? = null,
    val limit: Int? = null,
    val timeout: Int? = null
) : Method {
	override val method: String = "getUpdates"
}