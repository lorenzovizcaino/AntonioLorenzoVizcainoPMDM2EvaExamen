package com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.navigation.Screens


@Composable
fun Pantalla2(viewModel: ExamenViewModel, navController: NavHostController) {
    var context= LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround){

        Row(modifier= Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically){
            Button(onClick = { viewModel.sumarLike1() }) {
                Text(text = "Like 1")
            }
            Text(text = viewModel.like1.toString())
            Icon(Icons.Default.Close, contentDescription = "Aspa", tint = Color.Red,modifier = Modifier
                .size(50.dp)
                .clickable {
                    if (viewModel.like1 > 0) viewModel.restarLike1()
                })
        }

        Row(modifier= Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically){
            Button(onClick = { viewModel.sumarLike2() }) {
                Text(text = "Like 2")
            }
            Text(text = viewModel.like2.toString())
            Icon(Icons.Default.Close, contentDescription = "Aspa", tint = Color.Red,modifier = Modifier
                .size(50.dp)
                .clickable {
                    if (viewModel.like2 > 0) viewModel.restarLike2()
                })
        }

        Row(modifier= Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically){
            Text(text = "Likes")
            Text(text = (viewModel.like1+viewModel.like2).toString())
            Icon(Icons.Default.CheckCircle, contentDescription = "Verificado", tint = Color.Blue,modifier = Modifier
                .size(50.dp).clickable {
                    //navController.navigate(route = Screens.Pantalla4.route)
                    showDialog=true
                })



            if (showDialog) {
                AlertDialog(
                    onDismissRequest = {
                        // Se llama cuando el usuario hace clic fuera del cuadro de diálogo o presiona el botón Atrás
                        showDialog = false
                    },
                    title = {
                        Text(text = "Titulo del Dialogo")
                    },
                    text = {
                        Text("Este es el mensaje de un AlertDialog")
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {

                                showDialog = false
                                showToast2("Opcion Aceptada",context)
                            }
                        ) {
                            Text("Aceptar")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {

                                showDialog = false
                                showToast2("Opcion Cancelada",context)
                            }
                        ) {
                            Text("Cancelar")
                        }
                    }
                )
            }









        }
    }
}

