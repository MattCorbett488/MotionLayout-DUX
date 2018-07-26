package com.willowtree.matthewcorbett.motionlayoutdux.activities

import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.willowtree.matthewcorbett.motionlayoutdux.R
import com.willowtree.matthewcorbett.motionlayoutdux.fragments.FirstFragment
import com.willowtree.matthewcorbett.motionlayoutdux.fragments.SecondFragment

import kotlinx.android.synthetic.main.activity_fragment_transition.*

class FragmentTransitionActivity : AppCompatActivity(), MotionLayout.TransitionListener {

    var lastProgress = 0f

    var fragment : Fragment? = null
    var last : Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_transition)

        if (savedInstanceState == null) {
            fragment = FirstFragment.newInstance()
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commitNow()
        }

        motionLayout.setTransitionListener(this)
    }

    /**
     * startId - the ID of the start state/ConstraintSet (-1 if unknown)
     * endId - the ID of the end state/ConstraintSet
     * progress - the progress on the transition, from 0 to 1
     */
    override fun onTransitionChange(motionLayout: MotionLayout?, startId: Int, endId: Int, progress: Float) {
        if (progress - lastProgress > 0) {
            // from start to end
            val atEnd = Math.abs(progress - 1f) < 0.1f
            if (atEnd && fragment is FirstFragment) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction
                        .setCustomAnimations(R.animator.show, 0)
                fragment = SecondFragment.newInstance()
                transaction
                        .replace(R.id.container, fragment)
                        .commitNow()
            }
        } else {
            // from end to start
            val atStart = progress < 0.9f
            if (atStart && fragment is SecondFragment) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction
                        .setCustomAnimations(0, R.animator.hide)
                fragment = FirstFragment.newInstance()
                transaction
                        .replace(R.id.container, fragment)
                        .commitNow()
            }
        }
        lastProgress = progress
    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {}
}
