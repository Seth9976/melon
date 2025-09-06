package com.google.android.gms.internal.measurement;

import A7.d;
import android.util.Log;
import javax.annotation.Nullable;

final class zzkd extends zzkl {
    public zzkd(zzkf zzkf0, String s, Double double0, boolean z) {
        super(zzkf0, "measurement.test.double_flag", double0, true, null);
    }

    @Override  // com.google.android.gms.internal.measurement.zzkl
    @Nullable
    public final Object zza(Object object0) {
        if(object0 instanceof Double) {
            return (Double)object0;
        }
        if(object0 instanceof Float) {
            return ((Float)object0).doubleValue();
        }
        if(object0 instanceof String) {
            try {
                return Double.parseDouble(((String)object0));
            }
            catch(NumberFormatException unused_ex) {
            }
        }
        String s = object0.toString();
        Log.e("PhenotypeFlag", d.n(new StringBuilder(this.zzb.length() + 27 + s.length()), "Invalid double value for ", this.zzb, ": ", s));
        return null;
    }
}

