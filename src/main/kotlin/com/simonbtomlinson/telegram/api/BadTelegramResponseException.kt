package com.simonbtomlinson.telegram.api

import com.simonbtomlinson.telegram.api.types.TelegramResponse


class BadTelegramResponseException(val response: TelegramResponse<*>) : RuntimeException()