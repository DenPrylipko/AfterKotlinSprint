package lesson19.task1

class OperationManager {
    private val operations = mutableListOf<Operation>()

    fun add(operation: Operation) {
        if (operations.contains(operation)) {
            println("This operation already in the list.")
            return
        }

        operations.add(operation)
        println("Operation with type: ${operation.type} was added to list.")
    }

    fun startOperation(id: Int) {
        for (i in operations) {
            if (i.id == id) {
                if (i.status == OperationStatus.CREATED) {
                    i.status = OperationStatus.IN_PROGRESS
                } else {
                    println("Operation was already started before.")
                }
                return
            }
        }

        println("Operation with id: $id not found.")

    }

    fun completeOperation(id: Int) {
        val operation = operations.find {it.id == id}

        if (operation == null) {
            println("Operation with id: $id not found.")
            return
        }

        when (operation.status) {
            OperationStatus.IN_PROGRESS -> {
                operation.status = OperationStatus.COMPLETED
            }

            OperationStatus.CREATED -> {
                println("Firstly you have to start Operation.")
            }

            OperationStatus.COMPLETED -> {
                println("Operation was already completed.")
            }

            OperationStatus.FAILED -> {
                println("Cannot complete failed operation.")
            }
        }

    }

    fun failOperation(id: Int, reason: String) {
        val operation = operations.find { it.id == id }

        if (operation == null) {
            println("Operation with id: $id not found.")
            return
        }

        when (operation.status) {
            OperationStatus.COMPLETED -> {
                println("Cannot fail operation because it is already completed.")
            }

            OperationStatus.FAILED -> {
                println("Operation has already failed.")
            }

            else -> {
                operation.status = OperationStatus.FAILED
                println("Operation failed, the reason: $reason.")
            }
        }

    }
}