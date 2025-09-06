package com.google.android.gms.internal.measurement;

import A7.d;
import android.util.Log;
import javax.annotation.Nullable;

final class zzkb extends zzkl {
    public zzkb(zzkf zzkf0, String s, Long long0, boolean z) {
        super(zzkf0, s, long0, true, null);
    }

    @Override  // com.google.android.gms.internal.measurement.zzkl
    @Nullable
    public final Object zza(Object object0) {
        if(object0 instanceof Long) {
            return (Long)object0;
        }
        if(object0 instanceof String) {
            try {
                return Long.parseLong(((String)object0));
            }
            catch(NumberFormatException unused_ex) {
            }
        }
        String s = object0.toString();
        Log.e("PhenotypeFlag", d.n(new StringBuilder(this.zzb.length() + 25 + s.length()), "Invalid long value for ", this.zzb, ": ", s));
        return null;
    }
}

