package com.willowtree.matthewcorbett.motionlayoutdux.activities

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.willowtree.matthewcorbett.motionlayoutdux.R
import com.willowtree.matthewcorbett.motionlayoutdux.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() {
    var motionLayout: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        motionLayout = findViewById(R.id.motionLayout)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addPage("Page 1", R.layout.view_pager_page_1)
        adapter.addPage("Page 2", R.layout.view_pager_page_2)
        adapter.addPage("Page 3", R.layout.view_pager_page_3)
        pager.adapter = adapter
        tabs.setupWithViewPager(pager)
        if (motionLayout != null) {
            pager.addOnPageChangeListener(motionLayout as ViewPager.OnPageChangeListener)
        }
    }
}