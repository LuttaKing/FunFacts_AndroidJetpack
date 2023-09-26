package com.example.funfacts.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfacts.ui.TextComponent
import com.example.funfacts.ui.TopBar

@Composable
fun WelcomeScreen(animalSelected: String,name:String){

    Surface(
        modifier= Modifier.fillMaxSize()
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)) {

            TopBar("Welcome $name")
            Spacer(modifier= Modifier.size(20.dp))
            TextComponent(tex = "Lets learn about you, you seem to love $animalSelected", textSiz = 24.sp)

            Spacer(modifier= Modifier.size(20.dp))

            TextComponent(tex = "Now this other text", textSiz = 20.sp, colorv = Color.Magenta)
            Spacer(modifier= Modifier.size(20.dp))

            Card(shape= RoundedCornerShape(8.dp),modifier = Modifier
                .padding(24.dp)
                .size(130.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ){
                TextComponent(tex = "Some text here", textSiz = 20.sp )
            }
        }

    }
}

@Composable
@Preview
fun WelcomeScreenPreview(){
    WelcomeScreen("DOG","Yesman")
}