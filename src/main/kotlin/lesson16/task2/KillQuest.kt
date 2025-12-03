package lesson16.task2

class KillQuest(
    title: String,
    reward: Int,
    private val monstersRequired: Int,
    private var monsterKilled: Int = 0,
) : Quest(title, reward) {

    fun killMonster() {
        if (isCompleted) return
        monsterKilled++
        log("Monster killed. Progress: $monsterKilled/$monstersRequired.")
        if (monsterKilled == monstersRequired) complete()
    }

    override fun info() {
        super.info()
        println("Progress: $monsterKilled/$monstersRequired.")
    }
}