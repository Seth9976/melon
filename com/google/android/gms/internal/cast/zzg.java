package com.google.android.gms.internal.cast;

import com.google.android.gms.tasks.OnSuccessListener;

public final class zzg implements OnSuccessListener {
    public final zzh zza;
    public final zzqe zzb;
    public final int zzc;

    public zzg(zzh zzh0, zzqe zzqe0, int v) {
        this.zza = zzh0;
        this.zzb = zzqe0;
        this.zzc = v;
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object object0) {
        zzh.zze(this.zza, this.zzb, this.zzc, ((Boolean)object0));
    }
}

