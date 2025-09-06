package com.iloen.melon.fragments.melontv.program;

import android.view.View.OnClickListener;
import android.view.View;
import com.melon.net.res.common.SongInfoBase;

public final class r implements View.OnClickListener {
    public final int a;
    public final TvProgramMoreSongFragment b;
    public final SongInfoBase c;
    public final TvProgramRelativeSongAdapter d;
    public final int e;

    public r(TvProgramMoreSongFragment tvProgramMoreSongFragment0, SongInfoBase songInfoBase0, TvProgramRelativeSongAdapter tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0, int v, int v1) {
        this.a = v1;
        this.b = tvProgramMoreSongFragment0;
        this.c = songInfoBase0;
        this.d = tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0;
        this.e = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            TvProgramRelativeSongAdapter.onBindViewImpl$lambda$4(this.b, this.c, this.d, this.e, view0);
            return;
        }
        TvProgramRelativeSongAdapter.onBindViewImpl$lambda$2(this.b, this.c, this.d, this.e, view0);
    }
}

