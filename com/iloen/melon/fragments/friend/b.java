package com.iloen.melon.fragments.friend;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

public final class b implements ErrorListener {
    public final int a;
    public final FollowerFragment b;

    public b(FollowerFragment followerFragment0, int v) {
        this.a = v;
        this.b = followerFragment0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public final void onErrorResponse(VolleyError volleyError0) {
        switch(this.a) {
            case 0: {
                FollowerFragment.requestUnHide$lambda$20(this.b, volleyError0);
                return;
            }
            case 1: {
                FollowerFragment.requestHide$lambda$18(this.b, volleyError0);
                return;
            }
            default: {
                FollowerFragment.onFetchStart$lambda$2(this.b, volleyError0);
            }
        }
    }
}

