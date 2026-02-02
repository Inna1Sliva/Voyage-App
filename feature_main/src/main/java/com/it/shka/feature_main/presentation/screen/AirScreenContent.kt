package com.it.shka.feature_main.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.it.shka.feature_main.ItemList
import com.it.shka.feature_main.R
import com.it.shka.feature_main.presentation.model.DataViewModel
import com.it.shka.feature_main.presentation.animation.ShimmerPlaceholder
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AirScreenContent(padding: PaddingValues, onClickWereSearch: () -> Unit) {
    val vm: DataViewModel = koinViewModel()
    val offerState = vm.offerState.collectAsState()
    when {
        offerState.value.isEmpty() -> {
            LoaderContent()
        }

        offerState.value.isNotEmpty() -> {
            AirScreen(vm, onClickWereSearch = onClickWereSearch, padding)
        }

        else -> {}
    }
}

@Composable
fun AirScreen(vm: DataViewModel, onClickWereSearch: () -> Unit, padding: PaddingValues) {
    val offerState = vm.offerState.collectAsState()
    val searchCacheUiState = vm.searchCacheUiState.collectAsState()
    val whereFrom = rememberSaveable { mutableStateOf("") }
    val where = remember { mutableStateOf("") }
    LaunchedEffect(searchCacheUiState) {
        searchCacheUiState.value.cache.let { whereFrom.value = it.toString() }
    }


    Column(
        modifier = Modifier
            .padding(paddingValues = padding)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(state = rememberScrollState())
    ) {

        Text(
            text = stringResource(R.string.title_main_screen),
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 22.sp,
            modifier = Modifier
                .padding(60.dp)
                .wrapContentSize(),
            textAlign = TextAlign.Center
        )
        Box(
            modifier = Modifier
                .padding(16.dp)
                .wrapContentSize()
                .fillMaxWidth()
                .background(colorResource(R.color.back_search1), shape = RoundedCornerShape(16.dp)),
            Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(
                        colorResource(R.color.back_search2),
                        shape = RoundedCornerShape(16.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .padding(start = 10.dp, 5.dp)
                        .size(width = 24.dp, height = 24.dp),
                    tint = colorResource(R.color.back_search1),
                    painter = painterResource(R.drawable.icon_search),
                    contentDescription = null,
                )
                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(5.dp)

                ) {
                    TextField(
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedTextColor = Color.White,
                            focusedTextColor = Color.White
                        ),
                        placeholder = {
                            Text(
                                fontSize = 16.sp,
                                color = colorResource(R.color.Basic_Grey_6),
                                text = stringResource(R.string.placeholder_where_from)
                            )
                        },
                        value = whereFrom.value,
                        onValueChange = { whereFrom.value = it }
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .padding(start = 16.dp, end = 16.dp)
                            .background(colorResource(R.color.Basic_Grey5))
                    )

                    if (where.value.isEmpty()) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .clickable {
                                    onClickWereSearch()
                                    vm.setSearchWhereFrom(whereFrom.value)
                                },
                            text = stringResource(R.string.placeholder_Where),
                            fontSize = 16.sp,
                            color = colorResource(R.color.Basic_Grey_6)
                        )
                    } else {
                        TextField(
                            value = where.value,
                            placeholder = {
                                Text(
                                    fontSize = 16.sp,
                                    color = colorResource(R.color.Basic_Grey_6),
                                    text = stringResource(R.string.placeholder_Where)
                                )
                            },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                disabledTextColor = colorResource(R.color.Basic_Grey_6),
                                unfocusedTextColor = colorResource(R.color.Basic_Grey_6),
                                focusedTextColor = Color.White
                            ),
                            onValueChange = { where.value = it }
                        )
                    }
                }
            }
        }
        Text(
            modifier = Modifier
                .padding(15.dp),
            text = stringResource(R.string.Fly_away_musically),
            color = Color.White,
            fontSize = 22.sp
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
        ) {
            items(offerState.value) { data ->
                ItemList(data)
            }
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
                .padding(16.dp)
                .background(
                    color = colorResource(R.color.Basic_Grey_3),
                    shape = RoundedCornerShape(8.dp)
                ),
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.Basic_Grey_3),
                contentColor = colorResource(R.color.Basic_Grey_3)
            )

        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(),
                text = stringResource(R.string.title_button),
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun LoaderContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(state = rememberScrollState())
    ) {
        Text(
            text = stringResource(R.string.title_main_screen),
            color = Color.White,
            fontSize = 22.sp,
            modifier = Modifier
                .padding(60.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Box(
            modifier = Modifier
                .padding(16.dp)
                .wrapContentSize()
                .fillMaxWidth()
                .background(colorResource(R.color.back_search1), shape = RoundedCornerShape(16.dp)),
            Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(
                        colorResource(R.color.back_search2),
                        shape = RoundedCornerShape(16.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ShimmerPlaceholder(
                    modifier = Modifier
                        .padding(start = 10.dp, 5.dp)
                        .size(width = 24.dp, height = 24.dp),
                    shape = RoundedCornerShape(8.dp)
                )

                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(5.dp)

                ) {
                    ShimmerPlaceholder(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        shape = RoundedCornerShape(16.dp)
                    )
                }
            }
        }
        ShimmerPlaceholder(
            modifier = Modifier
                .padding(15.dp)
                .width(120.dp)
                .height(16.dp),
            shape = RectangleShape
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ShimmerPlaceholder(
                modifier = Modifier
                    .size(width = 150.dp, height = 150.dp)
                    .padding(5.dp),
                shape = RoundedCornerShape(16.dp)
            )
            ShimmerPlaceholder(
                modifier = Modifier
                    .size(width = 150.dp, height = 150.dp)
                    .padding(5.dp),
                shape = RoundedCornerShape(16.dp)
            )
            ShimmerPlaceholder(
                modifier = Modifier
                    .size(width = 150.dp, height = 150.dp)
                    .padding(5.dp),
                shape = RoundedCornerShape(16.dp)
            )
        }
        ShimmerPlaceholder(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(8.dp)
        )

    }
}