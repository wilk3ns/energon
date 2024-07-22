package com.kamran.energon.presentation.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SitesItem(
	name: String = "",
) {
	Column {
		Text(
			modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp),
			text = name
		)
		Card(
			elevation = CardDefaults.elevatedCardElevation(4.dp),
			modifier = Modifier
				.padding(horizontal = 12.dp)
				.fillMaxWidth()
				.wrapContentHeight()
		) {
			Column {
				repeat(3) {
					ListItem(
						shadowElevation = 4.dp,
						leadingContent = {
							Icon(
								Icons.Default.LocationOn,
								contentDescription = "",
								tint = MaterialTheme.colorScheme.inversePrimary
							)
						},
						headlineContent = { Text(text = "Test Site") },
						supportingContent = { Text(text = "Street name, 5") }
					)
				}
			}
		}
	}

}