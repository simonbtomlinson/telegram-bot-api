package com.simonbtomlinson.telegram.api.types.inline.keyboard

import com.simonbtomlinson.telegram.api.types.Message
import com.simonbtomlinson.telegram.api.types.User


data class CallbackQuery(
		val id: String,
        val from: User,
        val message: Message?
)