package org.sopt.dosopttemplate.data.entity


sealed class Profile {

    abstract val id: Int

    data class MyProfile(
        override val id: Int,
        val profile_img: String,
        val name: String,
        val profile_message: String
    ) : Profile()

    data class FriendBirthday(
        override val id: Int,
        val profile_img: String,
        val name: String,
        val profile_message: String,
        val birthday: String
    ) : Profile()

    data class FriendIncludeMusic(
        override val id: Int,
        val profile_img: String,
        val name: String,
        val profile_message: String,
        val music: String,
    ) : Profile()

}
