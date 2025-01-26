package fhs.mmt.nma.pixie.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import fhs.mmt.nma.pixie.data.Post

@Composable
fun PostCardImages(post: Post, pagerState: PagerState) {
    if (post.photos.size > 1) {
        Box(modifier = Modifier.fillMaxWidth()) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxWidth()
            ) { page ->
                val photo = post.photos[page]
                Image(
                    painter = rememberAsyncImagePainter(model = photo.url),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                )
            }

            // Bild-Indikator
            Text(
                text = "${pagerState.currentPage + 1}/${pagerState.pageCount}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 14.dp)
                    .align(Alignment.TopEnd)
                    .background(color = MaterialTheme.colorScheme.secondaryContainer, shape = CircleShape)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    } else if (post.photos.isNotEmpty()) {
        val photo = post.photos.first()
        Image(
            painter = rememberAsyncImagePainter(model = photo.url),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
    }
}
