package com.kamran.energon.presentation.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kamran.energon.widgets.DeterminateCircularProgressIndicator

@Composable
fun OngoingItem(
	name: String = "",
) {
	Column {
		Text(
			modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp),
			text = name
		)
		Card(
			Modifier
				.fillMaxWidth()
				.height(100.dp)
				.padding(horizontal = 12.dp),
			elevation = CardDefaults.cardElevation(8.dp),
			colors = CardDefaults.elevatedCardColors()
		) {
			Column {
				Text(
					modifier = Modifier.padding(8.dp),
					text = "Eleport Kontor",
					style = MaterialTheme.typography.titleMedium
				)
				DeterminateCircularProgressIndicator()
			}
		}
	}

}