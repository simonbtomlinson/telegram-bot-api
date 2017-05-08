package com.simonbtomlinson.telegram.types.method

import com.fasterxml.jackson.annotation.JsonProperty


interface Method {
	@get:JsonProperty("method")
	val method: String
}