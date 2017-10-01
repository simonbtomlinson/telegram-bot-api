package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty


data class TelegramError(val ok: Boolean, @JsonProperty("error_code") val errorCode: Int, val description: String?)