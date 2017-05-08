package com.simonbtomlinson.telegram.types

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.
 *
 * @property [type] Type of the entity
 * @property [offset] Offset in UTF-16 code units to the start of the entity
 * @property [length] Length of the entity in UTF-16 code units
 * @property [url] Optional. For [Type.TEXT_LINK] only, url that will be opened after user taps on the text
 * @property [user] Optional. For [Type.TEXT_MENTION] only, the mentioned user
 *
 * @see <a href="https://core.telegram.org/bots/api#messageentity">Telegram Documentation</a>
 */
data class MessageEntity(
		val type: Type,
		val offset: Int,
        val length: Int,
        val url: String?,
        val user: User?
) {
	enum class Type {
		@JsonProperty("mention") MENTION,
		@JsonProperty("hashtag") HASHTAG,
		@JsonProperty("bot_command") BOT_COMMAND,
		@JsonProperty("url") URL,
		@JsonProperty("email") EMAIL,
		@JsonProperty("bold") BOLD,
		@JsonProperty("italic") ITALIC,
		@JsonProperty("code") CODE,
		@JsonProperty("pre") PRE,
		@JsonProperty("text_link") TEXT_LINK,
		@JsonProperty("text_mention") TEXT_MENTION
	}
}