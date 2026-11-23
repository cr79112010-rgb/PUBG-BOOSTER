
package com.h777.pubgturbox

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*
import android.graphics.Typeface

class MainActivity : Activity() {

    private val red = Color.rgb(255, 35, 55)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(25, 35, 25, 35)
            setBackgroundColor(Color.BLACK)
        }

        val title = TextView(this).apply {
            text = "PUBG TURBO X"
            textSize = 32f
            setTextColor(red)
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "ULTIMATE GAMING EXPERIENCE"
            textSize = 12f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
        }

        val status = TextView(this).apply {
            text = "\nSYSTEM STATUS: READY\n"
            textSize = 16f
            setTextColor(Color.GREEN)
            gravity = Gravity.CENTER
        }

        val start = Button(this).apply {
            text = "START PUBG"
            setOnClickListener {
                val intent = packageManager
                    .getLaunchIntentForPackage("com.tencent.ig")

                if (intent != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "PUBG not installed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        val device = Button(this).apply {
            text = "DEVICE INFORMATION"
            setOnClickListener {
                val info = "Android: ${android.os.Build.VERSION.RELEASE}\n" +
                    "Device: ${android.os.Build.MODEL}"
                Toast.makeText(
                    this@MainActivity,
                    info,
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        val about = Button(this).apply {
            text = "ABOUT PUBG TURBO X"
            setOnClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "PUBG TURBO X - Version 1.0",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        root.addView(title)
        root.addView(subtitle)
        root.addView(status)

        root.addView(start)
        root.addView(device)
        root.addView(about)

        setContentView(root)
    }
}
