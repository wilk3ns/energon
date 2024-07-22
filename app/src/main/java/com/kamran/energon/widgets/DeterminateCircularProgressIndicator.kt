package com.kamran.energon.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun DeterminateCircularProgressIndicator() {
	val progress by remember { mutableFloatStateOf(.8f) }

	Row(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp),
	) {
		LinearProgressIndicator(
			progress = { progress },
			modifier = Modifier.width(200.dp),
			color = ProgressIndicatorDefaults.linearColor,
			//strokeWidth = ProgressIndicatorDefaults.CircularStrokeWidth,
			trackColor = ProgressIndicatorDefaults.linearTrackColor,
			strokeCap = StrokeCap.Round,
			//gapSize = 16.dp
		)

		Text(
			text = "${(progress * 100).toInt()}%",
			style = MaterialTheme.typography.headlineMedium
		)

	}
}