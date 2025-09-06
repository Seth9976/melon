package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.location.LocationListener;

final class zzdx implements Notifier {
    final zzdy zza;

    public zzdx(zzdy zzdy0) {
        this.zza = zzdy0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        LocationListener locationListener0 = (LocationListener)object0;
        this.zza.zzg().zzc();
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void onNotifyListenerFailed() {
    }
}

