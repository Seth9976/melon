package com.google.android.gms.cast.framework;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbh extends zzbd {
    final Session zza;

    public zzbh(Session session0, zzbi zzbi0) {
        this.zza = session0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.zzbe
    public final long zzb() {
        return this.zza.getSessionRemainingTimeMs();
    }

    @Override  // com.google.android.gms.cast.framework.zzbe
    public final IObjectWrapper zzc() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override  // com.google.android.gms.cast.framework.zzbe
    public final void zzd(boolean z) {
        this.zza.end(z);
    }

    @Override  // com.google.android.gms.cast.framework.zzbe
    public final void zze(Bundle bundle0) {
        this.zza.onResuming(bundle0);
    }

    @Override  // com.google.android.gms.cast.framework.zzbe
    public final void zzf(Bundle bundle0) {
        this.zza.onStarting(bundle0);
    }

    @Override  // com.google.android.gms.cast.framework.zzbe
    public final void zzg(Bundle bundle0) {
        this.zza.resume(bundle0);
    }

    @Override  // com.google.android.gms.cast.framework.zzbe
    public final void zzh(Bundle bundle0) {
        this.zza.start(bundle0);
    }

    @Override  // com.google.android.gms.cast.framework.zzbe
    public final void zzi(Bundle bundle0) {
        this.zza.zzk(bundle0);
    }
}

