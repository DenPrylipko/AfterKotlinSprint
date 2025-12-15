package lesson19.task2

fun main() {

    val task1 = Task(0, "First task", TaskStatus.CREATED)
    task1.start()
    task1.pause()
    task1.start()
    task1.finish()

    println()

    val task2 = Task(1, "Second task", TaskStatus.CREATED)
    task2.start()
    task2.cancel()

    println()

    val task3 = Task(2, "Third task", TaskStatus.CREATED)
    task3.finish()
}