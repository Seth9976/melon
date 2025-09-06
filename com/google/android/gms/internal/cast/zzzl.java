package com.google.android.gms.internal.cast;

import sun.misc.Unsafe;

final class zzzl extends zzzn {
    public zzzl(Unsafe unsafe0) {
        super(unsafe0);
    }

    @Override  // com.google.android.gms.internal.cast.zzzn
    public final double zza(Object object0, long v) {
        return Double.longBitsToDouble(this.zza.getLong(object0, v));
    }

    @Override  // com.google.android.gms.internal.cast.zzzn
    public final float zzb(Object object0, long v) {
        return Float.intBitsToFloat(this.zza.getInt(object0, v));
    }

    @Override  // com.google.android.gms.internal.cast.zzzn
    public final void zzc(Object object0, long v, boolean z) {
        if(zzzo.zzb) {
            zzzo.zzi(object0, v, z);
            return;
        }
        zzzo.zzj(object0, v, z);
    }

    @Override  // com.google.android.gms.internal.cast.zzzn
    public final void zzd(Object object0, long v, byte b) {
        if(zzzo.zzb) {
            zzzo.zzk(object0, v, b);
            return;
        }
        zzzo.zzl(object0, v, b);
    }

    @Override  // com.google.android.gms.internal.cast.zzzn
    public final void zze(Object object0, long v, double f) {
        this.zza.putLong(object0, v, Double.doubleToLongBits(f));
    }

    @Override  // com.google.android.gms.internal.cast.zzzn
    public final void zzf(Object object0, long v, float f) {
        this.zza.putInt(object0, v, Float.floatToIntBits(f));
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.internal.cast.zzzn
    public final boolean zzg(Object object0, long v) {
        return zzzo.zzb ? zzzo.zzt(object0, v) : zzzo.zzu(object0, v);
    }
}

