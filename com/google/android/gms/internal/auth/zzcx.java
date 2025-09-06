package com.google.android.gms.internal.auth;

import android.util.Log;
import com.iloen.melon.utils.a;
import javax.annotation.Nullable;

final class zzcx extends zzdc {
    public zzcx(zzcz zzcz0, String s, Double double0, boolean z) {
        super(zzcz0, s, double0, true, null);
    }

    @Override  // com.google.android.gms.internal.auth.zzdc
    @Nullable
    public final Object zza(Object object0) {
        try {
            return Double.parseDouble(((String)object0));
        }
        catch(NumberFormatException unused_ex) {
            StringBuilder stringBuilder0 = a.n("Invalid double value for ", this.zzc, ": ");
            stringBuilder0.append(((String)object0));
            Log.e("PhenotypeFlag", stringBuilder0.toString());
            return null;
        }
    }
}

