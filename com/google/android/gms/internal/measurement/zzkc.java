package com.google.android.gms.internal.measurement;

import A7.d;
import android.util.Log;
import javax.annotation.Nullable;

final class zzkc extends zzkl {
    public zzkc(zzkf zzkf0, String s, Boolean boolean0, boolean z) {
        super(zzkf0, s, boolean0, true, null);
    }

    @Override  // com.google.android.gms.internal.measurement.zzkl
    @Nullable
    public final Object zza(Object object0) {
        if(object0 instanceof Boolean) {
            return (Boolean)object0;
        }
        if(object0 instanceof String) {
            if(zzjg.zzc.matcher(((String)object0)).matches()) {
                return true;
            }
            if(zzjg.zzd.matcher(((String)object0)).matches()) {
                return false;
            }
        }
        String s = object0.toString();
        Log.e("PhenotypeFlag", d.n(new StringBuilder(this.zzb.length() + 28 + s.length()), "Invalid boolean value for ", this.zzb, ": ", s));
        return null;
    }
}

