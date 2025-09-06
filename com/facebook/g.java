package com.facebook;

import java.util.concurrent.Callable;

public final class g implements Callable {
    public final InitializeCallback a;

    public g(InitializeCallback facebookSdk$InitializeCallback0) {
        this.a = facebookSdk$InitializeCallback0;
    }

    @Override
    public final Object call() {
        return FacebookSdk.sdkInitialize$lambda$9(this.a);
    }
}

