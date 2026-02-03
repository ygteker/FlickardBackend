package com.gunesteker.flickardbackend.controllers

import com.gunesteker.flickardbackend.dtos.PackDTO
import com.gunesteker.flickardbackend.models.Pack
import com.gunesteker.flickardbackend.services.PackService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/packs")
class PackController(
    private val packService: PackService,
) {
    @GetMapping
    fun getAll(): List<PackDTO> = packService.getAllPacks()

    @PostMapping
    fun create(@RequestBody packDto: PackDTO): PackDTO = packService.save(packDto)
}