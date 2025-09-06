package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.tasks.OnSuccessListener;

public final class zzd implements OnSuccessListener {
    public final zzh zza;
    public final String zzb;
    public final int zzc;
    public final SharedPreferences zzd;

    public zzd(zzh zzh0, String s, int v, SharedPreferences sharedPreferences0) {
        this.zza = zzh0;
        this.zzb = s;
        this.zzc = v;
        this.zzd = sharedPreferences0;
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object object0) {
        zzh.zzb(this.zza, this.zzb, this.zzc, this.zzd, ((Bundle)object0));
    }
}

