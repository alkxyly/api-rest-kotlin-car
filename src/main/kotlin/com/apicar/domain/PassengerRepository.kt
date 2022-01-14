package com.apicar.domain

import org.springframework.data.jpa.repository.JpaRepository

interface PassengerRepository : JpaRepository<Passenger, Long> {}