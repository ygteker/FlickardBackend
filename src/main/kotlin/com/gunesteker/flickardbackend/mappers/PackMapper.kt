package com.gunesteker.flickardbackend.mappers

import com.gunesteker.flickardbackend.dtos.PackDTO
import com.gunesteker.flickardbackend.models.Pack
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring", uses = [CardMapper::class])
interface PackMapper {
    fun toDto(entity: Pack): PackDTO

    @Mapping(target = "cards", ignore = true)
    fun toEntity(dto: PackDTO): Pack
}
