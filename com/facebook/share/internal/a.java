package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.internal.CallbackManagerImpl.Callback;

public final class a implements Callback {
    public final int a;
    public final FacebookCallback b;

    public a(int v, FacebookCallback facebookCallback0) {
        this.a = v;
        this.b = facebookCallback0;
    }

    @Override  // com.facebook.internal.CallbackManagerImpl$Callback
    public final boolean onActivityResult(int v, Intent intent0) {
        return ShareInternalUtility.registerSharerCallback$lambda$1(this.a, this.b, v, intent0);
    }
}

