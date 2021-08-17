package com.uxstate.matcomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.uxstate.matcomponents.ui.theme.MatComponentsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MatComponentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ImagesList()

                }
            }
        }
    }


}

@Composable
fun ImagesList() {
    val state = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column() {


    Row(horizontalArrangement =Arrangement.spacedBy(12.dp)){


        Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)) {
            Text(text = "Scroll to the Top")
        }

        Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)) {
            Text(text = "Scroll to End")
        }
    }



    LazyColumn(state = state) {


        items(100) {

            AndroidLogo(it)
        }


    }

    }
}

@Composable
fun AndroidLogo(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        //download image using coil
        val painter =
            rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            )
        //pass the image to Painter
        Image(
            painter = painter,
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = "Item #$index",
            style = MaterialTheme.typography.subtitle1
        )
    }
}



