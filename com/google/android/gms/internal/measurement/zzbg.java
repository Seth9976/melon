package com.google.android.gms.internal.measurement;

import b3.Z;
import java.util.Iterator;
import java.util.List;

public final class zzbg extends zzav {
    public zzbg() {
        this.zza.add(zzbk.zzA);
        this.zza.add(zzbk.zzB);
        this.zza.add(zzbk.zzC);
        this.zza.add(zzbk.zzD);
        this.zza.add(zzbk.zzE);
        this.zza.add(zzbk.zzF);
        this.zza.add(zzbk.zzG);
        this.zza.add(zzbk.zzan);
    }

    @Override  // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String s, zzg zzg0, List list0) {
        int v = zzh.zze(s).ordinal();
        if(v != 65) {
            switch(v) {
                case 26: {
                    if(!(Z.i(zzbk.zzA, 3, list0, 0) instanceof zzas)) {
                        throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
                    }
                    String s1 = ((zzao)list0.get(0)).zzc();
                    zzao zzao0 = zzg0.zza(((zzao)list0.get(1)));
                    zzao zzao1 = zzg0.zza(((zzao)list0.get(2)));
                    return zzbg.zzc(new zzbf(zzg0, s1), zzao0, zzao1);
                }
                case 27: {
                    if(!(Z.i(zzbk.zzB, 3, list0, 0) instanceof zzas)) {
                        throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                    }
                    String s2 = ((zzao)list0.get(0)).zzc();
                    zzao zzao2 = zzg0.zza(((zzao)list0.get(1)));
                    zzao zzao3 = zzg0.zza(((zzao)list0.get(2)));
                    return zzbg.zzc(new zzbc(zzg0, s2), zzao2, zzao3);
                }
                case 28: {
                    if(!(Z.i(zzbk.zzC, 3, list0, 0) instanceof zzas)) {
                        throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                    }
                    String s3 = ((zzao)list0.get(0)).zzc();
                    zzao zzao4 = zzg0.zza(((zzao)list0.get(1)));
                    zzao zzao5 = zzg0.zza(((zzao)list0.get(2)));
                    return zzbg.zzc(new zzbd(zzg0, s3), zzao4, zzao5);
                }
                case 29: {
                    zzao zzao6 = zzg0.zza(((zzao)Z.i(zzbk.zzD, 4, list0, 0)));
                    if(!(zzao6 instanceof zzae)) {
                        throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                    }
                    zzao zzao7 = (zzao)list0.get(1);
                    zzao zzao8 = (zzao)list0.get(2);
                    zzao zzao9 = zzg0.zza(((zzao)list0.get(3)));
                    zzg zzg1 = zzg0.zzc();
                    for(int v1 = 0; v1 < ((zzae)zzao6).zzh(); ++v1) {
                        String s4 = ((zzae)zzao6).zzl(v1).zzc();
                        zzg1.zze(s4, zzg0.zzh(s4));
                    }
                    while(zzg0.zza(zzao7).zze().booleanValue()) {
                        zzao zzao10 = zzg0.zzb(((zzae)zzao9));
                        if(zzao10 instanceof zzag) {
                            return (zzag)zzao10;
                        }
                        zzg zzg2 = zzg0.zzc();
                        for(int v2 = 0; v2 < ((zzae)zzao6).zzh(); ++v2) {
                            String s5 = ((zzae)zzao6).zzl(v2).zzc();
                            zzg2.zze(s5, zzg1.zzh(s5));
                        }
                        zzg2.zza(zzao8);
                        zzg1 = zzg2;
                    }
                    return zzao.zzf;
                }
                case 30: {
                    if(!(Z.i(zzbk.zzE, 3, list0, 0) instanceof zzas)) {
                        throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
                    }
                    String s6 = ((zzao)list0.get(0)).zzc();
                    zzao zzao11 = zzg0.zza(((zzao)list0.get(1)));
                    zzao zzao12 = zzg0.zza(((zzao)list0.get(2)));
                    return zzbg.zzd(new zzbf(zzg0, s6), zzao11, zzao12);
                }
                case 0x1F: {
                    if(!(Z.i(zzbk.zzF, 3, list0, 0) instanceof zzas)) {
                        throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                    }
                    String s7 = ((zzao)list0.get(0)).zzc();
                    zzao zzao13 = zzg0.zza(((zzao)list0.get(1)));
                    zzao zzao14 = zzg0.zza(((zzao)list0.get(2)));
                    return zzbg.zzd(new zzbc(zzg0, s7), zzao13, zzao14);
                }
                case 0x20: {
                    if(!(Z.i(zzbk.zzG, 3, list0, 0) instanceof zzas)) {
                        throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                    }
                    String s8 = ((zzao)list0.get(0)).zzc();
                    zzao zzao15 = zzg0.zza(((zzao)list0.get(1)));
                    zzao zzao16 = zzg0.zza(((zzao)list0.get(2)));
                    return zzbg.zzd(new zzbd(zzg0, s8), zzao15, zzao16);
                }
                default: {
                    return this.zzb(s);
                }
            }
        }
        zzao zzao17 = (zzao)Z.i(zzbk.zzan, 4, list0, 0);
        zzao zzao18 = (zzao)list0.get(1);
        zzao zzao19 = (zzao)list0.get(2);
        zzao zzao20 = zzg0.zza(((zzao)list0.get(3)));
        if(zzg0.zza(zzao19).zze().booleanValue()) {
            zzao zzao21 = zzg0.zzb(((zzae)zzao20));
            if(zzao21 instanceof zzag) {
                return (zzag)zzao21;
            }
        }
        while(zzg0.zza(zzao17).zze().booleanValue()) {
            zzao zzao22 = zzg0.zzb(((zzae)zzao20));
            if(zzao22 instanceof zzag) {
                return (zzag)zzao22;
            }
            zzg0.zza(zzao18);
        }
        return zzao.zzf;
    }

    private static zzao zzc(zzbe zzbe0, zzao zzao0, zzao zzao1) {
        return zzbg.zze(zzbe0, zzao0.zzf(), zzao1);
    }

    private static zzao zzd(zzbe zzbe0, zzao zzao0, zzao zzao1) {
        if(!(zzao0 instanceof Iterable)) {
            throw new IllegalArgumentException("Non-iterable type in for...of loop.");
        }
        return zzbg.zze(zzbe0, ((Iterable)zzao0).iterator(), zzao1);
    }

    private static zzao zze(zzbe zzbe0, Iterator iterator0, zzao zzao0) {
        if(iterator0 != null) {
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                zzao zzao1 = zzbe0.zza(((zzao)object0)).zzb(((zzae)zzao0));
                if(zzao1 instanceof zzag) {
                    return (zzag)zzao1;
                }
                if(false) {
                    break;
                }
            }
        }
        return zzao.zzf;
    }
}

