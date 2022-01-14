package com.apicar.repository

import com.apicar.domain.TravelRequest
import org.springframework.data.jpa.repository.JpaRepository

interface TravelRequestRepository : JpaRepository<TravelRequest, Long> {}