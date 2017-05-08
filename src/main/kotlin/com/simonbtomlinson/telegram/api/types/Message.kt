package com.simonbtomlinson.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant
import java.util.*

/**
 * This object represents a message.
 * @property [messageId] Unique message identifier
 * @property [from] Optional. Sender, can be empty for messages sent to channels
 * @property [date] Date / time the message was sent
 * @property [chat] Conversation the message belongs to
 * @property [forwardFrom] Optional. For forwarded messages, sender of the original message
 * @property [forwardFromChat] Optional. For messages forwarded from a channel, information about the original channel
 * @property [forwardDate] Optional. For forwarded messages, date the original message was sent in Unix time
 * @property [replyToMessage]  	Optional. For replies, the original message. Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply.
 * @property [editDate] Optional. Date the message was last edited
 * @property [text] Optional. For text messages, the actual UTF-8 text of the message, 0-4096 characters.
 */
data class Message(
		@JsonProperty("message_id") val messageId: Int,
		@JsonProperty("from") val from: User?,
		@JsonProperty("chat") val chat: Chat,
		@JsonProperty("date") val date: Instant,
        @JsonProperty("forward_from") val forwardFrom: User?,
        @JsonProperty("forward_from_chat") val forwardFromChat: Chat?,
        @JsonProperty("forward_date") val forwardDate: Instant?,
        @JsonProperty("reply_to_message") val replyToMessage: Message?,
        @JsonProperty("edit_date") val editDate: Instant?,
		@JsonProperty("text") val text: String?,
        @JsonProperty("entities") val entities: Array<MessageEntity>?,
        @JsonProperty("audio") val audio: Audio?,
        @JsonProperty("document") val document: Document?,
        @JsonProperty("photo") val photo: Array<PhotoSize>?,
        @JsonProperty("sticker") val sticker: Sticker?,
        @JsonProperty("video") val video: Video?,
        @JsonProperty("voice") val voice: Voice?,
        @JsonProperty("caption") val caption: String?,
        @JsonProperty("location") val location: Location?,
        @JsonProperty("contact") val contact: Contact?
) {

	override fun hashCode(): Int{
		var result = messageId
		result = 31 * result + (from?.hashCode() ?: 0)
		result = 31 * result + chat.hashCode()
		result = 31 * result + date.hashCode()
		result = 31 * result + (forwardFrom?.hashCode() ?: 0)
		result = 31 * result + (forwardFromChat?.hashCode() ?: 0)
		result = 31 * result + (forwardDate?.hashCode() ?: 0)
		result = 31 * result + (replyToMessage?.hashCode() ?: 0)
		result = 31 * result + (editDate?.hashCode() ?: 0)
		result = 31 * result + (text?.hashCode() ?: 0)
		result = 31 * result + (entities?.let { Arrays.hashCode(it) } ?: 0)
		return result
	}

	override fun equals(other: Any?): Boolean{
		if (this === other) return true
		if (other?.javaClass != javaClass) return false

		other as Message

		if (messageId != other.messageId) return false
		if (from != other.from) return false
		if (chat != other.chat) return false
		if (date != other.date) return false
		if (forwardFrom != other.forwardFrom) return false
		if (forwardFromChat != other.forwardFromChat) return false
		if (forwardDate != other.forwardDate) return false
		if (replyToMessage != other.replyToMessage) return false
		if (editDate != other.editDate) return false
		if (text != other.text) return false
		if (!Arrays.equals(entities, other.entities)) return false

		return true
	}
}

