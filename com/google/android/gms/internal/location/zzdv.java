package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzv;

final class zzdv extends zzv {
    private final zzdr zza;

    public zzdv(zzdr zzdr0) {
        this.zza = zzdr0;
    }

    public final zzdv zzc(ListenerHolder listenerHolder0) {
        this.zza.zzb(listenerHolder0);
        return this;
    }

    @Override  // com.google.android.gms.location.zzw
    public final void zzd(LocationResult locationResult0) {
        this.zza.zza().notifyListener(new zzds(this, locationResult0));
    }

    @Override  // com.google.android.gms.location.zzw
    public final void zze(LocationAvailability locationAvailability0) {
        this.zza.zza().notifyListener(new zzdt(this, locationAvailability0));
    }

    @Override  // com.google.android.gms.location.zzw
    public final void zzf() {
        this.zza.zza().notifyListener(new zzdu(this));
    }

    public final void zzg() {
        this.zza.zza().clear();
    }

    public final zzdr zzh() {
        return this.zza;
    }
}

