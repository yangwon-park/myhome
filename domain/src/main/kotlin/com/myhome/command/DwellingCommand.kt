package com.myhome.command

import com.myhome.entity.dwelling.Dwelling
import com.myhome.entity.enums.DwellingType

class DwellingCommand {
	data class Save(
		val name: String,
		val type: DwellingType,
	) {
		fun toEntity(): Dwelling {
			return Dwelling(
				null,
				name,
				type,
			)
		}
	}
}