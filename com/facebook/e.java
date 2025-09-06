package com.facebook;

import com.facebook.internal.FeatureManager.Callback;

public final class e implements Callback {
    public final String a;

    public e(String s) {
        this.a = s;
    }

    @Override  // com.facebook.internal.FeatureManager$Callback
    public final void onCompleted(boolean z) {
        FacebookException._init_$lambda$0(this.a, z);
    }
}

