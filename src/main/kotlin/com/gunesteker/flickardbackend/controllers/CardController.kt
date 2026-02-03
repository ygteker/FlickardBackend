package com.gunesteker.flickardbackend.controllers

import com.gunesteker.flickardbackend.dtos.CardDTO
import com.gunesteker.flickardbackend.models.Card
import com.gunesteker.flickardbackend.services.CardService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cards")
class CardController(
    private val cardService: CardService
) {
    @GetMapping
    fun getAll(): List<CardDTO> = cardService.getAllCards()

    @PostMapping
    fun create(@RequestBody card: CardDTO): CardDTO {
        return cardService.save(card)
    }
}