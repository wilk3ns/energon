package com.kamran.energon.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainView(viewModel: MainViewModel = hiltViewModel()) {
	var showBottomSheet by remember { mutableStateOf(false) }
	val sheetState = rememberModalBottomSheetState()
	val scope = rememberCoroutineScope()
	Scaffold(modifier = Modifier.fillMaxSize(),
		floatingActionButton = {
			ExtendedFloatingActionButton(
				text = { Text("Show bottom sheet") },
				icon = { Icon(Icons.Filled.Add, contentDescription = "") },
				onClick = {
					showBottomSheet = true
				}
			)
		}) { innerPadding ->

		if (showBottomSheet) {
			ModalBottomSheet(
				onDismissRequest = {
					showBottomSheet = false
				},
				sheetState = sheetState
			) {
					Box(
						modifier = Modifier
							.fillMaxWidth()
							.padding(innerPadding)
							.padding(horizontal = 12.dp)
							.background(color = Color.White, shape = RoundedCornerShape(80.dp))
							.clip(CircleShape)
					) {
						Text(
							text = "Filled",
							modifier = Modifier
								.padding(16.dp),
							textAlign = TextAlign.Center,
						)
					}

			}
		}

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
				Text(
					text = "Filled",
					modifier = Modifier
						.padding(16.dp),
					textAlign = TextAlign.Center,
				)
			}
		}
	}
}