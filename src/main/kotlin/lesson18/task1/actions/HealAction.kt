package lesson18.task1.actions

import lesson18.task1.core.PlayerAction
import lesson18.task1.players.*

class HealAction : PlayerAction {

    override fun execute(player: Player) {
        print("$player ")
        when (player) {
            is Warrior, is Archer -> {
                println("Wraps the wound with a bandage!")
            }
            is Mage -> {
                println("Uses medicinal herbs!")
            }
            else -> {
                println("Healing!")
            }
        }
    }

    override fun description(): String {
        return "Casual heal."
    }
}