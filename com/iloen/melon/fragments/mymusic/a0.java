package com.iloen.melon.fragments.mymusic;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.iloen.melon.custom.J;
import com.iloen.melon.custom.S;

public final class a0 implements ErrorListener, J {
    public final OtherMusicLikedSongFragment a;

    public a0(OtherMusicLikedSongFragment otherMusicLikedSongFragment0) {
        this.a = otherMusicLikedSongFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.J
    public void a(S s0, boolean z) {
        OtherMusicLikedSongFragment.initHeaderView$lambda$2(this.a, s0, z);
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        OtherMusicLikedSongFragment.onFetchStart$lambda$11(this.a, volleyError0);
    }
}

