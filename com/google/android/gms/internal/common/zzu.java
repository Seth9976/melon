package com.google.android.gms.internal.common;

final class zzu extends zzx {
    final zzp zza;

    public zzu(zzy zzy0, CharSequence charSequence0, zzp zzp0) {
        this.zza = zzp0;
        super(zzy0, charSequence0);
    }

    @Override  // com.google.android.gms.internal.common.zzx
    public final int zzc(int v) {
        CharSequence charSequence0 = this.zzb;
        int v1 = charSequence0.length();
        zzt.zzc(v, v1, "index");
        while(v < v1) {
            int v2 = charSequence0.charAt(v);
            if(this.zza.zza(((char)v2))) {
                return v;
            }
            ++v;
        }
        return -1;
    }

    @Override  // com.google.android.gms.internal.common.zzx
    public final int zzd(int v) {
        return v + 1;
    }
}

