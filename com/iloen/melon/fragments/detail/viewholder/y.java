package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.CastList;

public final class y implements View.OnClickListener {
    public final int a;
    public final RecommendCastHolder b;
    public final CastList c;
    public final int d;

    public y(RecommendCastHolder recommendCastHolder0, CastList castEpsdDetailRes$Response$CastList0, int v, int v1) {
        this.a = v1;
        this.b = recommendCastHolder0;
        this.c = castEpsdDetailRes$Response$CastList0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            RecommendCastHolder.bindItem$lambda$4$lambda$3(this.b, this.c, this.d, view0);
            return;
        }
        RecommendCastHolder.bindItem$lambda$4$lambda$2(this.b, this.c, this.d, view0);
    }
}

