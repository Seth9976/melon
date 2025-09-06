package com.google.android.gms.internal.auth;

import android.util.Log;
import com.iloen.melon.utils.a;
import javax.annotation.Nullable;

final class zzcw extends zzdc {
    public zzcw(zzcz zzcz0, String s, Boolean boolean0, boolean z) {
        super(zzcz0, s, boolean0, true, null);
    }

    @Override  // com.google.android.gms.internal.auth.zzdc
    @Nullable
    public final Object zza(Object object0) {
        if(zzcb.zzc.matcher(((CharSequence)object0)).matches()) {
            return true;
        }
        if(zzcb.zzd.matcher(((CharSequence)object0)).matches()) {
            return false;
        }
        StringBuilder stringBuilder0 = a.n("Invalid boolean value for ", this.zzc, ": ");
        stringBuilder0.append(((String)object0));
        Log.e("PhenotypeFlag", stringBuilder0.toString());
        return null;
    }
}

