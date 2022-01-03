package com.apicar.interfaces

import com.apicar.domain.Driver
import com.apicar.domain.DriverRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@Service
@RestController
@RequestMapping("/drivers", produces = [MediaType.APPLICATION_JSON_VALUE])
class DriverAPI (val driverRepository: DriverRepository){

    @GetMapping()
    fun listDrivers() : List<Driver> = driverRepository.findAll();

    @GetMapping("/{id}")
    fun findDriver(@PathVariable id: Long): Driver = driverRepository.findById(id)
        .orElseThrow{ ResponseStatusException(HttpStatus.NOT_FOUND)}

    @PostMapping()
    fun createDriver(@RequestBody driver: Driver): Driver = driverRepository.save(driver);

    @PutMapping("/{id}")
    fun fullUpdateDriver(@PathVariable id: Long, @RequestBody driver: Driver): Driver {
        val foundDriver: Driver = driverRepository.findById(id).orElseThrow();
        val copyDriver = foundDriver.copy(
            birthDate = driver.birthDate,
            name =  driver.name
        )
        return driverRepository.save(copyDriver);
    }
}