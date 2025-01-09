package com.myhome.facade

import com.myhome.command.DwellingCommand
import com.myhome.dto.dwelling.DwellingDTO
import com.myhome.entity.dwelling.Dwelling
import com.myhome.service.DwellingCommandService
import com.myhome.service.DwellingQueryService
import org.springframework.stereotype.Service

@Service
class DwellingFacade(
	private val dwellingCommandService: DwellingCommandService,
	private val dwellingQueryService: DwellingQueryService,
) {
	fun getDwellings(): List<Dwelling> {
		return dwellingQueryService.getDwellings()
	}

	fun save(request: DwellingDTO.Save): Long? {
		return dwellingCommandService.save(
			DwellingCommand.Save(
				request.name,
				request.type,
			),
		)
	}
}