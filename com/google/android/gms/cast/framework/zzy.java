package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast.Listener;
import java.util.HashSet;

final class zzy extends Listener {
    final CastSession zza;

    public zzy(CastSession castSession0, zzaa zzaa0) {
        this.zza = castSession0;
        super();
    }

    @Override  // com.google.android.gms.cast.Cast$Listener
    public final void onActiveInputStateChanged(int v) {
        for(Object object0: new HashSet(this.zza.zzd)) {
            ((Listener)object0).onActiveInputStateChanged(v);
        }
    }

    @Override  // com.google.android.gms.cast.Cast$Listener
    public final void onApplicationDisconnected(int v) {
        CastSession.zzh(this.zza, v);
        this.zza.notifySessionEnded(v);
        for(Object object0: new HashSet(this.zza.zzd)) {
            ((Listener)object0).onApplicationDisconnected(v);
        }
    }

    @Override  // com.google.android.gms.cast.Cast$Listener
    public final void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata0) {
        for(Object object0: new HashSet(this.zza.zzd)) {
            ((Listener)object0).onApplicationMetadataChanged(applicationMetadata0);
        }
    }

    @Override  // com.google.android.gms.cast.Cast$Listener
    public final void onApplicationStatusChanged() {
        for(Object object0: new HashSet(this.zza.zzd)) {
            ((Listener)object0).onApplicationStatusChanged();
        }
    }

    @Override  // com.google.android.gms.cast.Cast$Listener
    public final void onStandbyStateChanged(int v) {
        for(Object object0: new HashSet(this.zza.zzd)) {
            ((Listener)object0).onStandbyStateChanged(v);
        }
    }

    @Override  // com.google.android.gms.cast.Cast$Listener
    public final void onVolumeChanged() {
        for(Object object0: new HashSet(this.zza.zzd)) {
            ((Listener)object0).onVolumeChanged();
        }
    }
}

