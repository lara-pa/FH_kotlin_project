package fhs.mmt.nma.pixie.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import fhs.mmt.nma.pixie.data.Photographer
import fhs.mmt.nma.pixie.data.Post

@Composable
fun ProfileContent(
    user: Photographer,
    posts: List<Post>,
    onLocationClick: (String) -> Unit,
    onInstagramClick: (String) -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            ProfileTopBar(
                userName = user.name,
                onBackClick = onBackClick,
                onMoreClick = {}
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                ProfileStatistics(
                    user = user,
                    posts = posts,
                    onLocationClick = onLocationClick,
                    onInstagramClick = onInstagramClick
                )

                Spacer(modifier = Modifier.height(16.dp))

                val allPhotos = posts.flatMap { it.photos }
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    contentPadding = PaddingValues(4.dp)
                ) {
                    items(allPhotos.size) { index ->
                        val photo = allPhotos[index]
                        Image(
                            painter = rememberAsyncImagePainter(model = photo.url),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .requiredSize(128.dp)
                                .clickable {}
                        )
                    }
                }
            }
        }
    )
}
