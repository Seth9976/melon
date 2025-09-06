package com.google.android.gms.internal.measurement;

import b3.Z;
import java.util.ArrayList;
import java.util.List;
import va.e;

public final class zzay extends zzav {
    public zzay() {
        this.zza.add(zzbk.zzc);
        this.zza.add(zzbk.zzl);
        this.zza.add(zzbk.zzm);
        this.zza.add(zzbk.zzn);
        this.zza.add(zzbk.zzt);
        this.zza.add(zzbk.zzp);
        this.zza.add(zzbk.zzu);
        this.zza.add(zzbk.zzz);
        this.zza.add(zzbk.zzP);
        this.zza.add(zzbk.zzac);
        this.zza.add(zzbk.zzaf);
        this.zza.add(zzbk.zzai);
        this.zza.add(zzbk.zzaj);
    }

    @Override  // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String s, zzg zzg0, List list0) {
        zzao zzao8;
        switch(zzh.zze(s).ordinal()) {
            case 2: {
                zzao zzao0 = zzg0.zza(((zzao)Z.i(zzbk.zzc, 3, list0, 0)));
                String s1 = zzg0.zza(((zzao)list0.get(1))).zzc();
                zzao zzao1 = zzg0.zza(((zzao)list0.get(2)));
                if(!(zzao1 instanceof zzae)) {
                    throw new IllegalArgumentException(e.b("Function arguments for Apply are not a list found ", zzao1.getClass().getCanonicalName()));
                }
                if(s1.isEmpty()) {
                    throw new IllegalArgumentException("Function name for apply is undefined");
                }
                return zzao0.zzcA(s1, zzg0, ((zzae)zzao1).zzb());
            }
            case 11: {
                return zzg0.zzc().zzb(new zzae(list0));
            }
            case 12: {
                zzh.zza("BREAK", 0, list0);
                return zzao.zzi;
            }
            case 15: {
                zzh.zza("BREAK", 0, list0);
                return zzao.zzh;
            }
            case 13: 
            case 19: {
                if(list0.isEmpty()) {
                    return zzao.zzf;
                }
                zzao zzao2 = zzg0.zza(((zzao)list0.get(0)));
                return zzao2 instanceof zzae ? zzg0.zzb(((zzae)zzao2)) : zzao.zzf;
            }
            case 20: {
                zzh.zzb("DEFINE_FUNCTION", 2, list0);
                zzao zzao3 = (zzan)zzay.zzc(zzg0, list0);
                if(((zzai)zzao3).zzg() == null) {
                    zzg0.zze("", zzao3);
                    return zzao3;
                }
                zzg0.zze(((zzai)zzao3).zzg(), zzao3);
                return zzao3;
            }
            case 25: {
                return zzay.zzc(zzg0, list0);
            }
            case 41: {
                zzh.zzb("IF", 2, list0);
                zzao zzao4 = zzg0.zza(((zzao)list0.get(0)));
                zzao zzao5 = zzg0.zza(((zzao)list0.get(1)));
                zzao zzao6 = list0.size() <= 2 ? null : zzg0.zza(((zzao)list0.get(2)));
                zzao zzao7 = zzao.zzf;
                if(zzao4.zze().booleanValue()) {
                    zzao8 = zzg0.zzb(((zzae)zzao5));
                    return zzao8 instanceof zzag ? zzao8 : zzao7;
                }
                zzao8 = zzao6 == null ? zzao7 : zzg0.zzb(((zzae)zzao6));
                return zzao8 instanceof zzag ? zzao8 : zzao7;
            }
            case 54: {
                return new zzae(list0);
            }
            case 57: {
                return list0.isEmpty() ? zzao.zzj : new zzag("return", zzg0.zza(((zzao)Z.i(zzbk.zzaf, 1, list0, 0))));
            }
            case 60: {
                zzao zzao9 = zzg0.zza(((zzao)Z.i(zzbk.zzai, 3, list0, 0)));
                zzao zzao10 = zzg0.zza(((zzao)list0.get(1)));
                zzao zzao11 = zzg0.zza(((zzao)list0.get(2)));
                if(!(zzao10 instanceof zzae)) {
                    throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                }
                if(!(zzao11 instanceof zzae)) {
                    throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                }
                boolean z = false;
                for(int v = 0; v < ((zzae)zzao10).zzh(); ++v) {
                    if(z || zzao9.equals(zzg0.zza(((zzae)zzao10).zzl(v)))) {
                        zzao zzao12 = zzg0.zza(((zzae)zzao11).zzl(v));
                        if(zzao12 instanceof zzag) {
                            return zzao12;
                        }
                        z = true;
                    }
                    else {
                        z = false;
                    }
                }
                if(((zzae)zzao10).zzh() + 1 == ((zzae)zzao11).zzh()) {
                    zzao zzao13 = zzg0.zza(((zzae)zzao11).zzl(((zzae)zzao10).zzh()));
                    return zzao13 instanceof zzag ? zzao13 : zzao.zzf;
                }
                return zzao.zzf;
            }
            case 61: {
                return zzg0.zza(((zzao)Z.i(zzbk.zzaj, 3, list0, 0))).zze().booleanValue() ? zzg0.zza(((zzao)list0.get(1))) : zzg0.zza(((zzao)list0.get(2)));
            }
            default: {
                return this.zzb(s);
            }
        }
    }

    private static zzao zzc(zzg zzg0, List list0) {
        zzh.zzb("FN", 2, list0);
        zzao zzao0 = zzg0.zza(((zzao)list0.get(0)));
        zzao zzao1 = zzg0.zza(((zzao)list0.get(1)));
        if(!(zzao1 instanceof zzae)) {
            throw new IllegalArgumentException(e.b("FN requires an ArrayValue of parameter names found ", zzao1.getClass().getCanonicalName()));
        }
        List list1 = ((zzae)zzao1).zzb();
        List list2 = new ArrayList();
        if(list0.size() > 2) {
            list2 = list0.subList(2, list0.size());
        }
        return new zzan(zzao0.zzc(), list1, list2, zzg0);
    }
}

