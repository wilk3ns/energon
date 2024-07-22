package com.kamran.energon.presentation.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamran.energon.R

@Composable
fun FavoritesItem(
	name: String = "",
){
	Column {
		Text(
			modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp),
			text = name
		)
		LazyRow(
			contentPadding = PaddingValues(horizontal = 12.dp),
			horizontalArrangement = Arrangement.spacedBy(12.dp)
		) {
			items(5) {
				Card(
					Modifier.size(130.dp),
					colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
					elevation = CardDefaults.elevatedCardElevation(8.dp),
				) {
					Column {
						Row(
							Modifier
								.padding(8.dp)
								.fillMaxWidth(),
							horizontalArrangement = Arrangement.SpaceBetween,
						) {
							Column {
								Text(
									text = "Test Site 1",
									style = MaterialTheme.typography.titleMedium
								)
								Text(
									text = "Street name, 5",
									style = MaterialTheme.typography.bodySmall
								)
							}
							Icon(
								Icons.Default.Favorite,
								contentDescription = "",
								tint = MaterialTheme.colorScheme.error
							)
						}
						Row(
							Modifier.padding(8.dp),
							horizontalArrangement = Arrangement.spacedBy(4.dp),
							verticalAlignment = Alignment.CenterVertically
						) {
							Card(
								Modifier.size(20.dp),
								shape = RoundedCornerShape(4.dp),
								colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.inversePrimary)
							) {
								Box(
									Modifier.fillMaxSize(),
									contentAlignment = Alignment.Center
								) {
									Icon(
										painterResource(
											id = R.drawable.round_near_me_24,
										), contentDescription = "",
										tint = MaterialTheme.colorScheme.onTertiary
									)
								}

							}
							Column {
								Text(
									text = "123m",
									fontSize = 12.sp,
									lineHeight = 12.sp
								)
								Text(
									text = "away",
									fontSize = 8.sp,
									lineHeight = 8.sp
								)
							}
						}
					}
				}
			}
		}
	}

}