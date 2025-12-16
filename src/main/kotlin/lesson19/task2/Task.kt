package lesson19.task2

class Task(
    val id: Int,
    val title: String,
    var status: TaskStatus,
) {
    fun start() {
        if (status.nextOnStart() == null) {
            println("You can't start this task.")
            return
        }

        status = status.nextOnStart()!!
        println(status.description)
    }

    fun pause() {
        if (status.nextOnPause() == null) {
            println("You can't pause this task.")
            return
        }

        status = status.nextOnPause()!!
        println(status.description)
    }

    fun finish() {
        if (status.nextOnFinish() == null) {
            println("You can't finish this task.")
            return
        }

        status = status.nextOnFinish()!!
        println(status.description)
    }

    fun cancel() {
        if (status.nextOnCancel() == null) {
            println("You can't cancel this task.")
            return
        }

        status = status.nextOnCancel()!!
        println(status.description)
    }

}