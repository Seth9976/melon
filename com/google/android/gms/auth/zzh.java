package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.auth.zze;

final class zzh implements zzk {
    final String zza;
    final Bundle zzb;

    public zzh(String s, Bundle bundle0) {
        this.zza = s;
        this.zzb = bundle0;
        super();
    }

    @Override  // com.google.android.gms.auth.zzk
    public final Object zza(IBinder iBinder0) {
        Bundle bundle0 = zze.zzb(iBinder0).zzd(this.zza, this.zzb);
        zzl.zzc(bundle0);
        String s = bundle0.getString("Error");
        if(!bundle0.getBoolean("booleanResult")) {
            throw new GoogleAuthException(s);
        }
        return null;
    }
}

