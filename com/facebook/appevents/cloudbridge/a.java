package com.facebook.appevents.cloudbridge;

import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.appevents.codeless.ViewIndexer.Companion;

public final class a implements Callback {
    public final int a;

    public a(int v) {
        this.a = v;
        super();
    }

    @Override  // com.facebook.GraphRequest$Callback
    public final void onCompleted(GraphResponse graphResponse0) {
        if(this.a != 0) {
            Companion.a(graphResponse0);
            return;
        }
        AppEventsCAPIManager.enable$lambda$0(graphResponse0);
    }
}

