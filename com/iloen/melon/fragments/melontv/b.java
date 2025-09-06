package com.iloen.melon.fragments.melontv;

import com.android.volley.Response.Listener;
import com.iloen.melon.net.v4x.response.MelonTvLiveListRes;
import com.iloen.melon.net.v4x.response.MelonTvMvListRes;
import com.iloen.melon.net.v4x.response.MelonTvPopListRes;
import com.iloen.melon.net.v5x.response.MelonTvNewMvListRes;
import v9.i;

public final class b implements Listener {
    public final int a;
    public final i b;
    public final MelonTvBaseFragment c;

    public b(MelonTvBaseFragment melonTvBaseFragment0, i i0, int v) {
        this.a = v;
        this.c = melonTvBaseFragment0;
        this.b = i0;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        switch(this.a) {
            case 0: {
                ((MelonTvLiveFragment)this.c).lambda$onFetchStart$0(this.b, ((MelonTvLiveListRes)object0));
                return;
            }
            case 1: {
                ((MelonTvMusicVideoFragment)this.c).lambda$onFetchStart$0(this.b, ((MelonTvMvListRes)object0));
                return;
            }
            case 2: {
                MelonTvNewFragment.onFetchStart$lambda$1(((MelonTvNewFragment)this.c), this.b, ((MelonTvNewMvListRes)object0));
                return;
            }
            default: {
                ((MelonTvPopularFragment)this.c).lambda$onFetchStart$0(this.b, ((MelonTvPopListRes)object0));
            }
        }
    }
}

