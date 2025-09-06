package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class UnregisterListenerMethod {
    private final ListenerKey zaa;

    @KeepForSdk
    public UnregisterListenerMethod(ListenerKey listenerHolder$ListenerKey0) {
        this.zaa = listenerHolder$ListenerKey0;
    }

    @KeepForSdk
    public ListenerKey getListenerKey() {
        return this.zaa;
    }

    @KeepForSdk
    public abstract void unregisterListener(AnyClient arg1, TaskCompletionSource arg2);
}

