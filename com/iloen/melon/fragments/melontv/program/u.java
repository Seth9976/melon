package com.iloen.melon.fragments.melontv.program;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ProgramHomeRes.RESPONSE.PLAYLISTINFO.PLAYLIST;

public final class u implements View.OnClickListener {
    public final int a;
    public final TvProgramRelatedPlaylistHolder b;
    public final PLAYLIST c;
    public final int d;

    public u(TvProgramRelatedPlaylistHolder tvProgramRelatedPlaylistHolder0, PLAYLIST programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0, int v, int v1) {
        this.a = v1;
        this.b = tvProgramRelatedPlaylistHolder0;
        this.c = programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            TvProgramRelatedPlaylistHolder.bindItem$lambda$4$lambda$3$lambda$2(this.b, this.c, this.d, view0);
            return;
        }
        TvProgramRelatedPlaylistHolder.bindItem$lambda$4$lambda$3$lambda$1(this.b, this.c, this.d, view0);
    }
}

