package com.willowtree.matthewcorbett.motionlayoutdux.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Page : Fragment() {

    var layoutId = 0

    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        layoutId = args?.getInt("layout") ?: 0
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(layoutId, container, false)
}