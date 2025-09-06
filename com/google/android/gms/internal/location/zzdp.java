package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.location.DeviceOrientation;
import com.google.android.gms.location.DeviceOrientationListener;

final class zzdp implements Notifier {
    final DeviceOrientation zza;

    public zzdp(zzdq zzdq0, DeviceOrientation deviceOrientation0) {
        this.zza = deviceOrientation0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((DeviceOrientationListener)object0).onDeviceOrientationChanged(this.zza);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void onNotifyListenerFailed() {
    }
}

