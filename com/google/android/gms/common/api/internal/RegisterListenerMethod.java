package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class RegisterListenerMethod {
    private final ListenerHolder zaa;
    private final Feature[] zab;
    private final boolean zac;
    private final int zad;

    @KeepForSdk
    public RegisterListenerMethod(ListenerHolder listenerHolder0) {
        this(listenerHolder0, null, false, 0);
    }

    @KeepForSdk
    public RegisterListenerMethod(ListenerHolder listenerHolder0, Feature[] arr_feature, boolean z) {
        this(listenerHolder0, arr_feature, z, 0);
    }

    @KeepForSdk
    public RegisterListenerMethod(ListenerHolder listenerHolder0, Feature[] arr_feature, boolean z, int v) {
        this.zaa = listenerHolder0;
        this.zab = arr_feature;
        this.zac = z;
        this.zad = v;
    }

    @KeepForSdk
    public void clearListener() {
        this.zaa.clear();
    }

    @KeepForSdk
    public ListenerKey getListenerKey() {
        return this.zaa.getListenerKey();
    }

    @KeepForSdk
    public Feature[] getRequiredFeatures() {
        return this.zab;
    }

    @KeepForSdk
    public abstract void registerListener(AnyClient arg1, TaskCompletionSource arg2);

    public final int zaa() {
        return this.zad;
    }

    public final boolean zab() {
        return this.zac;
    }
}

