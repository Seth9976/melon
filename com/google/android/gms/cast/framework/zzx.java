package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzaw;
import com.google.android.gms.cast.zzbb;
import com.google.android.gms.cast.zzbh;
import com.google.android.gms.cast.zzbr;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.api.internal.TaskApiCall;

final class zzx extends zzaf {
    final CastSession zza;

    public zzx(CastSession castSession0, zzaa zzaa0) {
        this.zza = castSession0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.zzag
    public final void zzb(int v) {
        CastSession.zzh(this.zza, v);
    }

    @Override  // com.google.android.gms.cast.framework.zzag
    public final void zzc(String s, String s1) {
        CastSession castSession0 = this.zza;
        if(castSession0.zzi != null && castSession0.zzi.zzl()) {
            Builder taskApiCall$Builder0 = TaskApiCall.builder();
            zzbr zzbr0 = (zzbr)castSession0.zzi;
            zzbr0.doWrite(taskApiCall$Builder0.run(new zzbb(zzbr0, s, s1, null)).setMethodKey(8407).build()).addOnCompleteListener(new zzw(this));
        }
    }

    @Override  // com.google.android.gms.cast.framework.zzag
    public final void zzd(String s, LaunchOptions launchOptions0) {
        CastSession castSession0 = this.zza;
        if(castSession0.zzi != null && castSession0.zzi.zzl()) {
            Builder taskApiCall$Builder0 = TaskApiCall.builder();
            zzbr zzbr0 = (zzbr)castSession0.zzi;
            zzbr0.doWrite(taskApiCall$Builder0.run(new zzaw(zzbr0, s, launchOptions0)).setMethodKey(8406).build()).addOnCompleteListener(new zzv(this));
        }
    }

    @Override  // com.google.android.gms.cast.framework.zzag
    public final void zze(String s) {
        CastSession castSession0 = this.zza;
        if(castSession0.zzi != null && castSession0.zzi.zzl()) {
            Builder taskApiCall$Builder0 = TaskApiCall.builder();
            zzbr zzbr0 = (zzbr)castSession0.zzi;
            zzbr0.doWrite(taskApiCall$Builder0.run(new zzbh(zzbr0, s)).setMethodKey(8409).build());
        }
    }
}

