package com.myhome.service

import com.myhome.entity.dwelling.Dwelling
import com.myhome.repository.dwelling.DwellingCustomRepository
import com.myhome.repository.dwelling.DwellingRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true, rollbackFor = [Exception::class])
class DwellingQueryService(
	private val dwellingRepository: DwellingRepository,
	private val dwellingCustomRepository: DwellingCustomRepository,
) {
	fun getDwellings(): List<Dwelling> {
		return dwellingCustomRepository.getDwelling()
	}
}