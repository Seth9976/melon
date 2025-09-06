package com.iloen.melon.fragments;

import android.view.View.OnClickListener;
import android.view.View;
import com.melon.net.res.common.SongInfoBase;

public final class h implements View.OnClickListener {
    public final int a;
    public final DetailSongMetaContentBaseFragment b;
    public final SongInfoBase c;
    public final DetailAdapter d;
    public final int e;
    public final String f;

    public h(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, DetailAdapter detailSongMetaContentBaseFragment$DetailAdapter0, int v, SongInfoBase songInfoBase0, String s) {
        this.a = 0;
        super();
        this.b = detailSongMetaContentBaseFragment0;
        this.d = detailSongMetaContentBaseFragment$DetailAdapter0;
        this.e = v;
        this.c = songInfoBase0;
        this.f = s;
    }

    public h(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, SongInfoBase songInfoBase0, DetailAdapter detailSongMetaContentBaseFragment$DetailAdapter0, int v, String s) {
        this.a = 1;
        super();
        this.b = detailSongMetaContentBaseFragment0;
        this.c = songInfoBase0;
        this.d = detailSongMetaContentBaseFragment$DetailAdapter0;
        this.e = v;
        this.f = s;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            DetailAdapter.f(this.b, this.d, this.e, this.c, this.f, view0);
            return;
        }
        DetailAdapter.onBindViewImpl$lambda$8$lambda$7$lambda$2(this.b, this.d, this.e, this.c, this.f, view0);
    }
}

