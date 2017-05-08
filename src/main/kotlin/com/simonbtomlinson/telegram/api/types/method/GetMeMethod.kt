package com.simonbtomlinson.telegram.api.types.method

import com.fasterxml.jackson.annotation.JsonProperty


class GetMeMethod() : Method {
	override @get:JsonProperty("method") val method = "getMe"
}