package lesson19.task1

fun main() {

    val manager = OperationManager()

    val operation = Operation(
        0,
        OperationType.DOWNLOAD,
    )

    val operation2 = Operation(
        1,
        OperationType.UPLOAD,
    )

    val operation3 = Operation(
        2,
        OperationType.DELETE,
    )

    manager.add(operation)
    manager.add(operation2)
    manager.add(operation3)

    manager.startOperation(2)
    manager.completeOperation(2)
    manager.failOperation(1, "just because failed")



}

fun performNetworkAccess() {
    TODO("Network layer will be implemented later.")
}

fun getOperationFromDatabase(id: Int): Operation {
    TODO("Database will be implemented later.")
}