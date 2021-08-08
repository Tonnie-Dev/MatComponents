package com.uxstate.matcomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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

    Column {


        Text(text = "Alfred Sisley", fontWeight = FontWeight.Bold)

        //LocalContentAlpha is defining opacity level of its children
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {


            Text(text = "3 Minutes ago", style = MaterialTheme.typography.body2)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MatComponentsTheme {
        PhotographerCard()
    }
}