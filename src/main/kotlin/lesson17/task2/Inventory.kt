package lesson17.task2

class Inventory(
    private val items: MutableList<Item> = mutableListOf()
) {

    fun addItem(item: Item) {
        if (item.weight > 20) {
            println("Item: ${item.name} is too heavy.")
            return
        }
        if (item.name == "") return
        if (item.rarity == "") return
        if (item.weight == 0.0) return
        if (item.value == 0) return
        items.add(item)
    }

    fun printInventory() {
        if (items.isEmpty()) {
            println("Inventory is empty.")
            return
        }
        for (i in items) {
            println("${i.name} - ${i.rarity} - ${i.getFormatedWeight()} kg - ${i.getFormatedValue()}")
        }
    }

}