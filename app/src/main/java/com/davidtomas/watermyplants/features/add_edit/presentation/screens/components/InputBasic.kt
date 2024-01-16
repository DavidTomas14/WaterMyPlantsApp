package com.davidtomas.watermyplants.features.add_edit.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.davidtomas.watermyplants.R
import com.davidtomas.watermyplants.R.drawable
import com.davidtomas.watermyplants.core_ui.LocalSpacing

@Composable
fun InputBasic(
    labelText: String,
    hintText: String,
    text: String,
    maxLength: Int = 15,
    enableInput: Boolean = true,
    onTextChanged: (String) -> Unit,
    trailingIcon: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = labelText,
            color = Color.Black,
            style = MaterialTheme.typography.body2
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { text ->
                if (text.length <= maxLength) {
                    onTextChanged(text)
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledTextColor = Color.Black,
                textColor = Color.Black
            ),
            enabled = enableInput,
            placeholder = {
                Text(
                    text = hintText,
                    color = Color.Gray,
                    style = MaterialTheme.typography.body2
                )
            },
            trailingIcon = trailingIcon
        )
    }
}

@Composable
@Preview(showBackground = true)
fun InputBasicComponentPreview() {
    InputBasic(
        labelText = "Plant Name *",
        hintText = "Introduce plant name",
        text = "",
        onTextChanged = {},
        trailingIcon = {
            Image(
                painter = painterResource(id = drawable.chevron_down),
                contentDescription = ""
            )
        }
    )
}