package fhs.mmt.nma.pixie.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable

@SuppressLint("DefaultLocale")
@Composable
fun formatNumber(number: Int): String {
    return when {
        number >= 1_000_000 -> String.format("%.1fM", number / 1_000_000.0)
        number >= 1_000 -> String.format("%.1fk", number / 1_000.0)
        else -> number.toString()
    }
}