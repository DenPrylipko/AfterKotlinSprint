package lesson16.task2

fun main() {

    val killQuest = KillQuest("Kill 20 monsters.", 100, 20)
    val collectQuest = CollectQuest("Collect 3 artefacts", 5, 3)
    val exploreQuest = ExploreQuest(
        "Explore 2 locations",
        70,
        listOf("Dark forest", "Meadow with flowers")
    )
    killQuest.start()
    collectQuest.start()
    exploreQuest.start()

    killQuest.info()
    collectQuest.info()
    exploreQuest.info()

    killQuest.killMonster()
    collectQuest.collectItem()
    exploreQuest.visit("Dark forest")

    killQuest.info()
    collectQuest.info()
    exploreQuest.info()

}