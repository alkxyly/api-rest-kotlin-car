package com.apicar.repository

import com.apicar.domain.Driver
import org.springframework.data.jpa.repository.JpaRepository

interface DriverRepository: JpaRepository<Driver, Long> {
}