package com.myhome.controller

import com.myhome.dto.CommonResponse
import com.myhome.dto.dwelling.DwellingDTO
import com.myhome.facade.DwellingFacade
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/dwellings")
class DwellingController(
	private val dwellingFacade: DwellingFacade,
) {
	@GetMapping
	fun getDwellings(): CommonResponse<*> {
		return CommonResponse.ok(dwellingFacade.getDwellings())
	}

	@PostMapping
	fun saveDwellings(
		@RequestBody request: DwellingDTO.Save,
	): CommonResponse<*> {
		return CommonResponse.ok(dwellingFacade.save(request))
	}
}