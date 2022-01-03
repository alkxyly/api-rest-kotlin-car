package com.apicar.domain

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Driver (
        @Id
        @GeneratedValue
        var id: Long? = null,
        val name: String = "",
        val birthDate: LocalDate? = null
        )