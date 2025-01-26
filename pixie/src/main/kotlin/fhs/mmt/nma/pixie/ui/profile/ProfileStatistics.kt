package fhs.mmt.nma.pixie.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import coil.compose.rememberAsyncImagePainter
import fhs.mmt.nma.pixie.data.Photographer
import fhs.mmt.nma.pixie.data.Post
import fhs.mmt.nma.pixie.ui.formatNumber
import fhs.mmt.nma.pixie.ui.icons.Instagram
import fhs.mmt.nma.pixie.ui.icons.PixieIcons


@Composable
fun ProfileStatistics(
    user: Photographer,
    posts: List<Post>,
    onLocationClick: (String) -> Unit,
    onInstagramClick: (String) -> Unit
) {

    val totalLikes = posts.sumOf { it.likes }
    val totalComments = posts.sumOf { it.comments.size }
    val totalPhotos = posts.sumOf { it.photos.size }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Profilbild
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .clip(CircleShape)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = user.picture),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(76.dp)
                        .aspectRatio(1f)
                        .clip(CircleShape)
                )
            }

            // Alle Stats
            ProfileStat(title = "Likes", value = formatNumber(totalLikes))
            ProfileStat(title = "Photos", value = formatNumber(totalPhotos))
            ProfileStat(title = "Comments", value = formatNumber(totalComments))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Bio
        Row {
            Text(
                text = user.bio,
                style = MaterialTheme.typography.bodyMedium,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        // Links
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            user.location?.let { location ->
                Row(
                    modifier = Modifier.clickable { onLocationClick("https://www.google.com/maps/search/?api=1&query=$location") },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Location",
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(
                        text = location,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            user.instagram?.let { instagram ->
                Row(
                    modifier = Modifier.clickable { onInstagramClick("https://www.instagram.com/$instagram/") },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = PixieIcons.Instagram,
                        contentDescription = "Instagram",
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(
                        text = "@$instagram",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileStat(title: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, style = MaterialTheme.typography.titleLarge)
        Text(text = title, style = MaterialTheme.typography.bodyMedium)
    }
}


