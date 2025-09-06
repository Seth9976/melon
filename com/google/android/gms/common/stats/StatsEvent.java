package com.google.android.gms.common.stats;

import U4.x;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
@Deprecated
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    @KeepForSdk
    public interface Types {
        @KeepForSdk
        public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;
        @KeepForSdk
        public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;

    }

    @Override
    public final String toString() {
        long v = this.zza();
        int v1 = this.zzb();
        String s = this.zzc();
        StringBuilder stringBuilder0 = new StringBuilder(String.valueOf(v).length() + 1 + String.valueOf(v1).length() + 3 + s.length());
        stringBuilder0.append(v);
        stringBuilder0.append("\t");
        stringBuilder0.append(v1);
        return x.m(stringBuilder0, "\t-1", s);
    }

    public abstract long zza();

    public abstract int zzb();

    public abstract String zzc();
}

