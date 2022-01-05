package com.matiastesio.mvvmrecipe.presentation.ui.recipelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.matiastesio.mvvmrecipe.R
import com.matiastesio.mvvmrecipe.presentation.components.RecipeCard
import com.matiastesio.mvvmrecipe.utils.observeOnError
import com.matiastesio.mvvmrecipe.utils.observeOnLoading
import com.matiastesio.mvvmrecipe.utils.observeOnSuccess
import com.matiastesio.mvvmrecipe.utils.setLifecycleOwner
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val recipies = viewModel.recipe.value

                val query = viewModel.query.value

                Column {

                    Surface(
                        elevation = 8.dp,
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = MaterialTheme.colors.primary
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            TextField(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(8.dp),
                                value = query,
                                onValueChange = {newValue -> viewModel.onQueryChanged(newValue)},
                                label = {Text(text = "Search")},
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text,
                                    imeAction = ImeAction.Search
                                ),
                                leadingIcon = {Icon(Icons.Filled.Search)},
                                onImeActionPerformed = {
                                    actions, softKeyboardController ->
                                        if (ImeAction.Search == actions) {
                                            viewModel.newSearch(query)
                                            softKeyboardController?.hideSoftwareKeyboard()
                                        }
                                },
                                textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                                backgroundColor = MaterialTheme.colors.surface
                            )
                        }
                    }
                    LazyColumn {
                        itemsIndexed(
                            items = recipies
                        ) { index, item ->
                            RecipeCard(
                                recipe = item,
                                onClick = {}
                            )
                        }
                    }
                }
            }
        }
    }
}