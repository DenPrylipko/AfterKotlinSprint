package lesson22.task1

fun main() {
    val orderManager = OrderManager(mutableListOf<Order>())

    val order1 = Order(0, "Denis", listOf("paperoni", "laptop"), 4000.0, false)

    orderManager.add(order1)
    val foundOrder = orderManager.find(0)
    val paidOrder = orderManager.payOrder(order1)

    println(order1.toString())
    println(paidOrder.toString())

}