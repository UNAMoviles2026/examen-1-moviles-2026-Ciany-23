package com.moviles.examenmoviles.data

/**
 * Simulated event data used across the application.
 * Represents a realistic set of recreational events.
 */
val mockEvents = listOf(
    Event(
        id = 1,
        name = "Live Jazz Night",
        imageUrl = "",
        description = "An unforgettable evening featuring local jazz musicians performing classic and contemporary pieces. Enjoy great music in a relaxed outdoor setting with food trucks and artisan drinks available throughout the night.",
        location = "Central Park Amphitheater",
        date = "May 10, 2025",
        time = "7:00 PM",
        maxCapacity = 200,
        entryPrice = 12.50,
        availabilityStatus = EventStatus.AVAILABLE
    ),
    Event(
        id = 2,
        name = "Morning Yoga in the Park",
        imageUrl = "",
        description = "Start your weekend with a guided outdoor yoga session suitable for all levels. Bring your mat and enjoy a peaceful practice surrounded by nature. Instructor-led with breathwork and meditation included.",
        location = "Riverside Green Park",
        date = "May 11, 2025",
        time = "8:00 AM",
        maxCapacity = 40,
        entryPrice = null,
        availabilityStatus = EventStatus.ALMOST_FULL
    ),
    Event(
        id = 3,
        name = "Street Art Festival",
        imageUrl = "",
        description = "A two-day urban art celebration featuring over 30 local and international artists transforming the city walls into a giant outdoor gallery. Live painting sessions, art workshops, and guided tours available.",
        location = "Downtown Arts District",
        date = "May 17–18, 2025",
        time = "10:00 AM",
        maxCapacity = 500,
        entryPrice = null,
        availabilityStatus = EventStatus.AVAILABLE
    ),
    Event(
        id = 4,
        name = "Indie Film Screening",
        imageUrl = "",
        description = "An open-air screening of award-winning independent films from Latin American directors. The evening includes a Q&A session with one of the filmmakers and complimentary popcorn for all attendees.",
        location = "Rooftop Cinema – Building 9",
        date = "May 22, 2025",
        time = "6:30 PM",
        maxCapacity = 80,
        entryPrice = 8.00,
        availabilityStatus = EventStatus.FULL
    ),
    Event(
        id = 5,
        name = "Food & Culture Fair",
        imageUrl = "",
        description = "Explore the flavors of more than 15 countries through food stands, cultural performances, and traditional crafts. A family-friendly event celebrating diversity with live music and dance showcases.",
        location = "Municipal Convention Center",
        date = "May 24, 2025",
        time = "11:00 AM",
        maxCapacity = 1000,
        entryPrice = 5.00,
        availabilityStatus = EventStatus.AVAILABLE
    ),
    Event(
        id = 6,
        name = "Tech Startup Pitch Night",
        imageUrl = "",
        description = "Watch emerging local startups pitch their ideas to a panel of investors and industry experts. Great networking opportunity for entrepreneurs, developers, and investors alike. Light refreshments included.",
        location = "Innovation Hub – Room 3A",
        date = "May 28, 2025",
        time = "5:00 PM",
        maxCapacity = 60,
        entryPrice = null,
        availabilityStatus = EventStatus.ALMOST_FULL
    )
)