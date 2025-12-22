package lesson22.task1

data class Order(
    val id: Int,
    val customerName: String,
    val items: List<String>,
    val totalPrice: Double,
    val isPaid: Boolean,
) {
    override fun toString(): String {
        return "Order details: ID: $id, Customer Name: $customerName, Items: $items, Total Price: $totalPrice, Paid: $isPaid."
    }
}