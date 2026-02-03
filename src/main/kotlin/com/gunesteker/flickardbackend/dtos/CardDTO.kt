package com.gunesteker.flickardbackend.dtos

data class CardDTO(
    var id: Long? = null,
    var front: String = "",
    var back: String = "",
    var packId: Long? = null,
)