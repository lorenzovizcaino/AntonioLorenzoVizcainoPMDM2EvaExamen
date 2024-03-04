package com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.screens

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
//import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.antonio.antoniolorenzovizcainopmdm2evaexamen.R
import com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.miscompose.MyButton
import com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Menu(navController: NavController, viewModel: ExamenViewModel) {
    val context = LocalContext.current




    Scaffold(
        topBar = {

            MyTopBar()

        },
        content = {padding ->
            Botones(padding,navController)

        }
    )








}

@Composable
fun Botones(padding: PaddingValues, navController: NavController) {
    val lista: List <Botones> =listOf(
        Botones ("Boton 1") { navController -> navController.navigate(route = Screens.Pantalla1.route) },
        Botones ("Boton 2") { navController -> navController.navigate(route = Screens.Pantalla2.route) },
        Botones ("Boton 3") { navController -> navController.navigate(route = Screens.Pantalla3.route) },
        Botones ("Boton 4") { navController -> navController.navigate(route = Screens.Pantalla4.route) },
    )
    Column(modifier=Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        lista.forEach{item->
            MyButton(function = {item.onClick(navController)}, texto = item.nombre, color = Color.Green)
        }
    }
}


@Composable
fun MyTopBar(
    backgroundColor: Color = Color.Black,
    contentColor: Color = Color.White,
    elevation: Dp = AppBarDefaults.TopAppBarElevation
) {
    val context= LocalContext.current
    TopAppBar(

        navigationIcon = {
            IconButton(onClick = {showToast2(string = "Ir hacia atras", context = context) }) {
                Icon(imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Ir hacia atras",
                    tint = Color.White
                )
            }
        },
        title = { Text("Scaffold con Botones") },
        actions = {
            IconButton(onClick = { showToast2("Añadir a marcadores",context)
            }) {
                Icon(painter = painterResource(id = R.drawable.ic_bookmark),
                    contentDescription = "marcadores",
                    tint = Color.White
                )
            }
            IconButton(onClick = {
                showToast2("Compartir",context)
                //compartir("Contenido para compartir",context)
            }) {
                Icon(imageVector = Icons.Filled.Share,
                    contentDescription = "Compartir",
                    tint = Color.White
                )
            }

            IconButton(onClick = { showToast2("Ver mas", context)
            }) {
                Icon(imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Ver más",
                    tint = Color.White
                )
            }
        },
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation

    )
}

//fun compartir(content: String, context: Context) {
//
//    val sendIntent: Intent = Intent().apply {
//        action = Intent.ACTION_SEND
//        putExtra(Intent.EXTRA_TEXT, content)
//        type = "text/plain"
//    }
//
//    try {
//
//        startActivity(sendIntent)
//    } catch (e: ActivityNotFoundException) {
//        showToast2("No se puede",context)
//
//    }
//
//
//
////    val shareIntent = Intent.createChooser(sendIntent, null)
////    // Inicia la actividad de compartir
////    startActivity(shareIntent)
//}

