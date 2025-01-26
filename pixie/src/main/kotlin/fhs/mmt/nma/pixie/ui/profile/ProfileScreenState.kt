package fhs.mmt.nma.pixie.ui.profile

import fhs.mmt.nma.pixie.data.Photographer
import fhs.mmt.nma.pixie.data.Post

sealed class ProfileScreenState {
    data object Loading : ProfileScreenState()
    data class Content(val user: Photographer, val posts: List<Post>) : ProfileScreenState()
    data class Error(val message: String) : ProfileScreenState()
}
