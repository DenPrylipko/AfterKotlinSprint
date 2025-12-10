package lesson18.task1.actions

import lesson18.task1.core.PlayerAction
import lesson18.task1.players.*

class DefendAction : PlayerAction {

    override fun execute(player: Player) {
        print("$player ")
        when (player) {
            is Warrior -> {
                println("Raising the shield!")
            }
            is Archer -> {
                println("Running away!")
            }
            is Mage -> {
                println("Creating a protective field!")
            }
            else -> {
                println("Defending!")
            }
        }
    }

    override fun description(): String {
        return "Casual defend."
    }
}