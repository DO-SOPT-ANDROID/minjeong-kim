package org.sopt.dosopttemplate.presentation.home

import androidx.lifecycle.ViewModel
import org.sopt.dosopttemplate.data.Profile

class HomeViewModel : ViewModel() {

    private val _mockProfileList = listOf<Profile>(
        Profile.MyProfile(
            "https://www.ghibli.jp/gallery/karigurashi033.jpg",
            "김민정",
            "내 깃허브 프로필 사진"
        ),
        Profile.FriendOriginal(
            "https://www.ghibli.jp/gallery/karigurashi007.jpg",
            "아리에띠",
            "기분좋은 아리에띠"
        ),
        Profile.FriendIncludeMusic(
            "https://www.ghibli.jp/gallery/karigurashi046.jpg",
            "아리에띠",
            "남주랑",
            "마지막처럼-블랙핑크"
        ),
        Profile.FriendOriginal(
            "https://www.ghibli.jp/gallery/karigurashi018.jpg",
            "아리에띠",
            "나뭇잎 우산으로 쓴 거 맞음"
        ),
        Profile.FriendOriginal(
            "https://www.ghibli.jp/gallery/karigurashi014.jpg",
            "아리에띠",
            "놀라는 아리에띠"
        )
    )

    val mockProfileList : List<Profile>
        get() = _mockProfileList
    //fun getProfileList() = _mockProfileList
}