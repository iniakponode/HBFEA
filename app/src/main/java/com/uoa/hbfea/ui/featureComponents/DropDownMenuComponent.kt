package com.uoa.hbfea.ui.featureComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(
    menuItems: List<String>,
    selectedText: String,
    onValueChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(2.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
//            label = { menuItems },
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(icon, contentDescription = "Dropdown Icon")
                }
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
        ) {
            menuItems.forEach { label ->
                DropdownMenuItem(
                    text = { (Text(label)) },
                    onClick = {
                        onValueChange(label)
                        expanded = false
                    })
            }
        }
    }
}