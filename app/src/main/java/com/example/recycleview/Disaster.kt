package com.example.recycleview

data class Disaster(
    val nameDisaster: String = "",
    val disasterType: String = ""
){
    fun getDisasterDrawable(): Int {
        return when (nameDisaster) {
            "Flood" -> R.drawable.flood  // Nama file drawable untuk banjir
            "Earthquake" -> R.drawable.earthquake  // Nama file drawable untuk gempa
            "Wildfire" -> R.drawable.wildfire  // Nama file drawable untuk kebakaran
            "Tsunami" -> R.drawable.tsunami
            "Chemical Spill" -> R.drawable.chemical_spill
            "Hurricane" -> R.drawable.hurricane
            else -> R.drawable.flood  // Default image jika tipe bencana tidak ditemukan
        }
    }
}
