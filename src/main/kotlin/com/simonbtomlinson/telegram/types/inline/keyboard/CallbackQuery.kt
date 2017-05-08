package com.simonbtomlinson.telegram.types.inline.keyboard

import com.simonbtomlinson.telegram.types.Message
import com.simonbtomlinson.telegram.types.User


data class CallbackQuery(
		val id: String,
        val from: User,
        val message: Message?
)