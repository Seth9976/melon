package com.iloen.melon.fragments.webview;

import android.net.Uri;
import co.ab180.airbridge.common.OnFailure;
import co.ab180.airbridge.common.OnSuccess;
import ie.H;

public final class c implements OnFailure, OnSuccess {
    public final int a;
    public final Uri b;

    public c(Uri uri0, int v) {
        this.a = v;
        this.b = uri0;
        super();
    }

    @Override  // co.ab180.airbridge.common.Callback
    public final void invoke(Object object0) {
        if(this.a != 0) {
            MelonWebViewFragment.lambda$shouldOverrideUrlLoading$6(this.b, ((Throwable)object0));
            return;
        }
        MelonWebViewFragment.lambda$shouldOverrideUrlLoading$5(this.b, ((H)object0));
    }
}

