package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.D0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.H;
import androidx.recyclerview.widget.K0;
import com.iloen.melon.utils.log.LogU;

public class DetailGridLayoutManager extends GridLayoutManager implements z {
    public int m;
    public boolean n;

    public DetailGridLayoutManager(Context context0, int v) {
        super(context0, v);
        this.m = 1000;
        this.n = false;
    }

    public DetailGridLayoutManager(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.m = 1000;
        this.n = false;
    }

    @Override  // com.iloen.melon.custom.z
    public final void g(int v) {
        this.m = v;
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final int getExtraLayoutSpace(K0 k00) {
        return this.m;
    }

    @Override  // com.iloen.melon.custom.z
    public final int h(int v, int v1) {
        int v5;
        int v2 = this.b;
        int v3 = -1;
        if(v2 < 1) {
            LogU.e("DetailGridLayoutManager", "Invalid span count");
            return -1;
        }
        H h0 = this.g;
        for(int v4 = 0; v4 < v; v4 += v5) {
            View view0 = this.findViewByPosition(v4);
            if(v4 != 0 || view0 != null) {
                if(view0 != null) {
                    v3 += this.getDecoratedMeasuredHeight(view0);
                }
                v5 = v2 - h0.getSpanSize(v4) + 1;
                if(v5 < 1) {
                    return v3;
                }
            }
            else {
                v3 = v1;
                v5 = 1;
            }
        }
        return v3;
    }

    @Override  // com.iloen.melon.custom.z
    public final boolean l() {
        return this.n;
    }

    @Override  // androidx.recyclerview.widget.GridLayoutManager
    public final void onLayoutChildren(D0 d00, K0 k00) {
        super.onLayoutChildren(d00, k00);
        this.n = true;
    }
}

