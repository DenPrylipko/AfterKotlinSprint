package lesson12.task1


fun main() {

    val product1 = createNewProduct()
    val product2 = createNewProduct()
    val product3 = createNewProduct()
    println()

    product1.info()
    println()
    product2.info()
    println()
    product3.info()

}

fun createNewProduct(): Product {
    val name = readString("Enter new product's name:")
    val price = readDouble("Enter price:")
    val category = readString("Enter category:")
    val discount = readInt("Enter discount percent:")
    return Product(name, price, category, discount)
}


fun readString(prompt: String): String {
    println(prompt)
    print("> ")
    return readln()
}

fun readInt(prompt: String): Int {
    println(prompt)
    do {
        print("> ")
        val number = readln().toIntOrNull()
        if (number == null) println("Must be number.")
        else return number
    } while (true)
}

fun readDouble(prompt: String): Double {
    println(prompt)
    do {
        print("> ")
        val number = readln().toDoubleOrNull()
        if (number == null) println("Must be number.")
        else return number
    } while (true)

}