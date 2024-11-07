package com.example.googlesignincompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.googlesignincompose.ui.theme.GoogleSignInComposeTheme
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch

// Add dependencie
//implementation ("com.google.firebase:firebase-auth-ktx:23.1.0")
//implementation ("com.google.android.gms:play-services-auth:21.2.0")

//implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
//implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")
//implementation ("androidx.navigation:navigation-compose:2.8.3")
//implementation ("io.coil-kt:coil-compose:2.4.0")

//Add plugins(build.gradil.kts(:App)
//id ("com.google.gms.google-services")

//Add plugins(build.grAdile.kts)
//buildscript {
//    dependencies {
//        classpath("com.google.gms:google-services:4.4.1")
//    }
//}
// id("com.google.dagger.hilt.android") version "2.50" apply false

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleSignInComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHostContainer(homeNavController = navController)
                }
            }
        }
    }
}

@Composable
private fun NavHostContainer(homeNavController: NavHostController) {
    NavHost(
        navController = homeNavController,
        startDestination = NavItems.SigninScreen.route
    ) {
        composable(NavItems.SigninScreen.route) {
            SignInScreen(homeNavController)
        }
        composable(NavItems.ProfileScreen.route) {
            ProfileScreen(homeNavController)
        }
    }
}

sealed class NavItems(val route: String) {
    object SigninScreen : NavItems("sign_in")
    object ProfileScreen : NavItems("profile")
}
