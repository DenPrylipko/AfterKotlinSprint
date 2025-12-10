package lesson18.task1.actions

import lesson18.task1.core.PlayerAction
import lesson18.task1.players.*

class ShootArrowAction : PlayerAction {

    override fun execute(player: Player) {
        when (player) {
            is Archer -> {
                println("$player Shooting arrow!")
            }
            else -> {
                println("Only Archer can use shoot arrow action.")
            }
        }
    }

    override fun description(): String {
        return "Shoot arrow action, only for Archers."
    }
}