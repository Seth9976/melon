package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzax extends zzav {
    public zzax() {
        this.zza.add(zzbk.zzx);
        this.zza.add(zzbk.zzL);
        this.zza.add(zzbk.zzM);
        this.zza.add(zzbk.zzN);
        this.zza.add(zzbk.zzO);
        this.zza.add(zzbk.zzQ);
        this.zza.add(zzbk.zzR);
        this.zza.add(zzbk.zzW);
    }

    @Override  // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String s, zzg zzg0, List list0) {
        zzh.zza(zzh.zze(s).name(), 2, list0);
        zzao zzao0 = zzg0.zza(((zzao)list0.get(0)));
        zzao zzao1 = zzg0.zza(((zzao)list0.get(1)));
        switch(zzh.zze(s).ordinal()) {
            case 23: {
                return zzax.zzd(zzao0, zzao1) ? zzao.zzk : zzao.zzl;
            }
            case 37: {
                return zzax.zzc(zzao1, zzao0) ? zzao.zzk : zzao.zzl;
            }
            case 38: {
                return zzax.zze(zzao1, zzao0) ? zzao.zzk : zzao.zzl;
            }
            case 39: {
                return zzh.zzf(zzao0, zzao1) ? zzao.zzk : zzao.zzl;
            }
            case 40: {
                return zzh.zzf(zzao0, zzao1) ? zzao.zzl : zzao.zzk;
            }
            case 42: {
                return zzax.zzc(zzao0, zzao1) ? zzao.zzk : zzao.zzl;
            }
            case 43: {
                return zzax.zze(zzao0, zzao1) ? zzao.zzk : zzao.zzl;
            }
            case 0x30: {
                return zzax.zzd(zzao0, zzao1) ? zzao.zzl : zzao.zzk;
            }
            default: {
                return this.zzb(s);
            }
        }
    }

    private static boolean zzc(zzao zzao0, zzao zzao1) {
        if(zzao0 instanceof zzak) {
            zzao0 = new zzas(zzao0.zzc());
        }
        if(zzao1 instanceof zzak) {
            zzao1 = new zzas(zzao1.zzc());
        }
        if(zzao0 instanceof zzas && zzao1 instanceof zzas) {
            return zzao0.zzc().compareTo(zzao1.zzc()) < 0;
        }
        double f = (double)zzao0.zzd();
        double f1 = (double)zzao1.zzd();
        if(!Double.isNaN(f) && !Double.isNaN(f1)) {
            int v = Double.compare(f, 0.0);
            return (v != 0 || f1 != 0.0) && (v != 0 || f1 != 0.0) ? Double.compare(f, f1) < 0 : false;
        }
        return false;
    }

    private static boolean zzd(zzao zzao0, zzao zzao1) {
        if(zzao0.getClass().equals(zzao1.getClass())) {
            if(!(zzao0 instanceof zzat) && !(zzao0 instanceof zzam)) {
                if(zzao0 instanceof zzah) {
                    return !Double.isNaN(((double)zzao0.zzd())) && !Double.isNaN(((double)zzao1.zzd())) && ((double)zzao0.zzd()) == ((double)zzao1.zzd());
                }
                if(zzao0 instanceof zzas) {
                    return zzao0.zzc().equals(zzao1.zzc());
                }
                return zzao0 instanceof zzaf ? zzao0.zze().equals(zzao1.zze()) : zzao0 == zzao1;
            }
            return true;
        }
        if(!(zzao0 instanceof zzat) && !(zzao0 instanceof zzam) || !(zzao1 instanceof zzat) && !(zzao1 instanceof zzam)) {
            if(zzao0 instanceof zzah && zzao1 instanceof zzas) {
                return zzax.zzd(zzao0, new zzah(zzao1.zzd()));
            }
            if(zzao0 instanceof zzas && zzao1 instanceof zzah) {
                return zzax.zzd(new zzah(zzao0.zzd()), zzao1);
            }
            if(zzao0 instanceof zzaf) {
                return zzax.zzd(new zzah(zzao0.zzd()), zzao1);
            }
            if(zzao1 instanceof zzaf) {
                return zzax.zzd(zzao0, new zzah(zzao1.zzd()));
            }
            if(!(zzao0 instanceof zzas) && !(zzao0 instanceof zzah) || !(zzao1 instanceof zzak)) {
                return !(zzao0 instanceof zzak) || !(zzao1 instanceof zzas) && !(zzao1 instanceof zzah) ? false : zzax.zzd(new zzas(zzao0.zzc()), zzao1);
            }
            return zzax.zzd(zzao0, new zzas(zzao1.zzc()));
        }
        return true;
    }

    private static boolean zze(zzao zzao0, zzao zzao1) {
        if(zzao0 instanceof zzak) {
            zzao0 = new zzas(zzao0.zzc());
        }
        if(zzao1 instanceof zzak) {
            zzao1 = new zzas(zzao1.zzc());
        }
        return (zzao0 instanceof zzas && zzao1 instanceof zzas || !Double.isNaN(((double)zzao0.zzd())) && !Double.isNaN(((double)zzao1.zzd()))) && !zzax.zzc(zzao1, zzao0);
    }
}

