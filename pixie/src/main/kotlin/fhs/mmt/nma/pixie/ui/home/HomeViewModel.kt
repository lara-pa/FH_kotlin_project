package fhs.mmt.nma.pixie.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fhs.mmt.nma.pixie.samples.AllPosts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val _uiState = MutableStateFlow<HomeScreenState>(HomeScreenState.Loading)
    val uiState: StateFlow<HomeScreenState> = _uiState

    init {
        loadPosts()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            // Simuliere Ladezeit
            kotlinx.coroutines.delay(1000)
            _uiState.value = HomeScreenState.Content(posts = AllPosts, selectedItem = 0)
        }
    }

    fun selectItem(index: Int) {
        val currentState = _uiState.value
        if (currentState is HomeScreenState.Content) {
            _uiState.value = currentState.copy(selectedItem = index)
        }
    }
}
