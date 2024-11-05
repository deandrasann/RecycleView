package com.example.recycleview

data class Disaster(
    val nameDisaster: String = "",
//    val disasterType: String = ""
){
    fun getDisasterDrawable(): Int {
        return when (nameDisaster) {
            "Flood" -> R.drawable.flood
            "Earthquake" -> R.drawable.earthquake
            "Wildfire" -> R.drawable.wildfire
            "Tsunami" -> R.drawable.tsunami
            "Chemical Spill" -> R.drawable.chemical_spill
            "Hurricane" -> R.drawable.hurricane
            else -> R.drawable.flood
        }
    }
}
