package com.simonbtomlinson.telegram.api.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.simonbtomlinson.telegram.api.BadTelegramResponseException
import com.simonbtomlinson.telegram.api.types.*
import com.simonbtomlinson.telegram.api.types.method.*
import okhttp3.OkHttpClient
import retrofit2.Call
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

class RetrofitTelegramClient(apiKey: String) : TelegramClient {

	private val retrofitClient: RetrofitClient

	init {
		val okHttp =  buildOkHTTP()
		val retrofit = Retrofit.Builder()
				.baseUrl("https://api.telegram.org/bot$apiKey/")
				.client(okHttp)
				.addConverterFactory(JacksonConverterFactory.create(ObjectMapper().findAndRegisterModules()))
				.build()
		retrofitClient = retrofit.create(RetrofitClient::class.java)
	}

	private fun buildOkHTTP() : OkHttpClient = OkHttpClient.Builder()
			.connectTimeout(30, TimeUnit.SECONDS)
			.readTimeout(30, TimeUnit.SECONDS)
			.writeTimeout(30, TimeUnit.SECONDS)
			.build()


	private fun <T> ensureOkResponse(response: TelegramResponse<T>) {
		if (!response.ok) {
			throw BadTelegramResponseException(response)
		}
	}

	override fun getUpdates(getUpdatesMethod: GetUpdatesMethod): List<Update> {
		val response = retrofitClient.getUpdates(getUpdatesMethod).execute().body()
		ensureOkResponse(response)
		return response.result
	}

	override fun setWebhook(setWebhookMethod: SetWebhookMethod): Boolean {
		val response = retrofitClient.setWebhook(setWebhookMethod).execute().body()
		ensureOkResponse(response)
		return response.result
	}

	override fun getMe(getMeMethod: GetMeMethod): User {
		val response = retrofitClient.getMe().execute().body()
		ensureOkResponse(response)
		return response.result
	}

	override fun sendMessage(sendMessageMethod: SendMessageMethod): Message {
		val response = retrofitClient.sendMessage(sendMessageMethod).execute().body()
		ensureOkResponse(response)
		return response.result
	}

	override fun answerInlineQuery(answerInlineQueryMethod: AnswerInlineQueryMethod): Boolean {
		val response = retrofitClient.answerInlineQuery(answerInlineQueryMethod).execute().body()
		ensureOkResponse(response)
		return response.result
	}

}