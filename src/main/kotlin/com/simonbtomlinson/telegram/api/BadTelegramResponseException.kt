package com.simonbtomlinson.telegram.api

import com.simonbtomlinson.telegram.api.types.TelegramError


class BadTelegramResponseException(telegramError: TelegramError) : RuntimeException(telegramError.toString())