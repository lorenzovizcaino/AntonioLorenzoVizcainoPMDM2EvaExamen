package com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ExamenViewModel: ViewModel(){
    var like1 by mutableStateOf(0)
        private set

    var like2 by mutableStateOf(0)
        private set

    fun sumarLike1(){
        like1++
    }
    fun sumarLike2(){
        like2++
    }

    fun restarLike1(){
        like1--
    }
    fun restarLike2(){
        like2--
    }
}