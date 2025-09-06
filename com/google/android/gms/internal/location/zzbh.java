package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbh implements RemoteCall, zzdr {
    final zzbi zza;
    private final zzbg zzb;
    private ListenerHolder zzc;
    private boolean zzd;

    public zzbh(zzbi zzbi0, ListenerHolder listenerHolder0, zzbg zzbg0) {
        this.zza = zzbi0;
        super();
        this.zzd = true;
        this.zzc = listenerHolder0;
        this.zzb = zzbg0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        boolean z;
        ListenerKey listenerHolder$ListenerKey0;
        synchronized(this) {
            listenerHolder$ListenerKey0 = this.zzc.getListenerKey();
            z = this.zzd;
            this.zzc.clear();
        }
        if(listenerHolder$ListenerKey0 == null) {
            ((TaskCompletionSource)object1).setResult(Boolean.FALSE);
            return;
        }
        this.zzb.zza(((zzdz)object0), listenerHolder$ListenerKey0, z, ((TaskCompletionSource)object1));
    }

    @Override  // com.google.android.gms.internal.location.zzdr
    public final ListenerHolder zza() {
        synchronized(this) {
        }
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.location.zzdr
    public final void zzb(ListenerHolder listenerHolder0) {
        synchronized(this) {
            ListenerHolder listenerHolder1 = this.zzc;
            if(listenerHolder1 != listenerHolder0) {
                listenerHolder1.clear();
                this.zzc = listenerHolder0;
            }
        }
    }

    @Override  // com.google.android.gms.internal.location.zzdr
    public final void zzc() {
        ListenerKey listenerHolder$ListenerKey0;
        synchronized(this) {
            this.zzd = false;
            listenerHolder$ListenerKey0 = this.zzc.getListenerKey();
        }
        if(listenerHolder$ListenerKey0 != null) {
            this.zza.doUnregisterEventListener(listenerHolder$ListenerKey0, 0x989);
        }
    }
}

