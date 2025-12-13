package lesson19.task1

class Operation(
    val id: Int,
    val type: OperationType,
    var status: OperationStatus = OperationStatus.CREATED,
) {

    fun start() {
        TODO("Implement start logic")
    }

    fun complete() {
        TODO("Implement complete logic")
    }

    fun fail(reason: String) {
        TODO("Implement failure logic")
    }

}