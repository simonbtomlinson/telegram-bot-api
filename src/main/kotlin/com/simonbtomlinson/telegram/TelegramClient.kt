package com.simonbtomlinson.telegram

import com.simonbtomlinson.telegram.types.Message
import com.simonbtomlinson.telegram.types.Update
import com.simonbtomlinson.telegram.types.User
import com.simonbtomlinson.telegram.types.method.*


interface TelegramClient {
	fun getUpdates(getUpdatesMethod: GetUpdatesMethod): List<Update>

	fun setWebhook(setWebhookMethod: SetWebhookMethod): Boolean

	fun getMe(getMeMethod: GetMeMethod = GetMeMethod()): User

	fun sendMessage(sendMessageMethod: SendMessageMethod): Message

	fun answerInlineQuery(answerInlineQueryMethod: AnswerInlineQueryMethod): Boolean
}