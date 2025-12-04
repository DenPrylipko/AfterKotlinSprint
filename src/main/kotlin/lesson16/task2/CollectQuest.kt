package lesson16.task2

class CollectQuest(
    title: String,
    reward: Int,
    private val itemsRequired: Int,
    private var itemsCollected: Int = 0,
) : Quest(title, reward) {

    fun collectItem() {
        if (isCompleted) return
        itemsCollected++
        log("Item collected. Progress: $itemsCollected/$itemsRequired.")
        if (itemsCollected == itemsRequired) complete()
    }

    override fun info() {
        super.info()
        println("Progress: $itemsCollected/$itemsRequired.")
    }
}