package com.iloen.melon.fragments.melontv.program;

import android.view.View.OnLongClickListener;
import android.view.View;
import com.melon.net.res.common.SongInfoBase;

public final class q implements View.OnLongClickListener {
    public final TvProgramMoreSongFragment a;
    public final SongInfoBase b;
    public final TvProgramRelativeSongAdapter c;

    public q(TvProgramMoreSongFragment tvProgramMoreSongFragment0, SongInfoBase songInfoBase0, TvProgramRelativeSongAdapter tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0) {
        this.a = tvProgramMoreSongFragment0;
        this.b = songInfoBase0;
        this.c = tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0;
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        return TvProgramRelativeSongAdapter.onBindViewImpl$lambda$1(this.a, this.b, this.c, view0);
    }
}

