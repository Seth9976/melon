package com.google.android.gms.internal.measurement;

import b3.Z;
import java.util.List;

public final class zzau extends zzav {
    public zzau() {
        this.zza.add(zzbk.zze);
        this.zza.add(zzbk.zzf);
        this.zza.add(zzbk.zzg);
        this.zza.add(zzbk.zzh);
        this.zza.add(zzbk.zzi);
        this.zza.add(zzbk.zzj);
        this.zza.add(zzbk.zzk);
    }

    @Override  // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String s, zzg zzg0, List list0) {
        switch(zzh.zze(s).ordinal()) {
            case 4: {
                return new zzah(((double)(zzh.zzg(((double)zzg0.zza(((zzao)Z.i(zzbk.zze, 2, list0, 0))).zzd())) & zzh.zzg(((double)zzg0.zza(((zzao)list0.get(1))).zzd())))));
            }
            case 5: {
                return new zzah(((double)(zzh.zzg(((double)zzg0.zza(((zzao)Z.i(zzbk.zzf, 2, list0, 0))).zzd())) << ((int)(zzh.zzh(((double)zzg0.zza(((zzao)list0.get(1))).zzd())) & 0x1FL)))));
            }
            case 6: {
                return new zzah(((double)(~zzh.zzg(((double)zzg0.zza(((zzao)Z.i(zzbk.zzg, 1, list0, 0))).zzd())))));
            }
            case 7: {
                return new zzah(((double)(zzh.zzg(((double)zzg0.zza(((zzao)Z.i(zzbk.zzh, 2, list0, 0))).zzd())) | zzh.zzg(((double)zzg0.zza(((zzao)list0.get(1))).zzd())))));
            }
            case 8: {
                return new zzah(((double)(zzh.zzg(((double)zzg0.zza(((zzao)Z.i(zzbk.zzi, 2, list0, 0))).zzd())) >> ((int)(zzh.zzh(((double)zzg0.zza(((zzao)list0.get(1))).zzd())) & 0x1FL)))));
            }
            case 9: {
                return new zzah(((double)(zzh.zzh(((double)zzg0.zza(((zzao)Z.i(zzbk.zzj, 2, list0, 0))).zzd())) >>> ((int)(zzh.zzh(((double)zzg0.zza(((zzao)list0.get(1))).zzd())) & 0x1FL)))));
            }
            case 10: {
                return new zzah(((double)(zzh.zzg(((double)zzg0.zza(((zzao)Z.i(zzbk.zzk, 2, list0, 0))).zzd())) ^ zzh.zzg(((double)zzg0.zza(((zzao)list0.get(1))).zzd())))));
            }
            default: {
                return this.zzb(s);
            }
        }
    }
}

