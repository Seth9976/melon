package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;

final class zzaz implements zzdr {
    private ListenerHolder zza;

    public zzaz(ListenerHolder listenerHolder0) {
        this.zza = listenerHolder0;
    }

    @Override  // com.google.android.gms.internal.location.zzdr
    public final ListenerHolder zza() {
        synchronized(this) {
        }
        return this.zza;
    }

    @Override  // com.google.android.gms.internal.location.zzdr
    public final void zzb(ListenerHolder listenerHolder0) {
        synchronized(this) {
            ListenerHolder listenerHolder1 = this.zza;
            if(listenerHolder1 != listenerHolder0) {
                listenerHolder1.clear();
                this.zza = listenerHolder0;
            }
        }
    }

    @Override  // com.google.android.gms.internal.location.zzdr
    public final void zzc() {
    }
}

