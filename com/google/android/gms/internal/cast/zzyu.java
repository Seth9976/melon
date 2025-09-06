package com.google.android.gms.internal.cast;

final class zzyu implements zzyi {
    private final zzyl zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zzyu(zzyl zzyl0, String s, Object[] arr_object) {
        this.zza = zzyl0;
        this.zzb = s;
        this.zzc = arr_object;
        int v = s.charAt(0);
        if(v < 0xD800) {
            this.zzd = v;
            return;
        }
        int v1 = v & 0x1FFF;
        int v3 = 13;
        int v4;
        for(int v2 = 1; (v4 = s.charAt(v2)) >= 0xD800; ++v2) {
            v1 |= (v4 & 0x1FFF) << v3;
            v3 += 13;
        }
        this.zzd = v1 | v4 << v3;
    }

    @Override  // com.google.android.gms.internal.cast.zzyi
    public final zzyl zza() {
        return this.zza;
    }

    @Override  // com.google.android.gms.internal.cast.zzyi
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }

    @Override  // com.google.android.gms.internal.cast.zzyi
    public final int zzc() {
        int v = this.zzd;
        if((v & 1) != 0) {
            return 1;
        }
        return (v & 4) == 4 ? 3 : 2;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}

