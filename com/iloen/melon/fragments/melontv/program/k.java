package com.iloen.melon.fragments.melontv.program;

import a9.d;
import com.android.volley.Response.Listener;
import com.iloen.melon.fragments.FetcherBaseFragment;
import com.iloen.melon.net.v6x.response.ProgramMoreAlbumRes;
import java.util.List;
import v9.i;

public final class k implements d, Listener {
    public final int a;
    public final FetcherBaseFragment b;
    public final Object c;

    public k(FetcherBaseFragment fetcherBaseFragment0, Object object0, int v) {
        this.a = v;
        this.b = fetcherBaseFragment0;
        this.c = object0;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        TvProgramMoreAlbumFragment.request$lambda$1(((TvProgramMoreAlbumFragment)this.b), ((i)this.c), ((ProgramMoreAlbumRes)object0));
    }

    @Override  // a9.d
    public void onSelected(int v) {
        if(this.a != 0) {
            TvProgramMoreVideoFragment.onViewCreated$lambda$5$lambda$4$lambda$3(((TvProgramMoreVideoFragment)this.b), ((List)this.c), v);
            return;
        }
        FilterViewHolder.lambda$2$lambda$1$lambda$0(((TvProgramMoreAlbumFragment)this.b), ((FilterViewHolder)this.c), v);
    }
}

