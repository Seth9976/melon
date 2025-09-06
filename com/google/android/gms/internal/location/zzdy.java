package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.zzy;

final class zzdy extends zzy {
    private final zzdr zza;

    public zzdy(zzdr zzdr0) {
        this.zza = zzdr0;
    }

    public final zzdy zzc(ListenerHolder listenerHolder0) {
        this.zza.zzb(listenerHolder0);
        return this;
    }

    @Override  // com.google.android.gms.location.zzz
    public final void zzd(Location location0) {
        this.zza.zza().notifyListener(new zzdw(this, location0));
    }

    @Override  // com.google.android.gms.location.zzz
    public final void zze() {
        this.zza.zza().notifyListener(new zzdx(this));
    }

    public final void zzf() {
        this.zza.zza().clear();
    }

    public final zzdr zzg() {
        return this.zza;
    }
}

