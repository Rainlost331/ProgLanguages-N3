package com.raywenderlich.android.lab1.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.raywenderlich.android.lab1.R
import com.raywenderlich.android.lab1.router.BackButtonHandler
import com.raywenderlich.android.lab1.router.FundamentalsRouter
import com.raywenderlich.android.lab1.router.Screen

private val items = listOf(
    Icons.Filled.Check,
    Icons.Filled.Close,
    Icons.Filled.ThumbUp,
    Icons.Filled.Build,
    Icons.Filled.Delete,
    Icons.Filled.Home,
    Icons.Filled.Close,
    Icons.Filled.ThumbUp,
    Icons.Filled.Build,
    Icons.Filled.ThumbUp,
)

@ExperimentalFoundationApi
@Composable
fun GridScreen(){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(3),
        content = {
            items(count = items.size){item ->
                GridIcon(IconResource(items[item], true))
            }
        }
    )

    BackButtonHandler {
        FundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun GridIcon(iconResource: IconResource){
    val color = if (iconResource.isVisible)
        colorResource(R.color.blue)
    else Color.Transparent

    Icon(
        imageVector = iconResource.imageVector,
        tint = color,
        contentDescription = stringResource(id = R.string.book_covers), //TODO поменять здесь переменнуб string
        modifier = Modifier
            .size(80.dp, 80.dp)
    )
}

@Composable
fun RowItem(rowItems: List<IconResource>){
    Row {
        for (element in rowItems)
            GridIcon(element)
    }
}

data class IconResource(val imageVector: ImageVector, val isVisible: Boolean)