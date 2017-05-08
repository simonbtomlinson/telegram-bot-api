package com.simonbtomlinson.telegram.types

open class TelegramResponse<out T>(val ok: Boolean, val result: T)

