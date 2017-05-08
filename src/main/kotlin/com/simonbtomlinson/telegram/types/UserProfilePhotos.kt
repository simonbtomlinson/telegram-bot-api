package com.simonbtomlinson.telegram.types

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*


data class UserProfilePhotos(
		@JsonProperty("total_count") val totalCount: Int,
        val photos: Array<Array<PhotoSize>>
) {

	override fun equals(other: Any?): Boolean{
		if (this === other) return true
		if (other?.javaClass != javaClass) return false

		other as UserProfilePhotos

		if (totalCount != other.totalCount) return false
		if (!Arrays.equals(photos, other.photos)) return false

		return true
	}

	override fun hashCode(): Int{
		var result = totalCount
		result = 31 * result + Arrays.hashCode(photos)
		return result
	}
}