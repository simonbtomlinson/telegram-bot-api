package com.simonbtomlinson.telegram.api.client

import com.simonbtomlinson.telegram.api.types.Message
import com.simonbtomlinson.telegram.api.types.Update
import com.simonbtomlinson.telegram.api.types.User
import com.simonbtomlinson.telegram.api.types.method.*


interface TelegramClient {
	fun getUpdates(getUpdatesMethod: GetUpdatesMethod): List<Update>

	fun setWebhook(setWebhookMethod: SetWebhookMethod): Boolean

	fun getMe(getMeMethod: GetMeMethod = GetMeMethod()): User

	fun sendMessage(sendMessageMethod: SendMessageMethod): Message

	fun answerInlineQuery(answerInlineQueryMethod: AnswerInlineQueryMethod): Boolean
}