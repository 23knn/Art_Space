package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceApp(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier){
    val artWorks: List<Int> = listOf(R.drawable.baobab, R.drawable.cheetah, R.drawable.elephant, R.drawable.hills, R.drawable.grassland, R.drawable.kilimanjaro_girraffe, R.drawable.zebra)
    val descriptions: List<Int> = listOf(R.string.baobab, R.string.cheetah, R.string.elephant, R.string.hills, R.string.grassland, R.string.kilimanjaro, R.string.zebra)
    var currentImage by remember {
        mutableStateOf(0)
    }

    Column(modifier = modifier.padding(50.dp)){
        ArtWork(artWorks, currentImage, modifier = modifier)
        Spacer(Modifier.height(30.dp))
        Description(descriptions, currentImage, modifier = modifier)
        Spacer(Modifier.height(30.dp))
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            NavigationButton("Previous", action = { currentImage = (currentImage - 1)%artWorks.size})
            NavigationButton(buttonName = "Next", action = { currentImage = (currentImage + 1)%artWorks.size})
        }

    }
}

@Composable
fun ArtWork(artWorks: List<Int>, currentImage: Int, modifier: Modifier = Modifier){
    Surface(
        elevation = 20.dp,
        modifier = modifier,
        border = BorderStroke(2.dp, Color.Gray)
    ) {
        Column(
            modifier = modifier.padding(20.dp).height(200.dp)
        ){
            Image(painter = painterResource(id = artWorks[currentImage]), contentDescription = "art", modifier.fillMaxSize())
        }
    }
}

@Composable
fun Description(descriptions: List<Int>, currentImage: Int, modifier: Modifier = Modifier){
    Surface(
        elevation = 5.dp,
        modifier = modifier
    ) {
        Column(
            modifier = modifier.padding(20.dp)
        ) {
            Text(text = stringResource(id = descriptions[currentImage]),
                fontSize = 25.sp,
                fontWeight = FontWeight.Light
            )
            Text(text = stringResource(id = descriptions[currentImage]),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun NavigationButton(buttonName: String, action: () -> Unit, modifier: Modifier = Modifier){
    Button(onClick = action, Modifier.width(140.dp)) {
        Text(text = buttonName)
    }
}