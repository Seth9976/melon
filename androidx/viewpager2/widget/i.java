package androidx.viewpager2.widget;

import B6.f;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.D0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import d2.d;

public final class i extends LinearLayoutManager {
    public final ViewPager2 a;

    public i(ViewPager2 viewPager20, Context context0) {
        this.a = viewPager20;
        super(context0);
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final void calculateExtraLayoutSpace(K0 k00, int[] arr_v) {
        ViewPager2 viewPager20 = this.a;
        int v = viewPager20.getOffscreenPageLimit();
        if(v == -1) {
            super.calculateExtraLayoutSpace(k00, arr_v);
            return;
        }
        int v1 = viewPager20.getPageSize() * v;
        arr_v[0] = v1;
        arr_v[1] = v1;
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final void onInitializeAccessibilityNodeInfo(D0 d00, K0 k00, d d0) {
        super.onInitializeAccessibilityNodeInfo(d00, k00, d0);
        this.a.E.getClass();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onInitializeAccessibilityNodeInfoForItem(D0 d00, K0 k00, View view0, d d0) {
        ViewPager2 viewPager20 = (ViewPager2)this.a.E.d;
        int v = 0;
        int v1 = viewPager20.getOrientation() == 1 ? viewPager20.g.getPosition(view0) : 0;
        if(viewPager20.getOrientation() == 0) {
            v = viewPager20.g.getPosition(view0);
        }
        d0.n(f.c(v1, 1, v, 1, false, false));
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean performAccessibilityAction(D0 d00, K0 k00, int v, Bundle bundle0) {
        this.a.E.getClass();
        return super.performAccessibilityAction(d00, k00, v, bundle0);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView0, View view0, Rect rect0, boolean z, boolean z1) {
        return false;
    }
}

