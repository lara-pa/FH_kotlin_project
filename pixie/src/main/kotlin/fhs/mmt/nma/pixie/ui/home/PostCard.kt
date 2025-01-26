package fhs.mmt.nma.pixie.ui.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fhs.mmt.nma.pixie.data.Post

@Composable
fun PostCard(post: Post, onUserClick: (String) -> Unit) {
    val pagerState = rememberPagerState(pageCount = { post.photos.size })

    androidx.compose.material3.Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = androidx.compose.material3.CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        androidx.compose.foundation.layout.Column(modifier = Modifier.padding(16.dp)) {
            PostCardTop(post = post, onUserClick = onUserClick)
            androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(8.dp))
            PostCardImages(post = post, pagerState = pagerState)
            androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(8.dp))
            PostCardActions(post = post, pagerState = pagerState)
            androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(8.dp))
            PostCardComments(post = post, onUserClick = onUserClick)
        }
    }
}

