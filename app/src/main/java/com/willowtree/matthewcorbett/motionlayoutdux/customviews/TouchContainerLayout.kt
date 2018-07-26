package com.willowtree.matthewcorbett.motionlayoutdux.customviews

import android.content.Context
import android.support.v4.view.NestedScrollingParent2
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

class TouchContainerLayout @JvmOverloads constructor(context: Context,
                                                     attributeSet: AttributeSet? = null,
                                                     defStyleAttrs: Int = 0) :
        FrameLayout(context, attributeSet, defStyleAttrs), NestedScrollingParent2 {

    val motionLayout: NestedScrollingParent2
        get() = parent as NestedScrollingParent2

    override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int): Boolean {
        return motionLayout.onStartNestedScroll(child, target, axes, type)
    }

    override fun onNestedScrollAccepted(child: View, target: View, axes: Int, type: Int) {
        motionLayout.onNestedScrollAccepted(child, target, axes, type)
    }

    override fun onStopNestedScroll(target: View, type: Int) {
        motionLayout.onStopNestedScroll(target, type)
    }

    override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
        motionLayout.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type)
    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        motionLayout.onNestedPreScroll(target, dx, dy, consumed, type)
    }
}