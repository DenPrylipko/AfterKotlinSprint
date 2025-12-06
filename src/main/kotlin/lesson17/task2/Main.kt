package lesson17.task2

fun main() {

    val inventory = Inventory()

    val itemCobblestone = Item("Cobblestone", "common", 3.0, 2)
    val itemMap = Item("Map", "rare", 1.2, 10)
    val itemWheel = Item("Wheel", "common", 5.0, 3)
    val item1 = Item("SDdsaw", "Expensive", 300.0, 222)

    inventory.printInventory()
    inventory.addItem(itemCobblestone)
    inventory.addItem(itemMap)
    inventory.addItem(itemWheel)
    inventory.addItem(item1)
    inventory.printInventory()

}