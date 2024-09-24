package fhs.mmt.nma.pixie.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import fhs.mmt.nma.pixie.R


private val NunitoFontFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.nunito_sans_light,
            weight = FontWeight.Light,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.nunito_sans_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.nunito_sans_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.nunito_sans_semi_bold,
            weight = FontWeight.SemiBold,
            style = FontStyle.Normal
        ),
    )
)
