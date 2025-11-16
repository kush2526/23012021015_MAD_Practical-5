package com.example.a23012021015_mad_practical_5.screen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.a23012021015_mad_practical_5.R
import com.example.a23012021015_mad_practical_5.screen.component.FormField
import com.example.a23012021015_mad_practical_5.ui.theme.ButtonBackground
import com.example.a23012021015_mad_practical_5.ui.theme.Pink80

@Composable
fun RegisterScreen(context: Context, navController: NavController){
    Scaffold (modifier = Modifier.fillMaxSize()){
            innerPadding ->
        Box (modifier = Modifier.fillMaxSize().padding(innerPadding)){
            RegisterUI(navController=navController)
        }
    }
}

@Composable
fun RegisterUI(navController: NavController){
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.guni_pink_logo),
            contentDescription = "Logo",
            modifier = Modifier.height(130.dp).align (Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )

        Card (
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth()
        ){
            Column (
                modifier = Modifier.fillMaxWidth().padding(20.dp)
            ){

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("Name", fontSize = 12.sp, modifier = Modifier.weight(0.6f))
                    Box(modifier = Modifier.weight(2f)){
                        FormField("Name", name, onTextChange = {name = it})
                    }
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("Phone Number", fontSize = 12.sp, modifier = Modifier.weight(0.6f))
                    Box(modifier = Modifier.weight(2f)){
                        FormField("Phone Number", phoneNumber, onTextChange = {phoneNumber = it})
                    }
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("City", fontSize = 12.sp, modifier = Modifier.weight(0.6f))
                    Box(modifier = Modifier.weight(2f)){
                        FormField("City", city, onTextChange = {city = it})
                    }
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("Email", fontSize = 12.sp, modifier = Modifier.weight(0.6f))
                    Box(modifier = Modifier.weight(2f)){
                        FormField("Email", email, onTextChange = {email = it})
                    }
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("Password", fontSize = 12.sp, modifier = Modifier.weight(0.6f))
                    Box(modifier = Modifier.weight(2f)){
                        FormField("Password", password, onTextChange = {password = it}, isPasswordField = true)
                    }
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("Confirm Password", fontSize = 12.sp, modifier = Modifier.weight(0.6f))
                    Box(modifier = Modifier.weight(2f)){
                        FormField("Confirm Password", confirmPassword, onTextChange = {confirmPassword = it}, isPasswordField = true)
                    }
                }

                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(containerColor = ButtonBackground),
                ) {
                    Text("Register", fontSize = 18.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row (
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text("Do you have an account?", fontSize = 14.sp)
            Spacer(modifier = Modifier.width(5.dp))
            TextButton(onClick = {
                if(navController != null)
                    navigatetoregistrationScreen(navController)
            }) {
                Text("LOGIN", color = Pink80, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview(){
    val navController = rememberNavController()
    RegisterUI(navController)
}