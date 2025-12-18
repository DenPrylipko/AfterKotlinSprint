package lesson20.task1

fun main() {
    val eventManager = EventManager(mutableListOf<Event>())

    val event1 = Event(0, EventType.MESSAGE, "Your sister", 2)
    val event2 = Event(1, EventType.MESSAGE, "Your dad", 5)
    val event3 = Event(2, EventType.NOTIFICATION, "Your mom", 20)
    val event4 = Event(3, EventType.ERROR, "Your grandmom and granddad and all your family", 12)

    eventManager.add(event1)
    eventManager.add(event2)
    eventManager.add(event3)
    eventManager.add(event4)

    val filtered = eventManager.filterEvents { it.priority >= 3 }
    val filtered1 = eventManager.filterEvents(
        fun(event: Event): Boolean {
            return event.priority >= 3
        }
    )

    val filtered2 = eventManager.filterEvents {
        val inPriority = it.priority >= 3
        val isError = it.type == EventType.ERROR
        inPriority && isError
    }

    val filtered3 = eventManager.filterEvents(
        fun(event: Event): Boolean {
            return event.message.length > 20
        }
    )

    eventManager.processEvents { println(it.message) }
    eventManager.processEvents { println("id: ${it.id}, type: ${it.type}")}
    eventManager.processEvents(
        fun(event: Event) {
            if (event.priority >= 4) println("[HIGH PRIORITY] ${event.message}")
            else println(event.message)
        }
    )

    val filtered4 = eventManager.filterEvents { it.type == EventType.MESSAGE }
    eventManager.processEvents(filtered4) { println(it.message) }




}