package com.example.demoheal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import com.example.demoheal.ui.theme.DemoHealTheme

// Modèle de données pour un utilisateur
data class User(val name: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoHealTheme {
                UserApp()
            }
        }
    }
}

@Composable
fun UserApp() {
    // Liste vide initiale d'utilisateurs
    var users by remember { mutableStateOf(emptyList<User>()) }

    // Variables d'état pour les champs de saisie
    var name by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Champs d'entrée pour ajouter un utilisateur
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nom") },
                    modifier = Modifier.padding(8.dp)
                )


                // Bouton pour ajouter un utilisateur
                Button(
                    onClick = {
                        if (name.text.isNotBlank()) {
                            // Ajouter l'utilisateur à la liste
                            users = users + User(name.text)
                            // Réinitialiser les champs
                            name = TextFieldValue("")
                        }
                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Ajouter l'utilisateur")
                }

                // Afficher la liste des utilisateurs
                UserList(users = users, modifier = Modifier.padding(8.dp))

                Button(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Jouer !")
                }
            }
        }
    )
}

// Composable pour afficher la liste d'utilisateurs
@Composable
fun UserList(users: List<User>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(users) { user ->
            UserItem(user = user)
        }
    }
}

// Composable pour afficher un élément utilisateur
@Composable
fun UserItem(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Nom: ${user.name}")
        }
    }
}

// Preview pour visualiser UserList
@Preview(showBackground = true)
@Composable
fun UserListPreview() {
    DemoHealTheme {
        UserApp()
    }
}
