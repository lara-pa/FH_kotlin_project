package fhs.mmt.nma.pixie.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fhs.mmt.nma.pixie.samples.AllPosts

@Composable
fun HomeScreen(
    onUserClick: (String) -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is HomeScreenState.Loading -> {
            androidx.compose.material3.CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }

        is HomeScreenState.Content -> {
            val contentState = uiState as HomeScreenState.Content

            Scaffold(
                topBar = {
                    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
                    TopBar(scrollBehavior = scrollBehavior)
                },
                bottomBar = {
                    BottomNavigationBar(
                        selectedItem = contentState.selectedItem,
                        onItemSelected = { viewModel.selectItem(0) }
                    )
                },
                content = { innerPadding ->
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        items(contentState.posts) { post ->
                            PostCard(post = post, onUserClick = onUserClick)
                        }
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenLoadingPreview() {
    HomeScreen(
        onUserClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenContentPreview() {
    HomeScreen(
        onUserClick = {},
        viewModel = HomeViewModel().apply {
            // Simuliere Content-Zustand
            _uiState.value = HomeScreenState.Content(posts = AllPosts, selectedItem = 0)
        }
    )
}
