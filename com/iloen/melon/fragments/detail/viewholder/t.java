package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.CastList;

public final class t implements View.OnClickListener {
    public final int a;
    public final OtherCastHolder b;
    public final CastList c;
    public final int d;

    public t(OtherCastHolder otherCastHolder0, CastList castEpsdDetailRes$Response$CastList0, int v, int v1) {
        this.a = v1;
        this.b = otherCastHolder0;
        this.c = castEpsdDetailRes$Response$CastList0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            InnerRecyclerAdapter.onBindViewHolder$lambda$2$lambda$1(this.b, this.c, this.d, view0);
            return;
        }
        InnerRecyclerAdapter.onBindViewHolder$lambda$2$lambda$0(this.b, this.c, this.d, view0);
    }
}

