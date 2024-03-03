package com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.screens.ExamenViewModel
import com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.screens.Menu
import com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.screens.Pantalla1
import com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.screens.Pantalla2
import com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.screens.Pantalla3
import com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.screens.Pantalla4

@Composable
fun Navigation() {
    val navController = rememberNavController() //linea para recordar NavController entre pantallas
    val viewModel= remember{ExamenViewModel()} //linea para recordar viewModel entre pantallas
    NavHost(navController, startDestination = Screens.Menu.route) {
        //pantalla principal con la navegación
        composable(route = Screens.Menu.route) { Menu(navController, viewModel) }//Nombre del fichero .kt al que navegar

        composable(route = Screens.Pantalla1.route) {
            Pantalla1() //Nombre de la función composable a la que navegar
        }
        composable(route = Screens.Pantalla2.route) {
            Pantalla2(viewModel) //Nombre de la función composable a la que navegar
        }
        composable(route = Screens.Pantalla3.route) {
            Pantalla3() //Nombre de la función composable a la que navegar
        }
        composable(route = Screens.Pantalla4.route) {
            Pantalla4() //Nombre de la función composable a la que navegar
        }


    }
}