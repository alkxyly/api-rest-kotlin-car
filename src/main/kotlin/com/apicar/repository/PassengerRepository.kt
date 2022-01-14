package com.apicar.repository

import com.apicar.domain.Passenger
import org.springframework.data.jpa.repository.JpaRepository

interface PassengerRepository : JpaRepository<Passenger, Long> {}