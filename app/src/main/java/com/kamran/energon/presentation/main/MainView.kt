package com.kamran.energon.presentation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.kamran.energon.presentation.main.components.FavoritesItem
import com.kamran.energon.presentation.main.components.OngoingItem
import com.kamran.energon.presentation.main.components.SitesItem
import com.kamran.energon.presentation.main.components.TransactionsItem
import com.kamran.energon.ui.MainViewModel
import com.kamran.energon.ui.theme.EnergonTheme
import com.kamran.energon.widgets.SearchWidget

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainView(viewModel: MainViewModel = hiltViewModel()) {
	val scrollState = rememberScrollState()
	val bottomSheetState = rememberBottomSheetScaffoldState()
	val scope = rememberCoroutineScope()
	EnergonTheme {
		Scaffold(
		modifier = Modifier.fillMaxSize(),
		) { innerPadding ->
			BottomSheetScaffold(
			sheetSwipeEnabled = true,
			scaffoldState = bottomSheetState,
			sheetDragHandle = null,
			sheetPeekHeight = 100.dp,
			sheetContent = {
				Box {
					Column {
						Column(modifier = Modifier
							.fillMaxSize()
							.verticalScroll(scrollState),
							verticalArrangement = Arrangement.spacedBy(12.dp)
						) {
							Spacer(Modifier.height(93.dp))
							OngoingItem(name = "Ongoing")
							FavoritesItem("Favorites")
							SitesItem("Sites")
							TransactionsItem("Transactions")
							Spacer(modifier = Modifier.height(32.dp))
						}
					}
					SearchWidget(bottomSheetState)
				}

			}
		) {
			Box(modifier = Modifier.fillMaxSize()) {
				GoogleMap(
					modifier = Modifier.fillMaxSize(),
					contentPadding = PaddingValues(vertical = 128.dp),
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


}