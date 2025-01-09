package com.myhome.repository.dwelling

import com.myhome.entity.dwelling.Dwelling
import org.springframework.data.jpa.repository.JpaRepository

interface DwellingRepository : JpaRepository<Dwelling, Long>