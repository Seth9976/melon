package com.google.android.material.appbar;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;

public abstract class j {
    public static final int[] a;

    static {
        j.a = new int[]{0x1010448};
    }

    public static void a(AppBarLayout appBarLayout0, float f) {
        int v = appBarLayout0.getResources().getInteger(0x7F0B0002);  // integer:app_bar_elevation_anim_duration
        StateListAnimator stateListAnimator0 = new StateListAnimator();
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(appBarLayout0, "elevation", new float[]{0.0f}).setDuration(((long)v));
        stateListAnimator0.addState(new int[]{0x101009E, 0x7F0405A1, 0x80FBFA5E}, objectAnimator0);  // attr:state_liftable
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(appBarLayout0, "elevation", new float[]{f}).setDuration(((long)v));
        stateListAnimator0.addState(new int[]{0x101009E}, objectAnimator1);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(appBarLayout0, "elevation", new float[]{0.0f}).setDuration(0L);
        stateListAnimator0.addState(new int[0], objectAnimator2);
        appBarLayout0.setStateListAnimator(stateListAnimator0);
    }
}

