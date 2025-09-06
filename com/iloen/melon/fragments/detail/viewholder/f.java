package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;

public final class f implements View.OnClickListener {
    public final int a;
    public final DetailCommonContentsHolder b;

    public f(DetailCommonContentsHolder detailCommonContentsHolder0, int v) {
        this.a = v;
        this.b = detailCommonContentsHolder0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                DetailCommonContentsHolder.onBindView$lambda$1(this.b, view0);
                return;
            }
            case 1: {
                DetailCommonContentsHolder.onBindView$lambda$2(this.b, view0);
                return;
            }
            case 2: {
                DetailCommonContentsHolder.onBindView$lambda$3(this.b, view0);
                return;
            }
            default: {
                DetailCommonContentsHolder.onBindView$lambda$4(this.b, view0);
            }
        }
    }
}

