package com.gunesteker.flickardbackend.models

import jakarta.persistence.*

@Entity
@Table(name = "cards")
open class Card(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null,

    @Column(nullable = false)
    open var front: String = "",

    @Column(nullable = false)
    open var back: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pack_id", nullable = false)
    open var pack: Pack? = null
)