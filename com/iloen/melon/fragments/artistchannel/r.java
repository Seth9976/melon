package com.iloen.melon.fragments.artistchannel;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes;

public final class r implements ErrorListener, Listener {
    public final int a;
    public final Object b;

    public r(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        ArtistDetailContentsTopicFragment.onFetchStart$lambda$8(((ArtistDetailContentsTopicFragment)this.b), volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        switch(this.a) {
            case 0: {
                RelatedArtistHolder.bind$lambda$4(((RelatedArtistHolder)this.b), ((UserActionsRes)object0));
                return;
            }
            case 1: {
                com.iloen.melon.fragments.artistchannel.ArtistPickItemFragment.requestUserActionApi.2.invokeSuspend$lambda$4$lambda$2(((ArtistPickItemFragment)this.b), object0);
                return;
            }
            default: {
                ArtistDetailDetailInfoFragment.onFetchStart$lambda$2(((ArtistDetailDetailInfoFragment)this.b), ((ArtistDetailInfoRes)object0));
            }
        }
    }
}

