package com.iloen.melon.custom;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.jvm.internal.q;
import ud.K;

public final class p extends r0 {
    public final int a;
    public final Object b;

    public p(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // androidx.recyclerview.widget.r0
    public final void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
        if(this.a != 0) {
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(k00, "state");
            K k0 = (K)this.b;
            rect0.top = ScreenUtils.dipToPixel(k0.getContext(), 0.0f);
            rect0.bottom = ScreenUtils.dipToPixel(k0.getContext(), 0.0f);
            int v = recyclerView0.getChildAdapterPosition(view0);
            j0 j00 = recyclerView0.getAdapter();
            q.d(j00);
            if(v == j00.getItemCount() - 1) {
                rect0.bottom = ScreenUtils.dipToPixel(k0.getContext(), 10.0f);
                return;
            }
            if(recyclerView0.getChildAdapterPosition(view0) == 0) {
                rect0.top = ScreenUtils.dipToPixel(k0.getContext(), 10.0f);
            }
            return;
        }
        ControllerVideoListView controllerVideoListView0 = (ControllerVideoListView)this.b;
        q.g(rect0, "outRect");
        q.g(view0, "view");
        q.g(k00, "state");
        int v1 = recyclerView0.getChildAdapterPosition(view0);
        j0 j01 = recyclerView0.getAdapter();
        int v2 = j01 == null ? 0 : j01.getItemCount();
        int v3 = ScreenUtils.dipToPixel(controllerVideoListView0.getContext(), (ScreenUtils.isPortrait(controllerVideoListView0.getContext()) ? 20.0f : 24.0f));
        if(v1 == 0) {
            rect0.left = v3;
            rect0.right = ScreenUtils.dipToPixel(controllerVideoListView0.getContext(), 5.5f);
            return;
        }
        if(v1 == v2 - 1) {
            rect0.left = ScreenUtils.dipToPixel(controllerVideoListView0.getContext(), 5.5f);
            rect0.right = v3;
            return;
        }
        rect0.left = ScreenUtils.dipToPixel(controllerVideoListView0.getContext(), 5.5f);
        rect0.right = ScreenUtils.dipToPixel(controllerVideoListView0.getContext(), 5.5f);
    }
}

