package com.uxstate.matcomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uxstate.matcomponents.ui.theme.MatComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MatComponentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PhotographerCard()
                }
            }
        }
    }
}


@Composable
fun PhotographerCard() {

    Row(modifier = Modifier
        .padding(1.dp)
        .clip(RectangleShape)
        .background
            (MaterialTheme.colors.surface)
        .clickable { }
        .padding(16.dp)) {

        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme
                .colors.onSecondary.copy(alpha = 0.2F)
        ) {}


        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {


            Text(text = "Alfred Sisley", fontWeight = FontWeight.Bold)

            //LocalContentAlpha is defining opacity level of its children
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {


                Text(text = "3 Minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MatComponentsTheme {

        Column {


            LayoutsCodelab()
        }
    }


}


@Composable
fun LayoutsCodelab() {

    Scaffold(topBar = {

        Text("GOAT", style = MaterialTheme.typography.h3)

    }) {

        //wrapping content in Scaffold
            padding ->
        BodyContent(modifier = Modifier.padding(padding))
    }
}

//content Composable
@Composable
fun BodyContent(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        Text(text = "Hi there!")
    }
}





