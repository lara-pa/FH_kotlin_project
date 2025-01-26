package fhs.mmt.nma.pixie.ui.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fhs.mmt.nma.pixie.samples.IvanCujic
import fhs.mmt.nma.pixie.samples.IvanPosts
import fhs.mmt.nma.pixie.ui.profile.ProfileScreenState.*

@Composable
fun ProfileScreen(
    userId: String,
    onLocationClick: (String) -> Unit,
    onInstagramClick: (String) -> Unit,
    onBackClick: () -> Unit,
    viewModel: ProfileViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is Content -> {
            val content = uiState as Content
            ProfileContent(
                user = content.user,
                posts = content.posts,
                onLocationClick = onLocationClick,
                onInstagramClick = onInstagramClick,
                onBackClick = onBackClick
            )
        }

        is Error -> {
            val error = uiState as Error
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = error.message,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Preview
@Composable
fun LoadingPreview() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
fun ContentPreview() {
    ProfileContent(
        user = IvanCujic,
        posts = IvanPosts,
        onLocationClick = {},
        onInstagramClick = {},
        onBackClick = {}
    )
}

@Preview
@Composable
fun ErrorPreview() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Error loading profile!",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.error
        )
    }
}
