package com.raywenderlich.android.lab1.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raywenderlich.android.lab1.R
import com.raywenderlich.android.lab1.router.BackButtonHandler
import com.raywenderlich.android.lab1.router.FundamentalsRouter
import com.raywenderlich.android.lab1.router.Screen

private val items = listOf(
    BookCategory(
        R.string.game_in_3_pics,
        listOf(
            R.drawable.eft_background,
            R.drawable.eft_loading_screen,
            R.drawable.gachi
        )
    ),
    BookCategory(
        R.string.meta,
        listOf(
            R.drawable.meta_m4a1,
            R.drawable.meta_mutant
        )
    ),
    BookCategory(
        R.string.sbey,
        listOf(
            R.drawable.sbey_mosina,
            R.drawable.sbey_mp5,
            R.drawable.sbey_p90
        )
    ),
    BookCategory(
        R.string.eft_memes,
        listOf(
            R.drawable.card_meme,
            R.drawable.gachi_mem
        )
    )
)

@Composable
fun ListScreen(){
    MyList()

    BackButtonHandler {
        FundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun MyList() {
    LazyColumn{
        items(items) {item -> ListItem(item) }
    }
}

@Composable
fun ListItem(bookCategory: BookCategory, modifier: Modifier = Modifier){
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = stringResource(bookCategory.categoryResourceId),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.colorPrimary)
        )
        Spacer(modifier = modifier.height(8.dp))
        
        LazyRow{
            items(bookCategory.bookImageResources){
                items -> BookImage(items)
            }
        }
    }
}

@Composable
fun BookImage(imageResource: Int) {
    Image(
        modifier = Modifier.size(170.dp, 200.dp),
        painter = painterResource(id = imageResource),
        contentScale = ContentScale.Fit,
        contentDescription = stringResource(id = R.string.book_covers))
}

data class BookCategory(
    @StringRes
    val categoryResourceId: Int,
    val bookImageResources: List<Int>
)