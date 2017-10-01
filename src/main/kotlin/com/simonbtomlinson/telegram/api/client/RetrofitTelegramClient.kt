package com.simonbtomlinson.telegram.api.client

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.simonbtomlinson.telegram.api.BadTelegramResponseException
import com.simonbtomlinson.telegram.api.types.*
import com.simonbtomlinson.telegram.api.types.method.*
import okhttp3.OkHttpClient
import org.slf4j.LoggerFactory
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

private interface RetrofitClient {
	@GET("getMe")
	fun getMe(): Call<TelegramResponse<User>>

	@POST("setWebhook")
	fun setWebhook(@Body request: SetWebhookMethod): Call<TelegramResponse<Boolean>>

	@POST("getUpdates")
	fun getUpdates(@Body request: GetUpdatesMethod): Call<TelegramResponse<List<Update>>>

	@POST("sendMessage")
	fun sendMessage(@Body sendMessageRequest: SendMessageMethod): Call<TelegramResponse<Message>>

	@POST("answerInlineQuery")
	fun answerInlineQuery(@Body answerInlineQueryMethod: AnswerInlineQueryMethod): Call<TelegramResponse<Boolean>>
}


/*
	The default object mapper, set up correctly for telegram
 */
private fun defaultObjectMapper() = jacksonObjectMapper()
		.findAndRegisterModules()
		.setSerializationInclusion(JsonInclude.Include.NON_NULL)
		.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

/**
 * @param apiKey The api key for this telegram client
 * @param objectMapper A jackson object mapper to use when communicating with Telegram. It should have the [JsonInclude.Include.NON_NULL] serialization inclusion and should be configured so that [DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES] is set to false.
 *
 */
class RetrofitTelegramClient(apiKey: String, objectMapper: ObjectMapper = defaultObjectMapper()) : TelegramClient {

	private val logger = LoggerFactory.getLogger(RetrofitTelegramClient::class.java)

	private val retrofitClient: RetrofitClient

	private val retrofit: Retrofit

	init {
		objectMapper.serializationConfig.serializationFeatures
		val okHttp =  buildOkHTTP()
		retrofit = Retrofit.Builder()
				.baseUrl("https://api.telegram.org/bot$apiKey/")
				.client(okHttp)
				.addConverterFactory(JacksonConverterFactory.create(objectMapper))
				.build()
		retrofitClient = retrofit.create(RetrofitClient::class.java)
	}

	private fun buildOkHTTP() : OkHttpClient = OkHttpClient.Builder()
			.connectTimeout(30, TimeUnit.SECONDS)
			.readTimeout(30, TimeUnit.SECONDS)
			.writeTimeout(30, TimeUnit.SECONDS)
			.build()


	private fun <T> ensureOkResponse(response: Response<TelegramResponse<T>>) {
		if (!response.isSuccessful) {
			val error = retrofit.responseBodyConverter<TelegramError>(
					TelegramError::class.java,
					TelegramError::class.java.annotations
			).convert(response.errorBody())
			logger.error("Error: $error")
			throw BadTelegramResponseException(error)
		}
	}

	override fun getUpdates(getUpdatesMethod: GetUpdatesMethod): List<Update> {
		logger.debug("Getting updates using $getUpdatesMethod")
		val response = retrofitClient.getUpdates(getUpdatesMethod).execute()
		ensureOkResponse(response)
		val result = response.body().result
		logger.debug("Got ${result.size} updates")
		return result
	}

	override fun setWebhook(setWebhookMethod: SetWebhookMethod): Boolean {
		logger.debug("Setting webhook to ${setWebhookMethod.url}")
		val response = retrofitClient.setWebhook(setWebhookMethod).execute()
		ensureOkResponse(response)
		logger.debug("Webhook set")
		return response.body().result
	}

	override fun getMe(getMeMethod: GetMeMethod): User {
		logger.debug("Calling getMe()")
		val response = retrofitClient.getMe().execute()
		ensureOkResponse(response)
		val result = response.body().result
		logger.debug("getMe() successful. Response: $result")
		return result
	}

	override fun sendMessage(sendMessageMethod: SendMessageMethod): Message {
		logger.debug("Sending message using $sendMessageMethod")
		val response = retrofitClient.sendMessage(sendMessageMethod).execute()
		ensureOkResponse(response)
		val result = response.body().result
		logger.debug("sendMessage() successful. Response: $result")
		return result
	}

	override fun answerInlineQuery(answerInlineQueryMethod: AnswerInlineQueryMethod): Boolean {
		logger.debug("Answering inline query usingt: $answerInlineQueryMethod")
		val response = retrofitClient.answerInlineQuery(answerInlineQueryMethod).execute()
		ensureOkResponse(response)
		val result = response.body().result
		logger.debug("answerInlineQuery() successful. Response: $result")
		return result
	}

}