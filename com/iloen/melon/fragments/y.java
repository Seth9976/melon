package com.iloen.melon.fragments;

import com.android.volley.Response.Listener;
import com.iloen.melon.net.v5x.response.CastProgramEpsdRes;
import com.iloen.melon.net.v6x.response.DjPlaylistDeleteRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistDeleteRes;
import v9.i;

public final class y implements Listener {
    public final int a;
    public final MetaContentBaseFragment b;
    public final Object c;

    public y(MetaContentBaseFragment metaContentBaseFragment0, Object object0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        this.c = object0;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        switch(this.a) {
            case 0: {
                this.b.lambda$deleteDjPlayList$10(((String)this.c), ((DjPlaylistDeleteRes)object0));
                return;
            }
            case 1: {
                this.b.lambda$deletePlayList$15(((String)this.c), ((MyMusicPlaylistDeleteRes)object0));
                return;
            }
            default: {
                ProgramDetailBottomFragment.onFetchStart$lambda$0(((ProgramDetailBottomFragment)this.b), ((i)this.c), ((CastProgramEpsdRes)object0));
            }
        }
    }
}

