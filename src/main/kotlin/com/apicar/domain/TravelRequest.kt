package com.apicar.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class TravelRequest (
    @Id
    @GeneratedValue
    var id: Long? = null,
    @ManyToOne
    val passenger: Passenger,
    val origin: String,
    val destination: String
)