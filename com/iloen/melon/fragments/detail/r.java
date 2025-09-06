package com.iloen.melon.fragments.detail;

import android.view.View.OnClickListener;
import android.view.View;

public final class r implements View.OnClickListener {
    public final int a;
    public final LyricHighLightShareFragment b;
    public final BgData c;
    public final ItemViewHolder d;
    public final String e;

    public r(int v, LyricHighLightShareFragment lyricHighLightShareFragment0, BgData lyricHighLightShareFragment$BgData0, ItemViewHolder lyricHighLightShareFragment$BgInnerAdapter$ItemViewHolder0, String s) {
        this.a = v;
        this.b = lyricHighLightShareFragment0;
        this.c = lyricHighLightShareFragment$BgData0;
        this.d = lyricHighLightShareFragment$BgInnerAdapter$ItemViewHolder0;
        this.e = s;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        ItemViewHolder.bindItem$lambda$8(this.a, this.b, this.c, this.d, this.e, view0);
    }
}

