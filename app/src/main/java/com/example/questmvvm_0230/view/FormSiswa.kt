package com.example.questmvvm_0230.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.questmvvm_0230.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    pilihanJK: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
){
    var txtNama by rememberSaveable { mutableStateOf("") }
    var txtAlamat by remember { mutableStateOf("") }
    var txtGender by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.app_name), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(isiRuang),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = txtNama,
                    singleLine = true,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .width(250.dp)
                        .padding(top = 20.dp),
                    label = { Text(text = stringResource(R.string.nama)) },
                    onValueChange = {
                        txtNama = it
                    }
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(12.dp)
                        .width(250.dp),
                    thickness = dimensionResource(R.dimen.thickness_divider),
                    color = Color.Blue
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    pilihanJK.forEach { item ->
                        Row(
                            modifier = Modifier.selectable(
                                selected = txtGender == item,
                                onClick = {
                                    txtGender = item
                                }
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = txtGender == item,
                                onClick = {
                                    txtGender = item
                                }
                            )
                            Text(item)
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(5.dp)
                        .width(250.dp),
                    thickness = dimensionResource(R.dimen.thickness_divider),
                    color = Color.Blue
                )
                OutlinedTextField(
                    value = txtAlamat,
                    singleLine = true,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.width(250.dp),
                    label = { Text(text = stringResource(R.string.alamat)) },
                    onValueChange = {
                        txtAlamat = it
                    }
                )
            }
        }
    }
}