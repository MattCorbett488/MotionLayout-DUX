package com.willowtree.matthewcorbett.motionlayoutdux.activities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.willowtree.matthewcorbett.motionlayoutdux.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentTransitionButton.startActivityOnClick(FragmentTransitionActivity::class.java)
        appBarTransitionButton.startActivityOnClick(AppBarLayoutActivity::class.java)
        viewPagerPageTransitionButton.startActivityOnClick(ViewPagerActivity::class.java)
        keyframeAnimationButton.startActivityOnClick(KeyframeActivity::class.java)
    }

    private fun Button.startActivityOnClick(clazz: Class<out Activity>) = setOnClickListener {
        startActivity(Intent(this@MainActivity, clazz))
    }
}
