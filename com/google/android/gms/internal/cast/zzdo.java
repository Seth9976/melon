package com.google.android.gms.internal.cast;

import android.os.Bundle;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.zzo;
import l4.H;
import l4.O;
import l4.Q;

final class zzdo extends H {
    final zzdq zza;

    public zzdo(zzdq zzdq0, zzdp zzdp0) {
        this.zza = zzdq0;
        super();
    }

    @Override  // l4.H
    public final void onRouteAdded(Q q0, O o0) {
        zzdq.zzb().d("RemoteConnectionMediaRouterCallback.onRouteAdded.", new Object[0]);
        zzdq.zzd(this.zza, o0.s);
    }

    @Override  // l4.H
    public final void onRouteChanged(Q q0, O o0) {
        zzdq.zzb().d("RemoteConnectionMediaRouterCallback.onRouteChanged.", new Object[0]);
        zzdq.zzd(this.zza, o0.s);
    }

    @Override  // l4.H
    public final void onRouteRemoved(Q q0, O o0) {
        zzdq.zzc.d("RemoteConnectionMediaRouterCallback.onRouteRemoved.", new Object[0]);
        Bundle bundle0 = o0.s;
        if(bundle0 != null) {
            CastDevice castDevice0 = CastDevice.getFromBundle(bundle0);
            if(castDevice0 != null) {
                String s = bundle0.getString("com.google.android.gms.cast.EXTRA_RUNNING_RECEIVER_APP_ID");
                zzdq zzdq0 = this.zza;
                zzdi zzdi0 = (zzdi)zzdq0.zzj.get(castDevice0.getDeviceId());
                if(zzdi0 != null && s != null) {
                    throw null;
                }
                if(zzdi0 != null) {
                    zzo zzo0 = new zzo();
                    zzo0.zzb(0x976);
                    zzdi0.zza(zzo0.zzc());
                }
                if(zzdi0 != null) {
                    throw null;
                }
                zzdq0.zzj(castDevice0);
            }
        }
    }
}

