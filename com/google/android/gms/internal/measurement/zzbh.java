package com.google.android.gms.internal.measurement;

import b3.Z;
import java.util.List;

public final class zzbh extends zzav {
    public zzbh() {
        this.zza.add(zzbk.zza);
        this.zza.add(zzbk.zzv);
        this.zza.add(zzbk.zzS);
        this.zza.add(zzbk.zzT);
        this.zza.add(zzbk.zzU);
        this.zza.add(zzbk.zzaa);
        this.zza.add(zzbk.zzab);
        this.zza.add(zzbk.zzad);
        this.zza.add(zzbk.zzae);
        this.zza.add(zzbk.zzah);
    }

    @Override  // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String s, zzg zzg0, List list0) {
        switch(zzh.zze(s).ordinal()) {
            case 0: {
                zzao zzao0 = zzg0.zza(((zzao)Z.i(zzbk.zza, 2, list0, 0)));
                zzao zzao1 = zzg0.zza(((zzao)list0.get(1)));
                if(!(zzao0 instanceof zzak) && !(zzao0 instanceof zzas) && !(zzao1 instanceof zzak) && !(zzao1 instanceof zzas)) {
                    double f = (double)zzao0.zzd();
                    return new zzah(((double)(((double)zzao1.zzd()) + f)));
                }
                return new zzas(zzao0.zzc() + zzao1.zzc());
            }
            case 21: {
                return new zzah(((double)(((double)zzg0.zza(((zzao)Z.i(zzbk.zzv, 2, list0, 0))).zzd()) / ((double)zzg0.zza(((zzao)list0.get(1))).zzd()))));
            }
            case 44: {
                return new zzah(((double)(((double)zzg0.zza(((zzao)Z.i(zzbk.zzS, 2, list0, 0))).zzd()) % ((double)zzg0.zza(((zzao)list0.get(1))).zzd()))));
            }
            case 45: {
                double f1 = (double)zzg0.zza(((zzao)Z.i(zzbk.zzT, 2, list0, 0))).zzd();
                return new zzah(((double)(((double)zzg0.zza(((zzao)list0.get(1))).zzd()) * f1)));
            }
            case 46: {
                return new zzah(((double)(-((double)zzg0.zza(((zzao)Z.i(zzbk.zzU, 1, list0, 0))).zzd()))));
            }
            case 52: 
            case 53: {
                zzh.zza(s, 2, list0);
                zzao zzao2 = zzg0.zza(((zzao)list0.get(0)));
                zzg0.zza(((zzao)list0.get(1)));
                return zzao2;
            }
            case 55: 
            case 56: {
                zzh.zza(s, 1, list0);
                return zzg0.zza(((zzao)list0.get(0)));
            }
            case 59: {
                zzao zzao3 = zzg0.zza(((zzao)Z.i(zzbk.zzah, 2, list0, 0)));
                zzah zzah0 = new zzah(((double)(-((double)zzg0.zza(((zzao)list0.get(1))).zzd()))));
                double f2 = (double)zzao3.zzd();
                return new zzah(((double)(((double)zzah0.zzd()) + f2)));
            }
            default: {
                return this.zzb(s);
            }
        }
    }
}

