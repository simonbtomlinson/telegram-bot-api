package com.simonbtomlinson.telegram

import com.simonbtomlinson.telegram.types.TelegramResponse


class BadTelegramResponseException(val response: TelegramResponse<*>) : RuntimeException()