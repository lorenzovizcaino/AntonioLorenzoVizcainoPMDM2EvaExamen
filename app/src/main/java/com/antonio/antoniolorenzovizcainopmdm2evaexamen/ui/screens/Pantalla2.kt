package com.antonio.antoniolorenzovizcainopmdm2evaexamen.ui.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.AlertDialog
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun Pantalla2(viewModel: ExamenViewModel) {
    var context= LocalContext.current
    val  showDialog = remember { mutableStateOf(false) }
    Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround){

        Row(modifier= Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically){
            Button(onClick = { viewModel.sumarLike1() }) {
                Text(text = "Like 1")
            }
            Text(text = viewModel.like1.toString())
            Icon(Icons.Default.Close, contentDescription = "Aspa", tint = Color.Red,modifier = Modifier.size(50.dp).clickable {
                if(viewModel.like1>0) viewModel.restarLike1()
            })
        }

        Row(modifier= Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically){
            Button(onClick = { viewModel.sumarLike2() }) {
                Text(text = "Like 2")
            }
            Text(text = viewModel.like2.toString())
            Icon(Icons.Default.Close, contentDescription = "Aspa", tint = Color.Red,modifier = Modifier.size(50.dp).clickable {
                if(viewModel.like2>0) viewModel.restarLike2()
            })
        }

        Row(modifier= Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically){
            Text(text = "Likes")
            Text(text = (viewModel.like1+viewModel.like2).toString())
            Icon(Icons.Default.CheckCircle, contentDescription = "Verificado", tint = Color.Blue,modifier = Modifier.size(50.dp).clickable {
                ExampleAlertDialog(
                    titleText="ACCIÓN",
                    bodyText = "¿Eliminar ítem?",
                    confirmButtonText = "ACEPTAR",
                    onConfirm = {
                        Toast.makeText(context, "ACEPTAR", Toast.LENGTH_SHORT).show()
                    },
                    cancelButtonText = "CANCELAR",
                    onCancel = {
                        Toast.makeText(context, "CANCELAR", Toast.LENGTH_SHORT).show()
                    }
                    ,
                    onDismiss = {
                        //showDialog(false)
                    }
                )
            })
        }
    }
}

@Composable
fun ExampleAlertDialog(
    titleText: String? = null,
    bodyText: String,
    confirmButtonText: String,
    onConfirm: () -> Unit,
    cancelButtonText: String,
    onCancel: () -> Unit,
    onDismiss: () -> Unit
) {
    val title: @Composable (() -> Unit)? = if (titleText.isNullOrBlank())
        null
    else {
        { androidx.compose.material.Text(text = titleText) }
    }

    AlertDialog(
        title = title,
        text = {
            androidx.compose.material.Text(
                text = bodyText
            )
        },
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm()
                    onDismiss()
                }) {
                androidx.compose.material.Text(text = confirmButtonText)
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onCancel()
                onDismiss()
            }) {
                androidx.compose.material.Text(text = cancelButtonText)
            }
        }
    )
}