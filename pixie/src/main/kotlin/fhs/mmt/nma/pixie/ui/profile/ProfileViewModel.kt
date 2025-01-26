package fhs.mmt.nma.pixie.ui.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fhs.mmt.nma.pixie.samples.AllPosts
import fhs.mmt.nma.pixie.samples.AllUsers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _uiState = MutableStateFlow<ProfileScreenState>(ProfileScreenState.Loading)
    val uiState: StateFlow<ProfileScreenState> = _uiState

    init {
        val userId: String? = savedStateHandle.get<String>("userId")
        if (userId != null) {
            loadUserProfile(userId)
        } else {
            _uiState.value = ProfileScreenState.Error("User ID is missing!")
        }
    }

    private fun loadUserProfile(userId: String) {
        viewModelScope.launch {
            val user = AllUsers.find { it.id.toString() == userId }
            val posts = AllPosts.filter { it.author.id.toString() == userId }

            if (user != null) {
                _uiState.value = ProfileScreenState.Content(user = user, posts = posts)
            } else {
                _uiState.value = ProfileScreenState.Error("User not found!")
            }
        }
    }
}
