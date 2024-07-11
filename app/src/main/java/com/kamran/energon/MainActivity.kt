package com.kamran.energon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.kamran.energon.ui.theme.EnergonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			EnergonTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					GoogleMap(
						modifier = Modifier.fillMaxSize()
							.padding(innerPadding),
						uiSettings = MapUiSettings(
							compassEnabled = true,
							rotationGesturesEnabled = true,
							mapToolbarEnabled = true,
							myLocationButtonEnabled = true,
							zoomControlsEnabled = true
						)

					)
				}
			}
		}
	}
}