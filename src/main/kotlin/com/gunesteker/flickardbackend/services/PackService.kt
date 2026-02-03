package com.gunesteker.flickardbackend.services

import com.gunesteker.flickardbackend.dtos.PackDTO
import com.gunesteker.flickardbackend.mappers.CardMapper
import com.gunesteker.flickardbackend.mappers.PackMapper
import com.gunesteker.flickardbackend.models.Pack
import com.gunesteker.flickardbackend.repositories.PackRepository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PackService(
    private val packRepository: PackRepository,
    private val packMapper: PackMapper,
) {

    @Transactional(readOnly = true)
    fun getAllPacks(): List<PackDTO> = packRepository.findAll().map { packMapper.toDto(it) }

    @Transactional
    fun save(packDto: PackDTO): PackDTO {
        val newPack = packRepository.save(packMapper.toEntity(packDto))
        return packMapper.toDto(newPack)
    }

    @Transactional(readOnly = true)
    fun getPackById(id: Long): PackDTO = packMapper.toDto(
        packRepository.findById(id).orElseThrow { ChangeSetPersister.NotFoundException() }
    )

}