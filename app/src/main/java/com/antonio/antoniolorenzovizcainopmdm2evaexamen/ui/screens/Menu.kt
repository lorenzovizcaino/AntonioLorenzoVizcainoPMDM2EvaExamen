package com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.miscompose.MyButton
import com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.navigation.Screens

@Composable
fun Menu(navController: NavController, viewModel: ExamenViewModel) {
    val context = LocalContext.current


    val lista: List <Botones> =listOf(
        Botones ("Boton 1") { navController -> navController.navigate(route = Screens.Pantalla1.route) },
        Botones ("Boton 2") { navController -> navController.navigate(route = Screens.Pantalla2.route) },
        Botones ("Boton 3") { navController -> navController.navigate(route = Screens.Pantalla3.route) },
        Botones ("Boton 4") { navController -> navController.navigate(route = Screens.Pantalla4.route) },
    )


    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly){
        lista.forEach{item->
            MyButton(function = {item.onClick(navController)}, texto = item.nombre, color = Color.Green)
        }
    }


}


