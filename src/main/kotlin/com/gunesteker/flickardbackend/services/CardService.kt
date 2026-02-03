package com.gunesteker.flickardbackend.services

import com.gunesteker.flickardbackend.dtos.CardDTO
import com.gunesteker.flickardbackend.dtos.PackDTO
import com.gunesteker.flickardbackend.mappers.CardMapper
import com.gunesteker.flickardbackend.mappers.PackMapper
import com.gunesteker.flickardbackend.models.Card
import com.gunesteker.flickardbackend.models.Pack
import com.gunesteker.flickardbackend.repositories.CardRepository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CardService(
    private val cardRepository: CardRepository,
    private val cardMapper: CardMapper,
    private val packMapper: PackMapper
) {
    @Transactional(readOnly = true)
    fun getAllCards(): List<CardDTO> = cardRepository.findAll().map { cardMapper.toDto(it) }

    @Transactional
    fun save(cardDto: CardDTO): CardDTO {
        val newCard = cardRepository.save(cardMapper.toEntity(cardDto))
        return cardMapper.toDto(newCard)
    }

    @Transactional(readOnly = true)
    fun getCardById(id: Long): CardDTO =
        cardMapper.toDto(
            cardRepository.findById(id).orElseThrow { ChangeSetPersister.NotFoundException() }
        )

    @Transactional(readOnly = true)
    fun getPackByCardId(id: Long): PackDTO? =
        packMapper.toDto(
            cardRepository.findById(id).orElseThrow() { ChangeSetPersister.NotFoundException() }
                .pack ?: throw IllegalStateException("Pack not found")
        )
}