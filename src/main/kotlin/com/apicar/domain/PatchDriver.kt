package com.apicar.domain

import java.time.LocalDate

data class PatchDriver(
    val name: String?,
    val birthDate: LocalDate?
)