package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.DeviceOrientation;
import com.google.android.gms.location.zzs;

final class zzdq extends zzs {
    private ListenerHolder zza;

    public zzdq(ListenerHolder listenerHolder0) {
        this.zza = listenerHolder0;
    }

    public final void zzc(ListenerHolder listenerHolder0) {
        synchronized(this) {
            ListenerHolder listenerHolder1 = this.zza;
            if(listenerHolder1 != listenerHolder0) {
                listenerHolder1.clear();
                this.zza = listenerHolder0;
            }
        }
    }

    @Override  // com.google.android.gms.location.zzt
    public final void zzd(DeviceOrientation deviceOrientation0) {
        synchronized(this) {
        }
        this.zza.notifyListener(new zzdp(this, deviceOrientation0));
    }

    public final void zze() {
        synchronized(this) {
            this.zza.clear();
        }
    }
}

