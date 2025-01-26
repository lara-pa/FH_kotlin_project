package fhs.mmt.nma.pixie.ui.home

import fhs.mmt.nma.pixie.data.Post

sealed class HomeScreenState {
    data object Loading : HomeScreenState()
    data class Content(val posts: List<Post>, val selectedItem: Int) : HomeScreenState()
}
