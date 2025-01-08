package com.myhome.dwelling

import jakarta.persistence.*

@Entity
@Table(name = "dwelling")
class Dwelling(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dwelling_id")
	val id: Long? = null,
)