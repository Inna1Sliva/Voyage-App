package com.it.shka.feature_main.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.it.shka.feature_main.presentation.navigation.navBottom.bottom.NavigationBottom
import com.it.shka.feature_main.R
import com.it.shka.feature_main.presentation.navigation.navBottom.navHost.NavHostBottomController
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainStartInfoContent(){
    val navHostBottomController = rememberNavController()
    val dataViewModel: DataViewModel = koinViewModel()
    val bottomSheetState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        modifier = Modifier
            .fillMaxSize(),
        scaffoldState = bottomSheetState,
        sheetPeekHeight = 0.dp,
        sheetShape = BottomSheetDefaults.ExpandedShape,
        sheetContentColor = colorResource(R.color.back_search3),
        sheetContainerColor = colorResource(R.color.back_search3),
        sheetContent = {BottomSheetScaffoldContent(viewModel = dataViewModel)}
    ){
        Scaffold (
            bottomBar = {
                NavigationBottom(navController =  navHostBottomController)
            },
            content = {padding ->
                NavHostBottomController(navHostBottomController =  navHostBottomController, padding = padding, onClickWereSearch = {
                    scope.launch {
                        bottomSheetState.bottomSheetState.expand()
                    }
                })

            }
        )
    }
}
@Composable
fun BottomSheetScaffoldContent(viewModel: DataViewModel){
    Column(
        modifier = Modifier
            .wrapContentSize()
            .fillMaxWidth()
    ) {
        SearchBottomSheet(viewModel)
        ButtonNavigationBottomSheet(viewModel)
        BoxPointBottomSheet(viewModel)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )
    }
}
@Composable
fun SearchBottomSheet(vm: DataViewModel){
    val stateSearch by vm.whereFromState.collectAsState()
    val textWhere = remember { mutableStateOf( "")}
    val text = remember { mutableStateOf( "")}

    LaunchedEffect(stateSearch.whereFrom) {
        when(stateSearch.whereFrom !=null){
            true -> textWhere.value= stateSearch.whereFrom.toString()
            else -> textWhere.value = ""
        }
    }
    LaunchedEffect(stateSearch.where) {
        when(  stateSearch.where !=null){
            true ->  text.value = stateSearch.where.toString()
            else -> text.value = ""
        }
    }
    when{
        textWhere.value.isNotEmpty()&&text.value.isNotEmpty() ->{}
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(
                color = colorResource(R.color.back_search1),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = 16.sp
                ),
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(width = 28.dp, height = 28.dp),
                        painter = painterResource(R.drawable.air),
                        contentDescription = "aire",
                        tint = colorResource(R.color.back_search2)
                    )
                },
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
                value = textWhere.value,
                onValueChange = { textWhere.value = it }
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(colorResource(R.color.Basic_Grey5))
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = 16.sp
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedTextColor = Color.White,
                    focusedTextColor = Color.White
                ),
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(width = 24.dp, height = 24.dp),
                        painter = painterResource(R.drawable.icon_search),
                        contentDescription = "icon search",
                        tint = colorResource(R.color.back_search2)
                    )
                },
                trailingIcon = {
                    when {
                        text.value.isNotEmpty() -> {
                            Icon(
                                modifier = Modifier
                                    .size(width = 24.dp, height = 24.dp),
                                painter = painterResource(R.drawable.close),
                                contentDescription = "icon  delete text",
                                tint = colorResource(R.color.back_search2)
                            )
                        }
                    }
                },
                maxLines = 1,
                placeholder = {
                    Text(
                        fontSize = 16.sp,
                        color = colorResource(R.color.Basic_Grey_6),
                        text = stringResource(R.string.placeholder_Where)
                    )
                },
                value = text.value,
                onValueChange = { text.value = it }
            )
        }
    }
}
@Composable
fun ButtonNavigationBottomSheet(vm: DataViewModel){
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        Column(
            modifier = Modifier
                .width(75.dp)
                .wrapContentSize()
                .clickable(role = Role.Button, onClick = { }),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .size(width = 60.dp, height = 60.dp)
                    .background(
                        colorResource(R.color.Green_1),
                        shape = RoundedCornerShape(10.dp)
                    ),

                ) {
                Icon(
                    modifier = Modifier
                        .size(width = 28.dp, height = 28.dp)
                        .align(Alignment.Center),
                    painter = painterResource(R.drawable.icon_zone),
                    contentDescription = "",
                    tint = Color.White
                )

            }
            Text(
                text = stringResource(R.string.title_navBottomSheet1),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                lineHeight = 1.4.em,
                color = Color.White,
                minLines = 2
            )
        }
        Column(
            modifier = Modifier
                .width(75.dp)
                .wrapContentSize()
                .clickable(role = Role.Button, onClick = {vm.setSearchWhere("Куда угодно") }),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .size(width = 60.dp, height = 60.dp)
                    .background(colorResource(R.color.Blue), shape = RoundedCornerShape(10.dp)),

                ) {
                Icon(
                    modifier = Modifier
                        .size(width = 28.dp, height = 28.dp)
                        .align(Alignment.Center),
                    painter = painterResource(R.drawable.icon_world),
                    contentDescription = "",
                    tint = Color.White
                )

            }
            Text(
                text = stringResource(R.string.title_navBottomSheet2),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                lineHeight = 1.4.em,
                minLines = 2
            )
        }
        Column(
            modifier = Modifier
                .width(75.dp)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .size(width = 60.dp, height = 60.dp)
                    .background(
                        colorResource(R.color.Blue_grey),
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Icon(
                    modifier = Modifier
                        .size(width = 28.dp, height = 28.dp)
                        .align(Alignment.Center),
                    painter = painterResource(R.drawable.icon_calendar),
                    contentDescription = "",
                    tint = Color.White
                )

            }
            Text(
                text = stringResource(R.string.title_navBottomSheet3),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                lineHeight = 1.4.em,
                color = Color.White,
                minLines = 2
            )
        }
        Column(
            modifier = Modifier
                .width(75.dp)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .size(width = 60.dp, height = 60.dp)
                    .background(
                        colorResource(R.color.Red_orange),
                        shape = RoundedCornerShape(10.dp)
                    ),

                ) {
                Icon(
                    modifier = Modifier
                        .size(width = 28.dp, height = 28.dp)
                        .align(Alignment.Center),
                    painter = painterResource(R.drawable.fire_icon),
                    contentDescription = "",
                    tint = Color.White
                )

            }
            Text(
                text = stringResource(R.string.title_navBottomSheet4),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                lineHeight = 1.4.em,
                minLines = 2
            )
        }

    }
}
@Composable
fun BoxPointBottomSheet(vm: DataViewModel){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(
                color = colorResource(R.color.back_search1),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable( onClick = { vm.setSearchWhere("Стамбул")}),
           horizontalAlignment = AbsoluteAlignment.Left
        ) {
          Row(
              modifier = Modifier
                  .fillMaxWidth()
                  .height(50.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.Absolute.Left
          ) {
              Image(
                  modifier = Modifier
                      .width(50.dp)
                      .clip(shape = RoundedCornerShape(10.dp)),
                  painter = painterResource(R.drawable.stambul),
                  contentScale = ContentScale.FillBounds,
                  contentDescription = null
              )
              Column(
                  modifier = Modifier
                      .padding(start = 10.dp)
              ) {
                  Text(
                      text = stringResource(R.string.title_city1),
                      fontSize = 16.sp,
                      color = Color.White,
                      fontWeight = FontWeight.Bold
                  )
                  Text(
                      text = stringResource(R.string.title),
                      fontSize = 14.sp,
                      color = colorResource(R.color.Basic_Grey5),
                      fontWeight = FontWeight.Light
                  )
              }

          }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .height(1.dp)
                    .background(color = colorResource(R.color.Basic_Grey5))
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .clickable( onClick = { vm.setSearchWhere("Сочи")})
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.Left
                ) {
                    Image(
                        modifier = Modifier
                            .width(50.dp)
                            .clip(shape = RoundedCornerShape(10.dp)),
                        painter = painterResource(R.drawable.sochi),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = null
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.title_city2),
                            fontSize = 16.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = stringResource(R.string.title),
                            fontSize = 14.sp,
                            color = colorResource(R.color.Basic_Grey5),
                            fontWeight = FontWeight.Light
                        )
                    }

                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .height(1.dp)
                        .background(color = colorResource(R.color.Basic_Grey5))
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .clickable( onClick = { vm.setSearchWhere("Пхукет")})
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.Left
                ) {
                    Image(
                        modifier = Modifier
                            .width(50.dp)
                            .clip(shape = RoundedCornerShape(10.dp)),
                        painter = painterResource(R.drawable.phuket),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = null
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.title_city3),
                            fontSize = 16.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = stringResource(R.string.title),
                            fontSize = 14.sp,
                            color = colorResource(R.color.Basic_Grey5),
                            fontWeight = FontWeight.Light
                        )
                    }

                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .height(1.dp)
                        .background(color = colorResource(R.color.Basic_Grey5))
                )
            }
        }


    }
}