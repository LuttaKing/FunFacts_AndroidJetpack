package com.example.funfacts.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfacts.R

@Composable
fun TopBar(valu: String){
    Row(modifier = Modifier.fillMaxWidth(),
verticalAlignment = Alignment.CenterVertically,

        ) {
        Text(text=valu, color = Color.Black,
            fontSize = 24.sp, fontWeight = FontWeight.Medium)
 Spacer(modifier = Modifier.weight(1f))
        Image(modifier = Modifier.size(55.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription ="Native Mobile Bits" )
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview(){
TopBar("Hi There")
}

@Composable
fun TextComponent(tex:String,textSiz:TextUnit, colorv:Color=Color.Black){
    Text(text=tex, color = colorv,
        fontSize = textSiz, fontWeight = FontWeight.Light)
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview(){
    TextComponent("Yess FFf", 24.sp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    onTexChange: (name:String) -> Unit
){
    var currentValue by remember {
       mutableStateOf("")
    }

    OutlinedTextField(
        modifier= Modifier.fillMaxWidth(),
        value = currentValue, placeholder = {
         Text(text = "Enter name.", fontSize = 18.sp)
    },
       keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
//        keyboardActions = ,
        onValueChange = {
            currentValue=it
onTexChange(it)
    })

}

@Preview(showBackground = true)
@Composable
fun TextFieldComponentPreview(){
    TextFieldComponent({})
}
