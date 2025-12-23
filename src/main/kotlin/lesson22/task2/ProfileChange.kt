package lesson22.task2

data class ProfileChange(
    val oldProfile: UserProfile,
    val newProfile: UserProfile,
    val description: String,
)