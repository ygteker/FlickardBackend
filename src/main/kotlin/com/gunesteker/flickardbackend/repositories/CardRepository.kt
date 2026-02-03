package com.gunesteker.flickardbackend.repositories

import com.gunesteker.flickardbackend.models.Card
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository: JpaRepository<Card, Long> {
}