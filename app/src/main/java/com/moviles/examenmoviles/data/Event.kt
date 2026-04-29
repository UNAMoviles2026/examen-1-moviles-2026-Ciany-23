package com.moviles.examenmoviles.data

data class Event(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val description: String,
    val location: String,
    val date: String,
    val time: String,
    val maxCapacity: Int,
    val entryPrice: Double?,
    val availabilityStatus: EventStatus
)

enum class EventStatus {
    AVAILABLE,
    ALMOST_FULL,
    FULL
}