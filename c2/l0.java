package c2;

import android.os.Build.VERSION;
import android.view.animation.Interpolator;

public final class l0 {
    public k0 a;

    public l0(int v, Interpolator interpolator0, long v1) {
        if(Build.VERSION.SDK_INT >= 30) {
            this.a = new j0(h0.i(v, interpolator0, v1));
            return;
        }
        this.a = new g0(v, interpolator0, v1);  // 初始化器: Lc2/k0;-><init>(ILandroid/view/animation/Interpolator;J)V
    }
}

