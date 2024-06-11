package com.example.myprofesionalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myprofesionalapp.ui.theme.MyProfesionalAppTheme

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyProfesionalAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}


@Preview(showBackground = true, name = "Latihan")
@Composable
fun AddList() {
    var name by remember {
        mutableStateOf("")
    }

    var nim by remember {
        mutableStateOf("")
    }

    var datas by remember{
        mutableStateOf(listOf(listOf("10121919", "Fajar Alam")))
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Column (
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Masukkan Nama")
                OutlinedTextField(
                    value = name,
                    onValueChange = {text ->
                        name = text
                    }
                )
            }

            Row (
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Masukkan NIM")
                TextField(value = nim, onValueChange = {
                    text ->
                    nim = text
                })
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    if (name.isNotBlank() && nim.isNotBlank()) {

                        datas += listOf(listOf(nim, name))
                        name = ""
                        nim = ""
                    }
                }
            ) {
                Text(text = "Tambahkan Mahasiswa")
            }
        }

        ListMahasiswa(datas = datas)

    }

}

@Composable
fun ListMahasiswa(datas: List<List<String>> = listOf(listOf())) {
    LazyColumn {
        items(datas) {(currentNim, currentName) ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = currentNim)
                Text(text = "-")
                Text(text = currentName)
            }
        }
    }
}