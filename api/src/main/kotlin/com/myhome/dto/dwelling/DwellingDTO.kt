package com.myhome.dto.dwelling

import com.myhome.entity.enums.DwellingType

class DwellingDTO {
	data class Save(
		val name: String,
		val type: DwellingType,
	)
}