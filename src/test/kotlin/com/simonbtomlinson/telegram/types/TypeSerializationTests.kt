package com.simonbtomlinson.telegram.types

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.simonbtomlinson.telegram.types.inline.result.InlineQueryResult
import com.simonbtomlinson.telegram.types.inline.result.InlineQueryResultPhoto


fun main(args: Array<String>) {
	val mapper = jacksonObjectMapper().findAndRegisterModules()

	println(mapper.writeValueAsString(InlineQueryResultPhoto("id!", "photoUrl!", "thumbUrl!", 1, 2)))
}