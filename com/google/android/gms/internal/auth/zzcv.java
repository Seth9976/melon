package com.google.android.gms.internal.auth;

import android.util.Log;
import com.iloen.melon.utils.a;
import javax.annotation.Nullable;

final class zzcv extends zzdc {
    public zzcv(zzcz zzcz0, String s, Long long0, boolean z) {
        super(zzcz0, s, long0, true, null);
    }

    @Override  // com.google.android.gms.internal.auth.zzdc
    @Nullable
    public final Object zza(Object object0) {
        try {
            return Long.parseLong(((String)object0));
        }
        catch(NumberFormatException unused_ex) {
            StringBuilder stringBuilder0 = a.n("Invalid long value for ", this.zzc, ": ");
            stringBuilder0.append(((String)object0));
            Log.e("PhenotypeFlag", stringBuilder0.toString());
            return null;
        }
    }
}

