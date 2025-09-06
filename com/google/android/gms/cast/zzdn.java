package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzc;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

abstract class zzdn extends zzc {
    private zzat zza;
    protected final WeakReference zzg;
    final RemoteMediaPlayer zzh;

    public zzdn(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0) {
        this.zzh = remoteMediaPlayer0;
        super(googleApiClient0);
        this.zzg = new WeakReference(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status0) {
        return new zzdm(this, status0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) {
        zzx zzx0 = (zzx)api$AnyClient0;
        RemoteMediaPlayer remoteMediaPlayer0 = this.zzh;
        synchronized(remoteMediaPlayer0.zza) {
            GoogleApiClient googleApiClient0 = (GoogleApiClient)this.zzg.get();
            if(googleApiClient0 == null) {
                this.setResult(new zzdm(this, new Status(2100)));
                return;
            }
            remoteMediaPlayer0.zzc.zzc(googleApiClient0);
            try {
                this.zza(zzx0);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                throw illegalArgumentException0;
            }
            catch(Throwable unused_ex) {
                this.setResult(new zzdm(this, new Status(2100)));
            }
            this.zzh.zzc.zzc(null);
        }
    }

    public abstract void zza(zzx arg1);

    public final zzat zzb() {
        if(this.zza == null) {
            this.zza = new zzdl(this);
        }
        return this.zza;
    }
}

