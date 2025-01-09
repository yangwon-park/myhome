package com.myhome.repository.dwelling

import com.myhome.entity.dwelling.Dwelling
import com.myhome.entity.dwelling.QDwelling.dwelling
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class DwellingCustomRepository(
	private val queryFactory: JPAQueryFactory,
) {
	fun getDwelling(): List<Dwelling> {
		return queryFactory
			.select(dwelling)
			.from(dwelling)
			.fetch()
	}
}