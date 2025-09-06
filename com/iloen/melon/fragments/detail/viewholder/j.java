package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.DetailBaseRes.STATION;

public final class j implements View.OnClickListener {
    public final int a;
    public final DetailContentsCastItemHolder b;
    public final STATION c;
    public final int d;

    public j(DetailContentsCastItemHolder detailContentsCastItemHolder0, STATION detailBaseRes$STATION0, int v, int v1) {
        this.a = v1;
        this.b = detailContentsCastItemHolder0;
        this.c = detailBaseRes$STATION0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            DetailContentsCastItemHolder.bind$lambda$3(this.b, this.c, this.d, view0);
            return;
        }
        DetailContentsCastItemHolder.bind$lambda$2(this.b, this.c, this.d, view0);
    }
}

