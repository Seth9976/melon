package com.google.android.gms.internal.common;

abstract class zzx extends zzk {
    final CharSequence zzb;
    final zzp zzc;
    final boolean zzd;
    int zze;
    int zzf;

    public zzx(zzy zzy0, CharSequence charSequence0) {
        this.zze = 0;
        this.zzc = zzy0.zzf();
        this.zzd = zzy0.zzg();
        this.zzf = 0x7FFFFFFF;
        this.zzb = charSequence0;
    }

    @Override  // com.google.android.gms.internal.common.zzk
    public final Object zza() {
        int v3;
        int v = this.zze;
        int v1;
        while((v1 = this.zze) != -1) {
            int v2 = this.zzc(v1);
            if(v2 == -1) {
                v2 = this.zzb.length();
                this.zze = -1;
                v3 = -1;
            }
            else {
                v3 = this.zzd(v2);
                this.zze = v3;
            }
            if(v3 == v) {
                this.zze = v3 + 1;
                if(v3 + 1 <= this.zzb.length()) {
                    continue;
                }
                this.zze = -1;
                continue;
            }
            if(v < v2) {
                this.zzb.charAt(v);
            }
            if(v < v2) {
                this.zzb.charAt(v2 - 1);
            }
            if(this.zzd && v == v2) {
                v = this.zze;
                continue;
            }
            int v4 = this.zzf;
            if(v4 == 1) {
                CharSequence charSequence0 = this.zzb;
                int v5 = charSequence0.length();
                this.zze = -1;
                if(v5 > v) {
                    charSequence0.charAt(v5 - 1);
                }
                return this.zzb.subSequence(v, v5).toString();
            }
            this.zzf = v4 - 1;
            return this.zzb.subSequence(v, v2).toString();
        }
        this.zzb();
        return null;
    }

    public abstract int zzc(int arg1);

    public abstract int zzd(int arg1);
}

