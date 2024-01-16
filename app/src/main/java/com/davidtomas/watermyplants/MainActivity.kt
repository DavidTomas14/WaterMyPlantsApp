package com.davidtomas.watermyplants

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.davidtomas.watermyplants.core.navigation.Route
import com.davidtomas.watermyplants.core_ui.WaterMyPlantsTheme
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.AddEditPlantScreen
import com.davidtomas.watermyplants.features.home.presentation.HomeScreen
import com.davidtomas.watermyplants.features.plant_detail.presentation.PlantDetailScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterMyPlantsTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                var showFab by remember { mutableStateOf(false) }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState,
                    floatingActionButton = {
                        if (showFab)
                            FloatingActionButton(
                                onClick = {
                                    navController.navigate(Route.ADD_EDIT)
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "",
                                    tint = Color.White
                                )
                            }
                    },
                    floatingActionButtonPosition = FabPosition.End
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Route.HOME
                    ) {
                        composable(Route.HOME) {
                            showFab = true
                            HomeScreen(
                                onPlantItemClick = { plantId ->
                                    navController.navigate(
                                        Route.PLANT_DETAIL + "/$plantId"
                                    )
                                },
                                scaffoldState = scaffoldState
                            )
                        }
                        composable(
                            route = Route.PLANT_DETAIL + "/{plantId}",
                            arguments = listOf(
                                navArgument("plantId") {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            val plantId = it.arguments?.getString("plantId")!!
                            showFab = false
                            PlantDetailScreen(
                                onBackIconClick = {
                                    navController.navigateUp()
                                },
                                onEditIconClick = {
                                    navController.navigate(
                                        Route.ADD_EDIT  + "?plantId=$plantId"
                                    )
                                },
                                plantName = plantId,
                                scaffoldState = scaffoldState
                            )
                        }
                        composable(
                            route = Route.ADD_EDIT + "?plantId={plantId}",
                            arguments = listOf(
                                navArgument("plantId") {
                                    type = NavType.StringType
                                    nullable = true
                                }
                            )) {
                            val plantId = it.arguments?.getString("plantId")
                            showFab = false
                            AddEditPlantScreen(
                                plantId = plantId,
                                scaffoldState = scaffoldState,
                                navigateHome = { navController.navigate(Route.HOME) }
                            )
                        }
                    }
                }
            }
        }
    }
}
