package com.simonbtomlinson.telegram.api.types.method

import com.fasterxml.jackson.annotation.JsonProperty


interface Method {
	@get:JsonProperty("method")
	val method: String
}