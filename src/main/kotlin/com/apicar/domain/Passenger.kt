package com.apicar.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Passenger (
            @Id
            @GeneratedValue
            var id: Long? =null,
            val name: String
        )