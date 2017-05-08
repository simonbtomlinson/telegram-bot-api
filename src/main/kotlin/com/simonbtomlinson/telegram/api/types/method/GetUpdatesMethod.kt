package com.simonbtomlinson.telegram.api.types.method

import com.fasterxml.jackson.annotation.JsonProperty


data class GetUpdatesMethod(
	@JsonProperty("offset") val offset: Int? = null,
    @JsonProperty("limit") val limit: Int? = null,
    @JsonProperty("timeout") val timeout: Int? = null
) : Method {
	override @get:JsonProperty("method") val method: String = "getUpdates"
}