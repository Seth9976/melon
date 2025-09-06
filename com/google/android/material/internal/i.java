package com.google.android.material.internal;

import B6.f;
import android.view.View;
import c2.b;
import d2.d;

public final class i extends b {
    public final int a;
    public final boolean b;
    public final j c;

    public i(j j0, int v, boolean z) {
        this.c = j0;
        this.a = v;
        this.b = z;
        super();
    }

    @Override  // c2.b
    public final void onInitializeAccessibilityNodeInfo(View view0, d d0) {
        super.onInitializeAccessibilityNodeInfo(view0, d0);
        r r0 = this.c.d;
        int v = this.a;
        int v2 = v;
        for(int v1 = 0; v1 < v; ++v1) {
            switch(r0.e.getItemViewType(v1)) {
                case 2: 
                case 3: {
                    --v2;
                }
            }
        }
        boolean z = view0.isSelected();
        d0.n(f.c(v2, 1, 1, 1, this.b, z));
    }
}

