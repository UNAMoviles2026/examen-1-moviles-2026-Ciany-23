package com.moviles.examenmoviles.navigation

object AppDestinations {
    const val EVENTS     = "events"
    const val EVENT_DETAIL = "event_detail/{eventId}"

    fun eventDetail(eventId: Int) = "event_detail/$eventId"
}