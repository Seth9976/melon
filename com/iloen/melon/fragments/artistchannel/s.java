package com.iloen.melon.fragments.artistchannel;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

public final class s implements ErrorListener {
    public final int a;

    public s(int v) {
        this.a = v;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public final void onErrorResponse(VolleyError volleyError0) {
        switch(this.a) {
            case 0: {
                RelatedArtistHolder.bind$lambda$5(volleyError0);
                return;
            }
            case 1: {
                com.iloen.melon.fragments.artistchannel.ArtistPickItemFragment.requestUserActionApi.2.invokeSuspend$lambda$4$lambda$3(volleyError0);
                return;
            }
            case 2: {
                ArtistDetailContentsTopicFragment.fetchTopicLike$lambda$20(volleyError0);
                return;
            }
            case 3: {
                ArtistDetailFanListFragment.getFollowYNInfoFromServer$lambda$4(volleyError0);
                return;
            }
            default: {
                ArtistDetailMemorialCardFragment.registerCardRelay$lambda$20(volleyError0);
            }
        }
    }
}

