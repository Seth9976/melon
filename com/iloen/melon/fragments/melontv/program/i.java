package com.iloen.melon.fragments.melontv.program;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.playback.Playable;
import com.melon.net.res.common.SongInfoBase;

public final class i implements View.OnClickListener {
    public final int a;
    public final Playable b;
    public final int c;
    public final MetaContentBaseFragment d;
    public final p e;
    public final Object f;

    public i(MetaContentBaseFragment metaContentBaseFragment0, Playable playable0, p p0, int v, SongInfoBase songInfoBase0, int v1) {
        this.a = v1;
        this.d = metaContentBaseFragment0;
        this.b = playable0;
        this.e = p0;
        this.c = v;
        this.f = songInfoBase0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            TvProgramRelativeSongAdapter.onBindViewImpl$lambda$3(((TvProgramMoreSongFragment)this.d), this.b, ((TvProgramRelativeSongAdapter)this.e), this.c, ((SongInfoBase)this.f), view0);
            return;
        }
        TvProgramHomeAdapter.f(((TvProgramHomeFragment)this.d), this.b, ((TvProgramHomeAdapter)this.e), this.c, this.f, view0);
    }
}

