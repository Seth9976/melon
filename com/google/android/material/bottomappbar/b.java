package com.google.android.material.bottomappbar;

import android.animation.AnimatorSet;
import android.view.View;
import c2.B0;
import com.google.android.material.internal.D;
import com.google.android.material.internal.E;

public final class b implements D {
    public final BottomAppBar a;

    public b(BottomAppBar bottomAppBar0) {
        this.a = bottomAppBar0;
        super();
    }

    @Override  // com.google.android.material.internal.D
    public B0 k(View view0, B0 b00, E e0) {
        boolean z;
        BottomAppBar bottomAppBar0 = this.a;
        if(bottomAppBar0.F0) {
            bottomAppBar0.L0 = b00.a();
        }
        int v = 1;
        int v1 = 0;
        if(bottomAppBar0.G0) {
            z = bottomAppBar0.N0 != b00.b();
            bottomAppBar0.N0 = b00.b();
        }
        else {
            z = false;
        }
        if(bottomAppBar0.H0) {
            if(bottomAppBar0.M0 == b00.c()) {
                v = 0;
            }
            bottomAppBar0.M0 = b00.c();
            v1 = v;
        }
        if(!z && v1 == 0) {
            return b00;
        }
        AnimatorSet animatorSet0 = bottomAppBar0.w0;
        if(animatorSet0 != null) {
            animatorSet0.cancel();
        }
        AnimatorSet animatorSet1 = bottomAppBar0.v0;
        if(animatorSet1 != null) {
            animatorSet1.cancel();
        }
        bottomAppBar0.I();
        bottomAppBar0.H();
        return b00;
    }
}

