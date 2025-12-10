package lesson18.task1.core

import lesson18.task1.players.Player

interface PlayerAction {
    fun execute(player: Player)
    fun description(): String
}