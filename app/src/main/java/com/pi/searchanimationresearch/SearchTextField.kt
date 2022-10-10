package com.pi.searchanimationresearch

import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.widget.EditText
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun SearchTextField(textFieldOnFocusChange: () -> Unit) {
    AndroidView(factory = {
        EditText(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                128
            )
            hint = "Введите поисковый запрос"
            onFocusChangeListener =
                OnFocusChangeListener { view, hasFocus ->
                    if (view.isFocused) {
                        textFieldOnFocusChange()
                    }
                }
            id = R.id.etFakeSearch
            transitionName = "MyTransition"
        }
    }, Modifier.padding(16.dp))
}
