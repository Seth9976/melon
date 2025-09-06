package com.iloen.melon.custom;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.D0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;

public class DetailLinearLayoutManager extends LinearLayoutManager implements z {
    public int a;
    public boolean b;

    public DetailLinearLayoutManager(Context context0) {
        super(1, false);
        this.a = 1000;
        this.b = false;
    }

    @Override  // com.iloen.melon.custom.z
    public final void g(int v) {
        this.a = v;
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final int getExtraLayoutSpace(K0 k00) {
        return this.a;
    }

    @Override  // com.iloen.melon.custom.z
    public final int h(int v, int v1) {
        int v2 = -1;
        for(int v3 = 0; v3 < v; ++v3) {
            View view0 = this.findViewByPosition(v3);
            if(v3 == 0 && view0 == null) {
                v2 = v1;
            }
            else if(view0 != null) {
                v2 = this.getDecoratedMeasuredHeight(view0) + v2;
            }
        }
        return v2;
    }

    @Override  // com.iloen.melon.custom.z
    public final boolean l() {
        return this.b;
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final void onLayoutChildren(D0 d00, K0 k00) {
        super.onLayoutChildren(d00, k00);
        this.b = true;
    }
}

