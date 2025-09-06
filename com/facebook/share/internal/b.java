package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.Callback;

public final class b implements Callback {
    public final int a;

    public b(int v) {
        this.a = v;
    }

    @Override  // com.facebook.internal.CallbackManagerImpl$Callback
    public final boolean onActivityResult(int v, Intent intent0) {
        return ShareInternalUtility.registerStaticShareCallback$lambda$0(this.a, v, intent0);
    }
}

