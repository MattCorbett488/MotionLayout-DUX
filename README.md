# MotionLayout DUX

Hi! This repo is meant as a fun way for developers and designers to experience the beauty and wonder that is MotionLayout.  There are 4 primary ways we're going to interact with MotionLayout - do all of 'em or just mess around with one.

Basically all the really impressive stuff from this repo is copied and slightly modified from the wonderful [Google ConstraintLayout Examples](https://github.com/googlesamples/android-ConstraintLayoutExamples)

## Fragment Transition

This one is pretty neat.  We have two fragments (`FirstFragment` and `SecondFragment`).  Via the `FragmentTransitionActivity`, these two fragments transition between one another by swiping the container held in the Activity.  If you want to mess around with transitioning between a bunch of different elements on screens, just start messing with the `fragment_first.xml` and `fragment_second.xml` files


## AppBar Layout

AppBarLayout can be pretty fun, but somewhat limited.  MotionLayout gives us the ability to customize the behavior a bit more.  To mess with the AppBarLayout, look at the following files:

`CollapsibleToolbar` - you shouldn't need to mess with this, but it's what hooks the AppBarLayout into the MotionLayout and lets us update our MotionScene progress as the AppBarLayout scrolls

`app_bar_header.xml` - this is the layout file that defines what elements are in that app bar at the top.  Change these around if you want to change how things animate

`app_bar_scene.xml` - this is the MotionScene for `app_bar_header` and controls how it animates from 0 to 100. After updating the widgets in the `app_bar_header` layout file, you can update them in the start and end ConstraintSets to fix how they move.  You can also just keep the widgets as is and manipulate them in different ways (scale, rotation, etc)


## ViewPager Layout

Some of the magic in MotionLayout is what we can do with its `progress` attribute.  This is an attribute from 0 to 1 (float value) that gives us the percentage completion of the MotionLayout transition.  We can use this for some pretty unique listeners. In this example, we're tying our progress to a ViewPager PageChangedListener.

Look at the following files to make changes to the ViewPager setup:

`ViewPagerHeader` - this is a MotionLayout that implements our PageChangedListener.  You probably won't need to mess with this file unless you want to change how the progress is calculated with the page changing

`viewpager_header.xml` - the layout file our view pager is tied to; change this if you want to make the page change look different (you'll need to edit the corresponding MotionScene - `view_pager_scene.xml`)

`view_pager_scene.xml` - the MotionScene that describes the start and end states of the ViewPagerHeader.  You'll need to add/remove Constraints here as you add/remove them in the corresponding layout file

There are also a couple bonus classes here.  The ViewPagerHeader can work with Lottie as well, so, if you want to mess with that, just replace `<include layout="@layout/viewpager_header" />` in `activity_view_pager.xml` with `<include layout="@layout/viewpager_header_lottie" />`

