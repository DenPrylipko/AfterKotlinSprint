package lesson19.task2

enum class TaskStatus(val description: String) {
    CREATED("Task created.") {
        override fun nextOnStart(): TaskStatus = IN_PROGRESS
        override fun nextOnCancel(): TaskStatus = CANCELLED
    },
    IN_PROGRESS("Task in progress.") {
        override fun nextOnPause(): TaskStatus = PAUSED
        override fun nextOnFinish(): TaskStatus = COMPLETED
        override fun nextOnCancel(): TaskStatus = CANCELLED
    },
    PAUSED("Task paused.") {
        override fun nextOnStart(): TaskStatus = IN_PROGRESS
        override fun nextOnCancel(): TaskStatus = CANCELLED
    },
    COMPLETED("Task completed."),
    CANCELLED("Task cancelled.");

    open fun nextOnStart(): TaskStatus? = null
    open fun nextOnPause(): TaskStatus? = null
    open fun nextOnFinish(): TaskStatus? = null
    open fun nextOnCancel(): TaskStatus? = null
}