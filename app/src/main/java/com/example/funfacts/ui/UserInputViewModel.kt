package com.example.funfacts.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UserInputViewModel: ViewModel() {

    var uiState = mutableStateOf(UserInputScreenState())

    fun onEventt(event: UserDataUiEvents){
        when (event){
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy( nameEntered = event.name)
            }
            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalValue
                )
            }
        }
    }

}

// for data
data class UserInputScreenState(

    var nameEntered:String ="",
    var animalSelected:String =""
)

// for events
sealed class UserDataUiEvents{

    data class UserNameEntered(val name:String): UserDataUiEvents()
    data class AnimalSelected(val animalValue:String): UserDataUiEvents()
}