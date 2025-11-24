package lesson11.task2

val productList = mutableListOf<Product>()
val store = Store(productList)
var id = 0

fun main() {


    do {
        showMenu()
        val menuChoice = checkInputToInt("Enter menu option 0-7:")

        when (menuChoice) {
            1 -> {
                store.addProduct(createProduct())
            }

            2 -> {
                with(store) {
                    showAllProducts()
                    addStock(
                        checkInputToInt("Enter ID of the product:"),
                        checkInputToInt("Enter amount of stocks you want to add:")
                    )
                }
            }

            3 -> {
                with (store) {
                    showAllProducts()
                    sellProduct(checkInputToInt("Enter ID of the product:"),
                        checkInputToInt("Enter amount of stocks you want to sell:")
                    )
                }

            }

            4 -> {
                store.showAllProducts()
            }

            5 -> {
                with (store) {
                    showAllProducts()
                    val product = getProduct(checkInputToInt("Enter ID of the product:"))
                    if (product == null) println("Product with this ID doesn't exist.")
                    else product.showInfo()
                }
            }

            6 -> {
                with (store) {
                    showAllProducts()
                    removeProduct(checkInputToInt("Enter ID of the product:"))
                }
            }

            7 -> {
                with (store) {
                    showAllProducts()
                    showExpensiveProducts(checkInputToDouble("Enter price"))
                }
            }

            0 -> break

            else -> println("Unregistered command, enter 0-7.")
        }
    } while (true)

}

fun showMenu() {
    println(
        """
            
            Menu:
        1. Add product
        2. Add stock
        3. Sell product
        4. Show all products
        5. Show product info
        6. Remove product
        7. Show products more expensive than X
        0. Exit
    """.trimIndent()
    )
}

fun createProduct() : Product {
    val name = textInput("Enter new product's name:")
    val price = checkInputToDouble("Enter price:")
    val quantity = checkInputToInt("Enter quantity of $name:")
    return Product(id++, name, price, quantity)
}

fun textInput(prompt: String): String {
    println(prompt)
    print("> ")
    return readln()
}

fun checkInputToInt(prompt: String): Int {
    println(prompt)
    do {
        print("> ")
        val userInput = readln().toIntOrNull()
        if (userInput == null) println("Must be number, try again.")
        else return userInput
    } while (true)
}

fun checkInputToDouble(prompt: String): Double {
    println(prompt)
    do {
        print("> ")
        val userInput = readln().toDoubleOrNull()
        if (userInput == null) println("Must be number, try again.")
        else return userInput
    } while (true)
}