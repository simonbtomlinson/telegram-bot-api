package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.WordSpec

fun readClasspathFileToStream(location: String) = TypeDeserializationTests::class.java.getResourceAsStream(location)!!

class TypeDeserializationTests: WordSpec() {

	init {

		val objectMapper = ObjectMapper().findAndRegisterModules().setSerializationInclusion(JsonInclude.Include.NON_NULL).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
		"Deserializing data" should {
			"work" {
				val table = table(
						headers("jsonFileName"),
						row("callback-query.json"),
						row("chosen-inline-query.json"),
						row("edited-message.json"),
						row("forwarded-channel-message.json"),
						row("forwarded-message-update.json"),
						row("inline-query.json"),
						row("message-with-audio.json"),
						row("message-with-document.json"),
						row("message-with-entities.json"),
						row("message-with-reply.json"),
						row("message-with-text.json"),
						row("voice-message.json")
				)
				forAll(table) { fileName ->
					readClasspathFileToStream(fileName).use {
						objectMapper.readValue(it, Update::class.java)
					}
				}
			}
		}
	}
}