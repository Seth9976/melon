package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzw {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    public zzw(String s, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, byte[] arr_b) {
        this.zza = s;
        this.zzb = z;
        this.zzc = z3;
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final zzp zzb(Context context0) {
        IObjectWrapper iObjectWrapper0 = ObjectWrapper.wrap(context0);
        return new zzp(this.zza, this.zzb, false, ((IBinder)iObjectWrapper0), false, true, false);
    }
}

