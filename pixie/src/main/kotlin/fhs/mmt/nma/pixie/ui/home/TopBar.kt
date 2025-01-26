package fhs.mmt.nma.pixie.ui.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.Interests
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun TopBar(scrollBehavior: TopAppBarScrollBehavior) {
    TopAppBar(
        title = {
            Text(
                "Pixie App",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Interests,
                    contentDescription = "Favorite"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.ChatBubbleOutline,
                    contentDescription = "ChatBubble"
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}
