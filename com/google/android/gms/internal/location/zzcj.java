package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcj implements RemoteCall {
    private final ListenerHolder zza;

    public zzcj(ListenerHolder listenerHolder0) {
        this.zza = listenerHolder0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ListenerKey listenerHolder$ListenerKey0 = this.zza.getListenerKey();
        if(listenerHolder$ListenerKey0 != null) {
            ((zzdz)object0).zzD(listenerHolder$ListenerKey0, ((TaskCompletionSource)object1));
        }
    }
}

