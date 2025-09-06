package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzap;
import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

abstract class zzbg extends BasePendingResult {
    private zzat zza;
    private final boolean zzb;
    final RemoteMediaClient zzg;

    public zzbg(RemoteMediaClient remoteMediaClient0, boolean z) {
        this.zzg = remoteMediaClient0;
        super(null);
        this.zzb = z;
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status0) {
        return new zzbf(this, status0);
    }

    public abstract void zza();

    public final zzat zzb() {
        if(this.zza == null) {
            this.zza = new zzbe(this);
        }
        return this.zza;
    }

    public final void zzc() {
        if(!this.zzb) {
            RemoteMediaClient remoteMediaClient0 = this.zzg;
            for(Object object0: remoteMediaClient0.zzi) {
                ((Listener)object0).onSendingRemoteMediaRequest();
            }
            for(Object object1: remoteMediaClient0.zzj) {
                ((Callback)object1).onSendingRemoteMediaRequest();
            }
        }
        try {
            synchronized(this.zzg.zzb) {
                this.zza();
            }
        }
        catch(zzap unused_ex) {
            this.setResult(new zzbf(this, new Status(2100)));
        }
    }
}

