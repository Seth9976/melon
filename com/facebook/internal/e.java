package com.facebook.internal;

import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;

public final class e implements Callback {
    public final GraphMeRequestWithCacheCallback a;
    public final String b;

    public e(String s, GraphMeRequestWithCacheCallback utility$GraphMeRequestWithCacheCallback0) {
        this.a = utility$GraphMeRequestWithCacheCallback0;
        this.b = s;
    }

    @Override  // com.facebook.GraphRequest$Callback
    public final void onCompleted(GraphResponse graphResponse0) {
        Utility.getGraphMeRequestWithCacheAsync$lambda$3(this.a, this.b, graphResponse0);
    }
}

