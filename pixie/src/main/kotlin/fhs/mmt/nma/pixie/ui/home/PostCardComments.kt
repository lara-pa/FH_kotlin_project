package fhs.mmt.nma.pixie.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import fhs.mmt.nma.pixie.data.Post

@Composable
fun PostCardComments(post: Post, onUserClick: (String) -> Unit) {
    val commentsToShow = post.comments.take(2)

    Column {
        commentsToShow.forEach { comment ->
            Row(modifier = Modifier.fillMaxWidth()) {
                
                Text(
                    text = comment.author.name,
                    style = MaterialTheme.typography.labelMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.clickable { onUserClick(comment.author.id.toString()) }
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = comment.message,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelSmall,
                )
            }
        }

        if (post.comments.size > 2) {
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Show all ${post.comments.size} Comments",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {}
                    .padding(vertical = 20.dp)
            )
        }
    }
}
