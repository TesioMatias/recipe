package com.matiastesio.mvvmrecipe.presentation.ui.recipelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.matiastesio.mvvmrecipe.presentation.components.*
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
                val selectedCategory = viewModel.selectedCategory.value
                val loading = viewModel.loading.value

                Column {
                    SearchAppBar(
                        query = query,
                        onQueryChanged = viewModel::onQueryChanged,
                        onExecuteSearch = viewModel::newSearch,
                        scrollPosition = viewModel.categoryScrollPosition,
                        selectedCategory = selectedCategory,
                        onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                        onChangeCategoryScrollPosition = viewModel::onChangeCategoryScrollPosition
                    )
                    
                    /*
                    // like animation test
                    Row(
                        modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                    ) {
                        val state = remember{mutableStateOf(HeartAnimationDefinition.HeartButtonState.IDLE)}
                        AnimatedHeartButton(
                            modifier = Modifier,
                            buttonState = state,
                            onToggle =  {
                                state.value = if(state.value == HeartAnimationDefinition.HeartButtonState.IDLE) {
                                    HeartAnimationDefinition.HeartButtonState.ACTIVE
                                } else {
                                    HeartAnimationDefinition.HeartButtonState.IDLE
                                }
                            }
                        )
                    }*/

                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        if (loading) {
                            LoadingRecipeListShimmer(imageHeight = 250.dp)
                        } else {
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

                        // CircularIndeterminateProgressBar(isDisplayed = loading)
                    }
                }
            }
        }
    }
}
