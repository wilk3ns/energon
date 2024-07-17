package com.kamran.energon.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.kamran.energon.widgets.CircularInitialsIcon
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainView(viewModel: MainViewModel = hiltViewModel()) {
	val sheetState = rememberBottomSheetScaffoldState()
	val scope = rememberCoroutineScope()
	Scaffold(
		modifier = Modifier.fillMaxSize(),
	) { innerPadding ->

		BottomSheetScaffold(
			//modifier = Modifier.padding(innerPadding),
			sheetSwipeEnabled = true,
			scaffoldState = sheetState,
			sheetPeekHeight = 120.dp,
			sheetDragHandle = null,
			sheetContent = {
				Column {
					Box(
						modifier = Modifier
							.fillMaxWidth()
							.padding(innerPadding)
							.padding(horizontal = 12.dp)
							.background(color = Color.White, shape = RoundedCornerShape(80.dp))
							.clip(CircleShape)
							.clickable(
								onClick = {
									scope.launch {
										sheetState.bottomSheetState.expand()
									}
								}
							)
					) {
						Row(
							Modifier.fillMaxWidth(),
							horizontalArrangement = Arrangement.SpaceBetween,
							verticalAlignment = Alignment.CenterVertically,
						) {
							Text(
								text = "Search",
								modifier = Modifier
									.padding(16.dp),
								textAlign = TextAlign.Center,
							)
							CircularInitialsIcon(
								modifier = Modifier.padding(end = 4.dp),
								initials = "KG",
								size = 48.dp)
						}
					}
					Box(modifier = Modifier.height(600.dp))
				}

			}
		) {
			Box(modifier = Modifier.fillMaxSize()) {
				GoogleMap(
					modifier = Modifier.fillMaxSize(),
					// .padding(innerPadding),
					uiSettings = MapUiSettings(
						compassEnabled = true,
						rotationGesturesEnabled = true,
						mapToolbarEnabled = true,
						myLocationButtonEnabled = true
					)
				)
				Box(
					modifier = Modifier
						.fillMaxWidth()
						.padding(innerPadding)
						.padding(horizontal = 12.dp)
						.background(color = Color.White, shape = RoundedCornerShape(80.dp))
						.clip(CircleShape)
				) {

				}
			}
		}
	}
}