package com.kamran.energon.widgets

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchWidget(
	bottomSheetScaffoldState: BottomSheetScaffoldState,
) {
	val animatedPadding by animateDpAsState(
		targetValue = when (bottomSheetScaffoldState.bottomSheetState.targetValue) {
			SheetValue.Hidden -> 0.dp
			SheetValue.Expanded -> 32.dp
			SheetValue.PartiallyExpanded -> 0.dp
		},
		label = "padding animation"
	)
	val pulsate = rememberInfiniteTransition(label = "pulsate")
	val transition = pulsate.animateFloat(
		initialValue = 4f,
		targetValue = 16f,
		animationSpec = infiniteRepeatable(
			animation = tween(durationMillis = 1500, easing = EaseInOut),
			repeatMode = RepeatMode.Reverse
		), label = "elevation"
	)
	val shadowHeight = if (bottomSheetScaffoldState.bottomSheetState.targetValue != SheetValue.Expanded) transition.value.dp else 4.dp
	val shadowColor = if (bottomSheetScaffoldState.bottomSheetState.targetValue != SheetValue.Expanded) Color.Blue else Color.Gray
	Column() {
		Spacer(modifier = Modifier.height(animatedPadding))
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 12.dp, vertical = 12.dp)
				.height(40.dp)
				.shadow(
					shadowHeight,
					RoundedCornerShape(50),
					spotColor = shadowColor
				)
				.background(color = MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(50.dp))
				.clip(CircleShape)
				.clickable(
					onClick = {
//					scope.launch {
//						sheetState.bottomSheetState.expand()
//					}
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
						.padding(12.dp),
					textAlign = TextAlign.Center,
					lineHeight = 16.sp
				)
				CircularInitialsIcon(
					modifier = Modifier.padding(end = 4.dp),
					initials = "KG",
					size = 30.dp
				)
			}
		}
	}

}