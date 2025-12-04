package lesson16.task2

class ExploreQuest(
    title: String,
    reward: Int,
    private val locations: List<String>,
    private val visited: MutableList<String> = mutableListOf<String>(),
) : Quest(title, reward) {

    fun visit(location: String) {
        if (isCompleted) return
        if (!locations.contains(location)) {
            log("Unknown location: $location")
            return
        }
        if (visited.contains(location)){
            log("Already visited: $location")
            return
        }

        visited.add(location)
        log("Location: $location visited. Progress: ${visited.size}/${locations.size}.")

        if (visited.size == locations.size) complete()
    }

    override fun info() {
        super.info()
        println("Locations: ${locations.joinToString(", ")}")
        println("Visited: ${visited.joinToString(", ")}")
        println("Progress: ${visited.size}/${locations.size}.")
    }
}