package com.example.funfacts.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfacts.R

@Composable
fun AnimalCard(animalName:String, selected:Boolean, animalSelected:(animalName: String)-> Unit){

    val localFocusManager = LocalFocusManager.current
    Card(shape= RoundedCornerShape(8.dp),modifier = Modifier
        .padding(24.dp)
        .size(130.dp),
elevation = CardDefaults.cardElevation(4.dp)
        ) {


        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    shape = RoundedCornerShape(8.dp),
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent
                ),
            ) {

            Image(modifier= Modifier
                .padding(16.dp)
                .clickable {
                    animalSelected(animalName)
                    localFocusManager.clearFocus()//close keyboard
                },
                painter = painterResource(id = R.drawable.logo), contentDescription = "Yes")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun AnimalCardPreview(){
    AnimalCard("Dog",true, animalSelected = {})
}

@Composable
fun ButtonComponent(
    goToDetailScreen:() -> Unit
){
    Button(modifier = Modifier.fillMaxWidth(),
        onClick = { goToDetailScreen }) {
        TextComponent(tex = "Detail Screen", textSiz = 18.sp, colorv = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonComponentPreview(){
    ButtonComponent({})
}