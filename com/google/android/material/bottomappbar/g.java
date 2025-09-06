package com.google.android.material.bottomappbar;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View.OnLayoutChangeListener;
import android.view.View;
import androidx.coordinatorlayout.widget.c;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.B;

public final class g implements View.OnLayoutChangeListener {
    public final Behavior a;

    public g(Behavior bottomAppBar$Behavior0) {
        this.a = bottomAppBar$Behavior0;
    }

    @Override  // android.view.View$OnLayoutChangeListener
    public final void onLayoutChange(View view0, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
        Behavior bottomAppBar$Behavior0 = this.a;
        Rect rect0 = bottomAppBar$Behavior0.j;
        BottomAppBar bottomAppBar0 = (BottomAppBar)bottomAppBar$Behavior0.k.get();
        if(bottomAppBar0 != null) {
            int v8 = bottomAppBar0.A0;
            if(view0 instanceof FloatingActionButton || view0 instanceof ExtendedFloatingActionButton) {
                int v9 = view0.getHeight();
                if(view0 instanceof FloatingActionButton) {
                    rect0.set(0, 0, ((FloatingActionButton)view0).getMeasuredWidth(), ((FloatingActionButton)view0).getMeasuredHeight());
                    ((FloatingActionButton)view0).j(rect0);
                    int v10 = rect0.height();
                    bottomAppBar0.J(v10);
                    bottomAppBar0.setFabCornerSize(((FloatingActionButton)view0).getShapeAppearanceModel().e.a(new RectF(rect0)));
                    v9 = v10;
                }
                c c0 = (c)view0.getLayoutParams();
                if(bottomAppBar$Behavior0.l == 0) {
                    if(bottomAppBar0.z0 == 1) {
                        int v11 = view0.getMeasuredHeight();
                        c0.bottomMargin = bottomAppBar0.getBottomInset() + (bottomAppBar0.getResources().getDimensionPixelOffset(0x7F070335) - (v11 - v9) / 2);  // dimen:mtrl_bottomappbar_fab_bottom_margin
                    }
                    c0.leftMargin = bottomAppBar0.getLeftInset();
                    c0.rightMargin = bottomAppBar0.getRightInset();
                    if(B.l(view0)) {
                        c0.leftMargin += v8;
                    }
                    else {
                        c0.rightMargin += v8;
                    }
                }
                bottomAppBar0.I();
                return;
            }
        }
        view0.removeOnLayoutChangeListener(this);
    }
}

