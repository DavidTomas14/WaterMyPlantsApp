package com.davidtomas.watermyplants.features.add_edit.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.davidtomas.watermyplants.R
import com.davidtomas.watermyplants.core_ui.LocalSpacing

@Composable
fun InputBasic(
    labelText: String,
    hintText: String,
    text: String,
    maxLength: Int = 15,
    onTextChanged: (String) -> Unit,
    trailingIcon: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = labelText)
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        OutlinedTextField(
            value = text,
            onValueChange = { text ->
                if (text.length <= maxLength) {
                    onTextChanged(text)
                }
            },
            placeholder = {
                Text(text = hintText)
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
                painter = painterResource(id = R.drawable.chevron_down),
                contentDescription = ""
            )
        }
    )
}