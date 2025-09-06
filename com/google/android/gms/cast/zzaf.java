package com.google.android.gms.cast;

import l4.H;
import l4.O;
import l4.Q;

final class zzaf extends H {
    final CastRemoteDisplayLocalService zza;

    public zzaf(CastRemoteDisplayLocalService castRemoteDisplayLocalService0) {
        this.zza = castRemoteDisplayLocalService0;
        super();
    }

    @Override  // l4.H
    public final void onRouteUnselected(Q q0, O o0) {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService0 = this.zza;
        castRemoteDisplayLocalService0.zzv("onRouteUnselected");
        if(castRemoteDisplayLocalService0.zzm == null) {
            castRemoteDisplayLocalService0.zzv("onRouteUnselected, no device was selected");
            return;
        }
        CastDevice castDevice0 = CastDevice.getFromBundle(o0.s);
        if(castDevice0 != null && castDevice0.getDeviceId().equals(castRemoteDisplayLocalService0.zzm.getDeviceId())) {
            CastRemoteDisplayLocalService.stopService();
            return;
        }
        castRemoteDisplayLocalService0.zzv("onRouteUnselected, device does not match");
    }
}

