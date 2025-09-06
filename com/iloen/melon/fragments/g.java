package com.iloen.melon.fragments;

import android.view.View.OnLongClickListener;
import android.view.View;
import com.melon.net.res.common.SongInfoBase;

public final class g implements View.OnLongClickListener {
    public final SongInfoBase a;
    public final DetailAdapter b;
    public final DetailSongMetaContentBaseFragment c;
    public final int d;

    public g(DetailAdapter detailSongMetaContentBaseFragment$DetailAdapter0, DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, int v, SongInfoBase songInfoBase0) {
        this.a = songInfoBase0;
        this.b = detailSongMetaContentBaseFragment$DetailAdapter0;
        this.c = detailSongMetaContentBaseFragment0;
        this.d = v;
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        return DetailAdapter.onBindViewImpl$lambda$8$lambda$7$lambda$1(this.a, this.b, this.c, this.d, view0);
    }
}

