package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

public final class e0 extends LinearSmoothScroller {
    public final f0 a;

    public e0(f0 f00, Context context0) {
        this.a = f00;
        super(context0);
    }

    @Override  // androidx.recyclerview.widget.LinearSmoothScroller
    public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics0) {
        return 100.0f / ((float)displayMetrics0.densityDpi);
    }

    @Override  // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateTimeForScrolling(int v) {
        return Math.min(100, super.calculateTimeForScrolling(v));
    }

    @Override  // androidx.recyclerview.widget.LinearSmoothScroller
    public final void onTargetFound(View view0, K0 k00, H0 h00) {
        int[] arr_v = this.a.b(this.a.a.getLayoutManager(), view0);
        int v = arr_v[0];
        int v1 = arr_v[1];
        int v2 = this.calculateTimeForDeceleration(Math.max(Math.abs(v), Math.abs(v1)));
        if(v2 > 0) {
            h00.a = v;
            h00.b = v1;
            h00.c = v2;
            h00.e = this.mDecelerateInterpolator;
            h00.f = true;
        }
    }
}

