package org.sopt.dosopttemplate.presentation.home.home

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
            "남주와 마지막 인사",
            "마루밑아리에띠"
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
        ),
        Profile.FriendIncludeMusic(
            "https://www.ghibli.jp/gallery/ponyo028.jpg",
            "포뇨",
            "달리는 포뇨",
            "벼랑 위의 포뇨"
        ),
        Profile.FriendOriginal(
            "https://www.ghibli.jp/gallery/ponyo004.jpg",
            "포뇨",
            "귀여워.."
        ),
        Profile.FriendOriginal(
            "https://www.ghibli.jp/gallery/chihiro014.jpg",
            "검댕이",
            "센과 치히로의 행방불명"
        ),
        Profile.FriendOriginal(
            "https://www.ghibli.jp/gallery/majo008.jpg",
            "키키",
            "마녀배달부 키키"
        ),
        Profile.FriendOriginal(
            "https://www.ghibli.jp/gallery/howl012.jpg",
            "캘시퍼",
            "하울의 움직이는 성"
        ),
        Profile.FriendIncludeMusic(
            "https://www.ghibli.jp/gallery/totoro044.jpg",
            "토토로",
            "냥",
            "이웃집 토토로"
        ),
    )

    val mockProfileList : List<Profile>
        get() = _mockProfileList

}