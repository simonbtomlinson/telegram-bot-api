package com.simonbtomlinson.telegram.api.types

open class TelegramResponse<out T>(val ok: Boolean, val result: T)

