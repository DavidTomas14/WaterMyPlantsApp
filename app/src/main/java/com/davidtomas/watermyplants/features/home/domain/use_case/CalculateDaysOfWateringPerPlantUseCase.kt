package com.davidtomas.watermyplants.features.home.domain.use_case

import com.davidtomas.watermyplants.features.home.domain.model.PlantModel
import com.davidtomas.watermyplants.features.home.domain.model.PlantStatus
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CalculateDaysOfWateringPerPlantUseCase() {

    // Crear una lista para almacenar las fechas de la semana
    private val fechasSemana = mutableListOf<LocalDate>()

    // Obtener la fecha actual
    val today: LocalDate = LocalDate.now()

    suspend operator fun invoke(plantModel: PlantModel): Map<PlantStatus, PlantModel> {
        // Obtener el primer día de la semana (lunes)
        val primerDiaSemana: LocalDate = today.with(DayOfWeek.MONDAY)


        // Agregar las fechas de lunes a domingo a la lista
        for (i in 0..7) {
            val fecha = primerDiaSemana.plusDays(i.toLong())
            fechasSemana.add(fecha)
        }

        // Imprimir las fechas en el formato deseado (puedes ajustar el formato según tus necesidades)
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        println(formatter.format(today))
        println("Fechas de la semana actual:")
        for (fecha in fechasSemana) {
            println(formatter.format(fecha))
        }

        val plantStatusList =
            listOf(PlantStatus.Today, PlantStatus.ForgotToWater, PlantStatus.NextDays)
        var mapOfWatering: MutableMap<PlantStatus, PlantModel> = mutableMapOf()
        val actualWateringDates = plantModel.wateringDates
        plantStatusList.forEach { plantStatus ->
            actualWateringDates.filter {
                when (plantStatus) {
                    PlantStatus.ForgotToWater -> it.value < today.dayOfWeek.value
                    PlantStatus.Today -> it.value == today.dayOfWeek.value
                    PlantStatus.NextDays -> it.value > today.dayOfWeek.value
                }
            }.let { filteredList ->
                if (filteredList.isEmpty()) return@forEach
                else mapOfWatering[plantStatus] =
                    plantModel.copy(wateringDates = filteredList)
            }
        }

        return mapOfWatering
    }
}