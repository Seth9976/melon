package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout.Behavior;
import com.google.android.material.appbar.AppBarLayout;

public class ScrollBlockBehavior extends Behavior {
    public ScrollBlockBehavior(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    @Override  // com.google.android.material.appbar.HeaderBehavior
    public final boolean k(CoordinatorLayout coordinatorLayout0, View view0, MotionEvent motionEvent0) {
        AppBarLayout appBarLayout0 = (AppBarLayout)view0;
        return false;
    }
}

