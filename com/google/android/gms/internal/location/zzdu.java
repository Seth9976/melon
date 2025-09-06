package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.location.LocationCallback;

final class zzdu implements Notifier {
    final zzdv zza;

    public zzdu(zzdv zzdv0) {
        this.zza = zzdv0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        LocationCallback locationCallback0 = (LocationCallback)object0;
        this.zza.zzh().zzc();
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void onNotifyListenerFailed() {
    }
}

