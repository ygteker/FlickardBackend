package com.gunesteker.flickardbackend.models

import jakarta.persistence.*

@Entity
@Table(name = "packs")
open class Pack(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null,

    @Column(nullable = false)
    open var name: String = "",

    @Column(nullable = false)
    open var premium: Boolean = false,

    @Column(name = "price_cents", nullable = false)
    open var priceCents: Long = 0,

    @OneToMany(
        mappedBy = "pack",
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    open var cards: MutableList<Card> = mutableListOf()
)