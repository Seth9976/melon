package com.iloen.melon.fragments;

import android.view.View.OnClickListener;
import android.view.View;
import com.melon.net.res.common.SongInfoBase;

public final class f implements View.OnClickListener {
    public final DetailSongMetaContentBaseFragment a;
    public final int b;
    public final String c;
    public final int d;
    public final SongInfoBase e;

    public f(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, int v, String s, int v1, SongInfoBase songInfoBase0) {
        this.a = detailSongMetaContentBaseFragment0;
        this.b = v;
        this.c = s;
        this.d = v1;
        this.e = songInfoBase0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        DetailAdapter.onBindViewImpl$lambda$8$lambda$7$lambda$0(this.a, this.b, this.c, this.d, this.e, view0);
    }
}

