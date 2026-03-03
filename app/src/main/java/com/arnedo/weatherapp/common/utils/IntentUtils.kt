package com.arnedo.weatherapp.common.utils

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.net.toUri
import com.arnedo.weatherapp.R

class IntentUtils(private val context: Context) {
    fun showMap(lat: Double, lon: Double, label: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.apply {
            data = "geo: 0,0?q=$lat,$lon($label)".toUri()
            `package` = "com.google.android.apps.maps"
        }
        startIntent(intent)
    }

    fun startIntent(intent: Intent){
        val chooser: Intent = Intent.createChooser(intent, context.getString(R.string.app_name))
        chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        if(intent.resolveActivity(context.packageManager) != null){
            context.startActivity(chooser)
        }else {
            Toast.makeText(context, context.getString(R.string.msg_no_app), Toast.LENGTH_SHORT).show()
        }

    }
}