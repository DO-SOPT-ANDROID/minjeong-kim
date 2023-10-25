package org.sopt.dosopttemplate.data


sealed class Profile {

    data class MyProfile(
        val profile_img: String,
        val name: String,
        val profile_message: String
    ) : Profile()

    data class FriendOriginal(
        val profile_img: String,
        val name: String,
        val profile_message: String
    ) : Profile()

    data class FriendIncludeMusic(
        val profile_img: String,
        val name: String,
        val profile_message: String,
        val music: String,
    ) : Profile()

}
