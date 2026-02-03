package com.gunesteker.flickardbackend.mappers

import com.gunesteker.flickardbackend.dtos.CardDTO
import com.gunesteker.flickardbackend.models.Card
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface CardMapper {
    @Mapping(target = "packId", source = "pack.id")
    fun toDto(entity: Card): CardDTO

    @Mapping(target = "pack.id", source = "packId")
    fun toEntity(dto: CardDTO): Card
}