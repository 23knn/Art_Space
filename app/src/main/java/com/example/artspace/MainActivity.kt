package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceApp()
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier){
    val Images = listOf(R.drawable.baobab, R.drawable.cheetah, R.drawable.elephant, R.drawable.hills, R.drawable.grassland, R.drawable.kilimanjaro_girraffe, R.drawable.zebra)
    var currentImage by remember {
        mutableStateOf(0)
    }

    Column {
        ArtWork()
        Description()
        NavigationButton()
    }
}

@Composable
fun ArtWork(modifier: Modifier = Modifier){

}

@Composable
fun Description(modifier: Modifier = Modifier){

}

@Composable
fun NavigationButton(modifier: Modifier = Modifier){

}