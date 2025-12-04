package lesson16.task2

abstract class Quest(
    private val title: String,
    private val reward: Int,
    protected var isCompleted: Boolean = false,
) {

    fun start() {
        println("Quest '$title' started!")
    }

    protected fun complete() {
        isCompleted = true
        println("Quest '$title' completed! Reward: $reward coins.")
    }

    open fun info() {
        println("Quest: $title, Reward: $reward, Completed: ${if (isCompleted) "yes" else "no"}.")
    }

    protected fun log(message: String) {
        println("[QUEST LOG] $message")
    }
}