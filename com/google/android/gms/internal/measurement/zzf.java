package com.google.android.gms.internal.measurement;

public final class zzf {
    final zzaw zza;
    final zzg zzb;
    final zzg zzc;
    final zzj zzd;

    public zzf() {
        zzaw zzaw0 = new zzaw();
        this.zza = zzaw0;
        zzg zzg0 = new zzg(null, zzaw0);
        this.zzc = zzg0;
        this.zzb = zzg0.zzc();
        zzj zzj0 = new zzj();
        this.zzd = zzj0;
        zzg0.zze("require", new zzw(zzj0));
        zzj0.zza("internal.platform", () -> new zzy());
        zzg0.zze("runtime.counter", new zzah(0.0));
    }

    public final zzao zza(zzg zzg0, zzje[] arr_zzje) {
        zzao zzao0 = zzao.zzf;
        for(int v = 0; v < arr_zzje.length; ++v) {
            zzao0 = zzi.zzb(arr_zzje[v]);
            zzh.zzl(this.zzc);
            if(zzao0 instanceof zzap || zzao0 instanceof zzan) {
                zzao0 = this.zza.zzb(zzg0, zzao0);
            }
        }
        return zzao0;
    }
}

