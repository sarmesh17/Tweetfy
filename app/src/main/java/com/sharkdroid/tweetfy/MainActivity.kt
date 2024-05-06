package com.sharkdroid.tweetfy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sharkdroid.tweetfy.screen.CategoriesScreen
import com.sharkdroid.tweetfy.screen.DetailsScreen
import com.sharkdroid.tweetfy.ui.theme.TweetfyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TweetfyTheme {
             Scaffold (
                 topBar = {
                     
                     TopAppBar(title = { 
                         
                         Text(text = "Tweetfy", color = Color.White)
                     }, colors = TopAppBarDefaults.topAppBarColors(Color.Black))
                 }
             ){
                 Box(modifier = Modifier.padding(it)){

                     App()

                 }
             }
            }


            }
        }

    @Composable
    private fun App() {

        val navController= rememberNavController()
        NavHost(navController = navController, startDestination ="categories" ) {

            composable("categories"){

                CategoriesScreen(onClick = {

                    navController.navigate("details/$it")
                })
            }

            composable("details/{category}", arguments = listOf(
                navArgument("category"){

                    type=NavType.StringType
                }
            ) ){

                DetailsScreen()

            }

        }
    }
}


