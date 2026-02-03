package com.gunesteker.flickardbackend.dtos

data class PackDTO(
    var id: Long? = null,
    var name: String = "",
    var premium: Boolean = false,
    var priceCents: Long = 0,
    var cards: List<CardDTO>? = null,
)