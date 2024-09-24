package fhs.mmt.nma.pixie.ui.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import fhs.mmt.nma.pixie.data.User
import fhs.mmt.nma.pixie.samples.providers.UserSampleProvider
import fhs.mmt.nma.pixie.ui.theme.PixieTheme

@Composable
fun ProfileScreen() {
    //TODO: Implement
}


@PreviewLightDark
@Composable
private fun ProfileScreenPreview(@PreviewParameter(UserSampleProvider::class) user: User) {
    PixieTheme {
        ProfileScreen()
    }
}

