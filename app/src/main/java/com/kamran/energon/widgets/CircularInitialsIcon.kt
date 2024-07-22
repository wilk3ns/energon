package com.kamran.energon.widgets

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times

@Composable
fun CircularInitialsIcon(
	initials: String,
	size: Dp,
	modifier: Modifier = Modifier,
	backgroundColor: Color = MaterialTheme.colorScheme.secondary,
	textColor: Color = MaterialTheme.colorScheme.surfaceDim
) {
	Box(
		modifier = modifier.size(size),
		contentAlignment = Alignment.Center
	) {
		Canvas(modifier = Modifier.size(size)) {
			drawCircle(color = backgroundColor)
		}
		Text(
			text = initials.take(2).uppercase(),
			color = textColor,
			fontSize = size.value * 0.4f.sp,
			fontWeight = FontWeight.Bold
		)
	}
}