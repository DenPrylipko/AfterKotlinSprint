package lesson18.task1.actions

import lesson18.task1.core.PlayerAction
import lesson18.task1.players.*

class CastSpellAction : PlayerAction {

    override fun execute(player: Player) {
        when (player) {
            is Mage -> {
                println("$player Casting a spell!")
            }
            else -> {
                println("Only Mage can use cast spell action.")
            }
        }
    }

    override fun description(): String {
        return "Cast spell action, only for Mages"
    }
}