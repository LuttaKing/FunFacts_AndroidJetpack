package com.example.funfacts.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfacts.ui.AnimalCard
import com.example.funfacts.ui.ButtonComponent
import com.example.funfacts.ui.TextComponent
import com.example.funfacts.ui.TextFieldComponent
import com.example.funfacts.ui.TopBar
import com.example.funfacts.ui.UserDataUiEvents
import com.example.funfacts.ui.UserInputViewModel

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel,
                    showWelcomeScreen:() -> Unit
                    ) {

    Surface(
        modifier= Modifier.fillMaxSize()
    ){
Column(modifier = Modifier
    .fillMaxSize()
    .padding(18.dp)) {
    TopBar("Hi There")

    TextComponent(tex = "Lets learn about you", textSiz = 24.sp)

    Spacer(modifier= Modifier.size(20.dp))

    TextComponent(tex = "Lets learn about you because we will be stealing your data", textSiz = 18.sp)
    Spacer(modifier= Modifier.size(60.dp))

    TextComponent(tex = "Name", textSiz = 18.sp)
    Spacer(modifier= Modifier.size(20.dp))
    TextFieldComponent(onTexChange = {
        userInputViewModel.onEventt(
            UserDataUiEvents.UserNameEntered(it)
        )
    })
    Spacer(modifier= Modifier.size(10.dp))
    TextComponent(tex = "Select animal", textSiz = 18.sp)
    Spacer(modifier= Modifier.size(20.dp))
    Row(modifier= Modifier.fillMaxWidth()) {
        AnimalCard("Dog",userInputViewModel.uiState.value.animalSelected=="Dog", animalSelected = {
            userInputViewModel.onEventt(
                UserDataUiEvents.AnimalSelected(it)
            )
        })
        AnimalCard("Cat", userInputViewModel.uiState.value.animalSelected=="Cat", animalSelected = { userInputViewModel.onEventt(
            UserDataUiEvents.AnimalSelected(it)
        )})
    }
    Spacer(modifier = Modifier.weight(1f))

    if (!userInputViewModel.uiState.value.nameEntered.isNullOrEmpty() && !userInputViewModel.uiState.value.animalSelected.isNullOrEmpty())
    {
        ButtonComponent(goToDetailScreen = {
showWelcomeScreen(
)
        })
    }
    
}
    }
}

@Preview
@Composable
fun UserInputScreenPreview(){
    UserInputScreen(UserInputViewModel(),{})
}