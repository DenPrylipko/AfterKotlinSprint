package lesson18.task1.actions

import lesson18.task1.core.PlayerAction
import lesson18.task1.players.*

class AttackAction : PlayerAction {

    override fun execute(player: Player) {
        print("$player ")
        when (player) {
            is Warrior -> {
                println("Attacking!")
            }
            is Archer -> {
                println("Loading the bow!")
            }
            is Mage -> {
                println("Casting a spell!")
            }
            else -> {
                println("Attacking!")
            }
        }
    }

    override fun description(): String {
        return "Casual attack."
    }
}