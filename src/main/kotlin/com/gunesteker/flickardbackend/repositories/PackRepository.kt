package com.gunesteker.flickardbackend.repositories

import com.gunesteker.flickardbackend.models.Pack
import org.springframework.data.jpa.repository.JpaRepository

interface PackRepository: JpaRepository<Pack, Long> {
}