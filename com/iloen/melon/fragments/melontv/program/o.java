package com.iloen.melon.fragments.melontv.program;

import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.iloen.melon.fragments.FetcherBaseFragment;
import com.iloen.melon.net.v6x.response.ProgramMoreMvRes;
import com.iloen.melon.net.v6x.response.ProgramMoreSongRes;
import v9.i;

public final class o implements Listener {
    public final int a;
    public final i b;
    public final j0 c;
    public final FetcherBaseFragment d;

    public o(FetcherBaseFragment fetcherBaseFragment0, i i0, j0 j00, int v) {
        this.a = v;
        this.d = fetcherBaseFragment0;
        this.b = i0;
        this.c = j00;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        if(this.a != 0) {
            TvProgramMoreVideoFragment.request$lambda$12$lambda$10(((TvProgramMoreVideoFragment)this.d), this.b, this.c, ((ProgramMoreMvRes)object0));
            return;
        }
        TvProgramMoreSongFragment.request$lambda$12$lambda$10(((TvProgramMoreSongFragment)this.d), this.b, this.c, ((ProgramMoreSongRes)object0));
    }
}

