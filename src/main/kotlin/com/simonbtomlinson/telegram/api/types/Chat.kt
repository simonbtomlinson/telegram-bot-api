package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a chat.
 *
 * @property id Unique identifier for this chat
 * @property type Type of chat. Can be private, group, supergroup, or channel
 * @property title Optional. Title, for channels and group chats
 * @property username Optional. Username, for private chats, supergroups and channels if available
 * @property firstName Optional. First name of the other party in a private chat. first_name in telegram
 * @property lastName Optional. Last name of the other party in a private chat. last_name in telegram
 */
data class Chat(
		val id: Long,
        val type: Type,
        val title: String?,
        val username: String?,
        @JsonProperty("first_name") val firstName: String?,
        @JsonProperty("last_name") val lastName: String?
) {
	enum class Type {
		@JsonProperty("private") PRIVATE,
		@JsonProperty("group") GROUP,
		@JsonProperty("supergroup") SUPERGROUP,
		@JsonProperty("channel") CHANNEL
	}
}