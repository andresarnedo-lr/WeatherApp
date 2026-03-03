package com.arnedo.weatherapp.common.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.arnedo.weatherapp.common.utils.Constants

@Entity(tableName = Constants.E_CITY)
data class City(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var name: String = "",
    var country: String = "",
    var lat: Double = 0.0,
    var lon: Double = 0.0,
    @Ignore var tz_id: String = ""
){
    override fun toString(): String {
        return "$name, $country"
    }
}

//"name": "London",
//"region": "City of London, Greater London",
//"country": "United Kingdom",
//"lat": 51.5171,
//"lon": -0.1062,
//"tz_id": "Europe/London",