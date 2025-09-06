package com.google.android.gms.internal.measurement;

import A7.d;
import H6.k;
import android.content.Context;
import javax.annotation.Nullable;

final class zzjn extends zzkg {
    private final Context zza;
    @Nullable
    private final k zzb;

    public zzjn(Context context0, @Nullable k k0) {
        this.zza = context0;
        this.zzb = k0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof zzkg) {
            Context context0 = ((zzkg)object0).zza();
            if(this.zza.equals(context0)) {
                return this.zzb == null ? ((zzkg)object0).zzb() == null : this.zzb.equals(((zzkg)object0).zzb());
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = this.zza.hashCode();
        return this.zzb == null ? (v ^ 1000003) * 1000003 : (v ^ 1000003) * 1000003 ^ this.zzb.hashCode();
    }

    @Override
    public final String toString() {
        String s = this.zza.toString();
        String s1 = String.valueOf(this.zzb);
        StringBuilder stringBuilder0 = new StringBuilder(s.length() + 45 + s1.length() + 1);
        d.u(stringBuilder0, "FlagsContext{context=", s, ", hermeticFileOverrides=", s1);
        stringBuilder0.append("}");
        return stringBuilder0.toString();
    }

    @Override  // com.google.android.gms.internal.measurement.zzkg
    public final Context zza() {
        return this.zza;
    }

    @Override  // com.google.android.gms.internal.measurement.zzkg
    @Nullable
    public final k zzb() {
        return this.zzb;
    }
}

