package lesson22.task2

fun main() {
    val userProfileManager = UserProfileManager(mutableListOf<UserProfile>(), mutableListOf<ProfileChange>())

    val profile1 = UserProfile(0, "Den", "denprylipko09@gmail.com", 19, false)

    userProfileManager.addProfile(profile1)
    userProfileManager.updateProfile(profile1.copy(email = "dengamer@gmail.com", isVerified = true))
    userProfileManager.updateProfile(userProfileManager.findProfile(0)!!.copy(age = 20))

    println(userProfileManager.getChangeHistory(0)?.joinToString("\n"))
}