package com.sample.slide

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import androidx.slidingpanelayout.widget.SlidingPaneLayout.SimplePanelSlideListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SlidingPaneLayout.PanelSlideListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = "Button 1 inside slidingpane is pressed"
            Log.e("slide", rootSlidingLayout.parallaxDistance.toString())
            rootSlidingLayout.closePane() //use this to close panel
        }
        button2.setOnClickListener {
            Toast.makeText(this, "Button 2 pressed", Toast.LENGTH_SHORT).show()
            Log.e("slide", rootSlidingLayout.parallaxDistance.toString())
            rootSlidingLayout.closePane() //use this to close panel
        }
        btnOpenPanel.setOnClickListener {
            Log.e("slide", rootSlidingLayout.parallaxDistance.toString())
            rootSlidingLayout.openPane()
        }

        rootSlidingLayout.setPanelSlideListener(this )
        val slide = SlidingPaneLayout(this)
    }

    override fun onPanelSlide(panel: View, slideOffset: Float) {
        Log.e("slide", slideOffset.toString())
        rootSlidingLayout.parallaxDistance = slideOffset.toInt()
    }

    override fun onPanelClosed(panel: View) {
        Log.e("slide", "onPanelClosed")
    }

    override fun onPanelOpened(panel: View) {
        Log.e("slide", "onPanelOpened")
    }
}
