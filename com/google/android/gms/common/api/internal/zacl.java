package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zacl extends UnregisterListenerMethod {
    final Builder zaa;

    public zacl(Builder registrationMethods$Builder0, ListenerKey listenerHolder$ListenerKey0) {
        this.zaa = registrationMethods$Builder0;
        super(listenerHolder$ListenerKey0);
    }

    @Override  // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final void unregisterListener(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) {
        this.zaa.zab.accept(api$AnyClient0, taskCompletionSource0);
    }
}

