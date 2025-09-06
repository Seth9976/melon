package com.iloen.melon.fragments.melontv.program;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.melon.net.res.common.SongInfoBase;

public final class h implements View.OnClickListener {
    public final int a;
    public final int b;
    public final int c;
    public final MetaContentBaseFragment d;
    public final p e;
    public final Object f;

    public h(MetaContentBaseFragment metaContentBaseFragment0, int v, p p0, int v1, SongInfoBase songInfoBase0, int v2) {
        this.a = v2;
        this.d = metaContentBaseFragment0;
        this.b = v;
        this.e = p0;
        this.c = v1;
        this.f = songInfoBase0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            TvProgramRelativeSongAdapter.onBindViewImpl$lambda$0(((TvProgramMoreSongFragment)this.d), this.b, ((TvProgramRelativeSongAdapter)this.e), this.c, ((SongInfoBase)this.f), view0);
            return;
        }
        TvProgramHomeAdapter.l(((TvProgramHomeFragment)this.d), this.b, ((TvProgramHomeAdapter)this.e), this.c, this.f, view0);
    }
}

