package com.myhome.enums

enum class DwellingType(
	override val description: String,
) : Describable {
	APARTMENT("아파트"),
	ONE_ROOM("원룸"),
	TWO_ROOM("투룸"),
}