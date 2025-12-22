package lesson22.task1

class OrderManager(
    private val orderList: MutableList<Order>
) {
    fun add(newOrder: Order) {
        for (order in orderList) {
            if (order.id == newOrder.id) {
                println("Order with this id already exist.")
                return
            }
        }
        orderList.add(newOrder)
        println("New order was added successfully.")
    }

    fun find(id: Int): Order? {
        return orderList.find { it.id == id }
    }

    fun payOrder(orderToPay: Order) {
        val index = orderList.indexOfFirst { it == orderToPay }
        if (index != -1) {
            orderList[index] = orderToPay.copy(isPaid = true)
        } else {
            println("This order not in list.")
        }
    }

    fun compare(order1: Order, order2: Order): Boolean = order1 == order2
}