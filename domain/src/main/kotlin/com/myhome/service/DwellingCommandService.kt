package com.myhome.service

import com.myhome.command.DwellingCommand
import com.myhome.repository.dwelling.DwellingRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class DwellingCommandService(
	private val dwellingRepository: DwellingRepository,
) {
	fun save(request: DwellingCommand.Save): Long? {
		return dwellingRepository.save(request.toEntity()).id
	}
}