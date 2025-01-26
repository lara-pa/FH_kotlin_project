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
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.clickable { onUserClick(comment.author.id.toString()) }
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = comment.message,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        if (post.comments.size > 2) {
            Text(
                text = "Show all ${post.comments.size} Comments",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {}
            )
        }
    }
}
