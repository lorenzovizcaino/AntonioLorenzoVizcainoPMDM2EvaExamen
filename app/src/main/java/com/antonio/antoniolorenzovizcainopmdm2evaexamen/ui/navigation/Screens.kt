package com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.navigation

sealed class Screens(val route:String){
    object Menu: Screens("initial_screen")//info a aparecer en pantalla


    object Pantalla1: Screens("pantalla1")//info a aparecer en pantalla
    object Pantalla2: Screens("pantalla2")//info a aparecer en pantalla
    object Pantalla3: Screens("pantalla3")//info a aparecer en pantalla
    object Pantalla4: Screens("pantalla4")//info a aparecer en pantalla
}
