package com.facebook;

import java.util.concurrent.Callable;

public final class f implements Callable {
    @Override
    public final Object call() {
        return FacebookSdk.sdkInitialize$lambda$3();
    }
}

