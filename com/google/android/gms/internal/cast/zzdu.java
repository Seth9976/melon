package com.google.android.gms.internal.cast;

import android.net.ConnectivityManager.NetworkCallback;
import android.net.LinkProperties;
import android.net.Network;

final class zzdu extends ConnectivityManager.NetworkCallback {
    final zzdv zza;

    public zzdu(zzdv zzdv0) {
        this.zza = zzdv0;
        super();
    }

    @Override  // android.net.ConnectivityManager$NetworkCallback
    public final void onAvailable(Network network0) {
    }

    @Override  // android.net.ConnectivityManager$NetworkCallback
    public final void onLinkPropertiesChanged(Network network0, LinkProperties linkProperties0) {
        zzdv.zzc(this.zza, network0, linkProperties0);
    }

    @Override  // android.net.ConnectivityManager$NetworkCallback
    public final void onLost(Network network0) {
        zzdv.zze(this.zza, network0);
    }

    @Override  // android.net.ConnectivityManager$NetworkCallback
    public final void onUnavailable() {
        zzdv.zzd(this.zza);
    }
}

