package com.facebook;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c implements Callback {
    public final RefreshResult a;
    public final AccessToken b;
    public final AccessTokenRefreshCallback c;
    public final AtomicBoolean d;
    public final HashSet e;
    public final HashSet f;
    public final HashSet g;
    public final AccessTokenManager h;

    public c(RefreshResult accessTokenManager$RefreshResult0, AccessToken accessToken0, AccessTokenRefreshCallback accessToken$AccessTokenRefreshCallback0, AtomicBoolean atomicBoolean0, HashSet hashSet0, HashSet hashSet1, HashSet hashSet2, AccessTokenManager accessTokenManager0) {
        this.a = accessTokenManager$RefreshResult0;
        this.b = accessToken0;
        this.c = accessToken$AccessTokenRefreshCallback0;
        this.d = atomicBoolean0;
        this.e = hashSet0;
        this.f = hashSet1;
        this.g = hashSet2;
        this.h = accessTokenManager0;
    }

    @Override  // com.facebook.GraphRequestBatch$Callback
    public final void onBatchCompleted(GraphRequestBatch graphRequestBatch0) {
        AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$3(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, graphRequestBatch0);
    }
}

