package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzec implements OnTokenCanceledListener {
    private final zzdz zza;
    private final ListenerKey zzb;

    public zzec(zzdz zzdz0, ListenerKey listenerHolder$ListenerKey0) {
        this.zza = zzdz0;
        this.zzb = listenerHolder$ListenerKey0;
    }

    @Override  // com.google.android.gms.tasks.OnTokenCanceledListener
    public final void onCanceled() {
        try {
            TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
            this.zza.zzw(this.zzb, true, taskCompletionSource0);
        }
        catch(RemoteException unused_ex) {
        }
    }
}

