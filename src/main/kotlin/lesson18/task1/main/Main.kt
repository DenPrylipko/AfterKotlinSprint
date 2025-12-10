package lesson18.task1.main

import lesson11.task1.listOfAllAccounts
import lesson18.task1.actions.AttackAction
import lesson18.task1.actions.CastSpellAction
import lesson18.task1.actions.DefendAction
import lesson18.task1.actions.HealAction
import lesson18.task1.actions.ShootArrowAction
import lesson18.task1.core.*
import lesson18.task1.players.*

fun main() {

    val warrior = Warrior("Den")

    val actions = listOf(
        AttackAction(),
        DefendAction(),
        HealAction(),
        CastSpellAction(),
        ShootArrowAction()
    )

    val processor = ActionProcessor<PlayerAction>()

    processor.process(AttackAction(), warrior)

    processor.processAll(actions, warrior)

    val onlyAttacks = filterActions(actions) { it is AttackAction}

    println("Filtered attacks: ${onlyAttacks.size}")


    performAction(warrior, HealAction())

    performAction(AttackAction(), HealAction(), DefendAction())

}

fun performAction(action: PlayerAction) {
    println("Activating ${action.description()} action.")
}

fun performAction(actions: List<PlayerAction>) {
    println("Activating ${actions.size} actions.")
    actions.forEach { println(it.description()) }
}

fun performAction(player: Player, action: PlayerAction) {
    println("Activating ${action.description()} for player $player.")
}

fun performAction(vararg actions: PlayerAction) {
    println("Activating ${actions.size} actions.")
    actions.forEach { println(it.description()) }
}

class ActionProcessor<T : PlayerAction> {
    fun process(action: T, player: Player) {
        println("Processing ${action.description()}")
        action.execute(player)
    }

    fun processAll(actions: List<T>, player: Player) {
        println("Processing ${actions.size} actions.")
        actions.forEach { process(it, player) }
    }
}

fun <T : PlayerAction> filterActions(
    actions: List<T>,
    predicate: (T) -> Boolean
): List<T> {
    return actions.filter(predicate)
}