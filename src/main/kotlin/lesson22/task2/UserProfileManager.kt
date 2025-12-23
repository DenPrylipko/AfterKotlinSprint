package lesson22.task2

class UserProfileManager(
    private val currentProfilesList: MutableList<UserProfile>,
    private val profileChangesList: MutableList<ProfileChange>,
) {
    fun addProfile(newProfile: UserProfile) {
        for (profile in currentProfilesList) {
            if (profile.id == newProfile.id) {
                println("Profile with this id already exist.")
                return
            }
        }
        currentProfilesList.add(newProfile)
        println("New profile was successfully added.")
    }

    fun findProfile(id: Int): UserProfile? = currentProfilesList.find { it.id == id }

    fun updateProfile(updatedProfile: UserProfile) {
        val oldProfile = currentProfilesList.find { it.id == updatedProfile.id }

        if (oldProfile == null) {
            println("Profile with id: ${updatedProfile.id} doesn't exist. Try \"addProfile()\"")
            return
        }
        if (oldProfile == updatedProfile) {
            println("There is no changes.")
            return
        }

        val description = buildChangeDescription(oldProfile, updatedProfile)
        val index = currentProfilesList.indexOfFirst { it.id == oldProfile.id }
        currentProfilesList[index] = updatedProfile


        profileChangesList.add(ProfileChange(oldProfile, updatedProfile, description ?: "No changes"))
    }

    fun getChangeHistory(id: Int): List<ProfileChange> = profileChangesList.filter { it.oldProfile.id == id }
}

fun buildChangeDescription(oldProfile: UserProfile, updatedProfile: UserProfile): String? {
    val changes = mutableListOf<String>()

    if (oldProfile.username != updatedProfile.username) {
        changes.add("Username changed")
    }
    if (oldProfile.email != updatedProfile.email) {
        changes.add("Email changed")
    }
    if (oldProfile.age != updatedProfile.age) {
        changes.add("Age changed")
    }
    if (oldProfile.isVerified != updatedProfile.isVerified) {
        changes.add("Verification status changed")
    }

    return changes.takeIf { it.isNotEmpty() }?.joinToString(", ")
}