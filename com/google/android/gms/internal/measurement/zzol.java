package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

final class zzol extends zzon {
    public zzol(Unsafe unsafe0) {
        super(unsafe0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzon
    public final void zza(Object object0, long v, byte b) {
        if(zzoo.zzb) {
            zzoo.zzs(object0, v, b);
            return;
        }
        zzoo.zzt(object0, v, b);
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.internal.measurement.zzon
    public final boolean zzb(Object object0, long v) {
        return zzoo.zzb ? zzoo.zzu(object0, v) : zzoo.zzv(object0, v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzon
    public final void zzc(Object object0, long v, boolean z) {
        if(zzoo.zzb) {
            zzoo.zzw(object0, v, z);
            return;
        }
        zzoo.zzx(object0, v, z);
    }

    @Override  // com.google.android.gms.internal.measurement.zzon
    public final float zzd(Object object0, long v) {
        return Float.intBitsToFloat(this.zza.getInt(object0, v));
    }

    @Override  // com.google.android.gms.internal.measurement.zzon
    public final void zze(Object object0, long v, float f) {
        this.zza.putInt(object0, v, Float.floatToIntBits(f));
    }

    @Override  // com.google.android.gms.internal.measurement.zzon
    public final double zzf(Object object0, long v) {
        return Double.longBitsToDouble(this.zza.getLong(object0, v));
    }

    @Override  // com.google.android.gms.internal.measurement.zzon
    public final void zzg(Object object0, long v, double f) {
        this.zza.putLong(object0, v, Double.doubleToLongBits(f));
    }
}

