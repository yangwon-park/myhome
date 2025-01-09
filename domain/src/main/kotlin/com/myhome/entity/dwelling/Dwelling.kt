package com.myhome.entity.dwelling

import com.myhome.entity.enums.DwellingType
import jakarta.persistence.*

@Entity
@Table(name = "dwelling")
class Dwelling(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dwelling_id")
	val id: Long? = null,

	val name: String,

	@Enumerated(EnumType.STRING)
	val type: DwellingType,
)