package com.apicar.interfaces

import com.apicar.domain.Driver
import com.apicar.domain.DriverRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Service
@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class DriverAPI (val driverRepository: DriverRepository){

    @GetMapping("/drivers")
    fun listDrivers() : List<Driver> = driverRepository.findAll();

}