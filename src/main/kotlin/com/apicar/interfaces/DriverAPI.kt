package com.apicar.interfaces

import com.apicar.domain.Driver
import com.apicar.repository.DriverRepository
import com.apicar.domain.PatchDriver
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
            .orElseThrow{ ResponseStatusException(HttpStatus.NOT_FOUND) }

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

    @PatchMapping("/{id}")
    fun incrementalUpdateDriver(@PathVariable("id") id:Long, @RequestBody driver:PatchDriver) : Driver {
        val foundDriver = findDriver(id)
        val copyDriver = foundDriver.copy(
            birthDate = driver.birthDate ?: foundDriver.birthDate,
            name = driver.name ?: foundDriver.name
        )
        return driverRepository.save(copyDriver)
    }

    @DeleteMapping("/{id}")
    fun deleteDriver(@PathVariable("id") id: Long) {
       val driver = driverRepository.findById(id)
            .orElseThrow{ ResponseStatusException(HttpStatus.NOT_FOUND) }
        return driverRepository.deleteById(id);
    }
}