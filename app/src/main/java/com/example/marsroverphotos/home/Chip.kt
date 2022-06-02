package com.example.marsroverphotos.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.data.models.CameraType
import com.example.marsroverphotos.ui.theme.MarsRoverPhotosTheme
import com.example.marsroverphotos.ui.theme.RedMars500

@Composable
fun FilterChip(
    title: String,
    modifier: Modifier,
    onClick: (String) -> Unit,
    isSelected: Boolean
) {
    val shape = CircleShape
    Surface(
        shape = shape,
        color = if (isSelected) RedMars500 else Color.White,
        border = BorderStroke(2.dp, RedMars500),
        elevation = 8.dp,
        modifier = modifier.clickable {onClick(title.lowercase())},
    ) {
        Text(
            text = title,
            style = TextStyle(
                color = if (isSelected) Color.White else RedMars500,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}



@Composable
fun FilterChipRow(
    items: Array<CameraType>,
    modifier: Modifier,
    chipModifier: Modifier,
    onClickChip: (String) -> Unit,
    selectedChip: String
) {
    LazyRow(
        modifier = modifier
    ){
        items(items){ item ->
            FilterChip(
                title = item.toString(),
                modifier = chipModifier,
                onClick = onClickChip,
                isSelected = item.toString() == selectedChip
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterChipRowPreview() {
    MarsRoverPhotosTheme {
        FilterChipRow(
            items = CameraType.values(),
            modifier = Modifier.padding(8.dp),
            chipModifier = Modifier.padding(end = 8.dp),
            selectedChip = "FHAZ",
            onClickChip = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FilterChipPreview() {
    MarsRoverPhotosTheme {
        FilterChip(
            title = "FHAZ",
            modifier = Modifier.padding(4.dp),
            onClick = {},
            isSelected = true
        )
    }
}


