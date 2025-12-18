package lesson20.task1

class EventManager(
    private val eventList: MutableList<Event>
) {
    fun add(newEvent: Event) {
        val event = eventList.find { it.id == newEvent.id }

        if (event != null) {
            println("Event already in list.")
            return
        }

        eventList.add(newEvent)
        println("New event was added successfully.")
    }

    fun remove(id: Int) {
        val event = eventList.find { it.id == id }

        if (event == null) {
            println("Event with id: $id wasn't found in the event list.")
            return
        }

        eventList.remove(event)
        println("Event with id: $id was successfully removed.")
    }

    fun filterEvents(
        predicate: (Event) -> Boolean
    ): List<Event> {
        val result = mutableListOf<Event>()

        for (event in eventList) {
            if (predicate(event)) {
                result.add(event)
            }
        }

        return result
    }

    fun processEvents(
        action: (Event) -> Unit,
    ) {
        eventList.forEach { action(it) }
    }

    fun processEvents(
        events: List<Event>,
        action: (Event) -> Unit,
    ) {
        events.forEach { action(it) }
    }

}