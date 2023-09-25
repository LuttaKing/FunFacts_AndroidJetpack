package com.example.funfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.funfacts.ui.UserInputViewModel

import com.example.funfacts.ui.screens.FunFactsNavigateGraph
import com.example.funfacts.ui.theme.FunFactsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FunFactsTheme {

                FunFactsApp()


            }
        }
    }

    @Composable
    fun FunFactsApp( userInputViewModel: UserInputViewModel= viewModel()){

        FunFactsNavigateGraph()
    }
}
