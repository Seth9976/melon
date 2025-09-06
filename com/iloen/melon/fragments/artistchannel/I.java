package com.iloen.melon.fragments.artistchannel;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicListRes;
import com.iloen.melon.net.v6x.response.ArtistContentsListLikeAndCmtRes;
import java.util.List;

public final class i implements ErrorListener, Listener {
    public final ArtistDetailContentsTopicFragment a;
    public final v9.i b;
    public final ArtistContentsArtistTopicListRes c;
    public final List d;

    public i(ArtistDetailContentsTopicFragment artistDetailContentsTopicFragment0, v9.i i0, ArtistContentsArtistTopicListRes artistContentsArtistTopicListRes0, List list0) {
        this.a = artistDetailContentsTopicFragment0;
        this.b = i0;
        this.c = artistContentsArtistTopicListRes0;
        this.d = list0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        ArtistDetailContentsTopicFragment.fetchLikeAndCmt$lambda$14(this.a, this.b, this.c, this.d, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        ArtistDetailContentsTopicFragment.fetchLikeAndCmt$lambda$13(this.a, this.b, this.c, this.d, ((ArtistContentsListLikeAndCmtRes)object0));
    }
}

