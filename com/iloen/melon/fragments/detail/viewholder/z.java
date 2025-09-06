package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.RelatContsInfo.RelatContsList;

public final class z implements View.OnClickListener {
    public final int a;
    public final ItemViewHolder b;
    public final RelatContsList c;
    public final int d;

    public z(ItemViewHolder relateContentsHolder$ItemViewHolder0, RelatContsList castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, int v, int v1) {
        this.a = v1;
        this.b = relateContentsHolder$ItemViewHolder0;
        this.c = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            ItemViewHolder.bind$lambda$2(this.b, this.c, this.d, view0);
            return;
        }
        ItemViewHolder.bind$lambda$1(this.b, this.c, this.d, view0);
    }
}

