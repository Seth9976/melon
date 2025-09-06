package com.iloen.melon.fragments.newmusic;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v4x.response.NewAlbumListRes;
import v9.i;

public final class a implements ErrorListener, Listener {
    public final NewAlbumFragment a;
    public final i b;
    public final NewAlbumAdapter c;

    public a(NewAlbumFragment newAlbumFragment0, i i0, NewAlbumAdapter newAlbumFragment$NewAlbumAdapter0) {
        this.a = newAlbumFragment0;
        this.b = i0;
        this.c = newAlbumFragment$NewAlbumAdapter0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        NewAlbumFragment.requestMyList$lambda$3(this.a, this.b, this.c, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        NewAlbumFragment.requestMyList$lambda$2(this.a, this.b, this.c, ((NewAlbumListRes)object0));
    }
}

