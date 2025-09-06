package com.google.android.gms.internal.measurement;

import androidx.appcompat.app.o;
import b3.Z;
import java.util.List;
import va.e;

public final class zzbj extends zzav {
    public zzbj() {
        this.zza.add(zzbk.zzd);
        this.zza.add(zzbk.zzo);
        this.zza.add(zzbk.zzr);
        this.zza.add(zzbk.zzs);
        this.zza.add(zzbk.zzy);
        this.zza.add(zzbk.zzH);
        this.zza.add(zzbk.zzJ);
        this.zza.add(zzbk.zzK);
        this.zza.add(zzbk.zzX);
        this.zza.add(zzbk.zzag);
        this.zza.add(zzbk.zzak);
        this.zza.add(zzbk.zzal);
        this.zza.add(zzbk.zzam);
    }

    @Override  // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String s, zzg zzg0, List list0) {
        int v = 0;
        switch(zzh.zze(s).ordinal()) {
            case 3: {
                zzao zzao0 = zzg0.zza(((zzao)Z.i(zzbk.zzd, 2, list0, 0)));
                if(!(zzao0 instanceof zzas)) {
                    throw new IllegalArgumentException(e.b("Expected string for assign var. got ", zzao0.getClass().getCanonicalName()));
                }
                if(!zzg0.zzd(zzao0.zzc())) {
                    throw new IllegalArgumentException(e.b("Attempting to assign undefined value ", zzao0.zzc()));
                }
                zzao zzao1 = zzg0.zza(((zzao)list0.get(1)));
                zzg0.zze(zzao0.zzc(), zzao1);
                return zzao1;
            }
            case 14: {
                zzh.zzb("CONST", 2, list0);
                if(list0.size() % 2 != 0) {
                    throw new IllegalArgumentException("CONST requires an even number of arguments, found " + list0.size());
                }
                while(v < list0.size() - 1) {
                    zzao zzao2 = zzg0.zza(((zzao)list0.get(v)));
                    if(!(zzao2 instanceof zzas)) {
                        throw new IllegalArgumentException(e.b("Expected string for const name. got ", zzao2.getClass().getCanonicalName()));
                    }
                    zzg0.zzg(zzao2.zzc(), zzg0.zza(((zzao)list0.get(v + 1))));
                    v += 2;
                }
                return zzao.zzf;
            }
            case 17: {
                if(list0.isEmpty()) {
                    return new zzae();
                }
                zzao zzao3 = new zzae();
                for(Object object0: list0) {
                    zzao zzao4 = zzg0.zza(((zzao)object0));
                    if(zzao4 instanceof zzag) {
                        throw new IllegalStateException("Failed to evaluate array element");
                    }
                    ((zzae)zzao3).zzn(v, zzao4);
                    ++v;
                }
                return zzao3;
            }
            case 18: {
                if(list0.isEmpty()) {
                    return new zzal();
                }
                if(list0.size() % 2 != 0) {
                    throw new IllegalArgumentException("CREATE_OBJECT requires an even number of arguments, found " + list0.size());
                }
                zzao zzao5 = new zzal();
                while(v < list0.size() - 1) {
                    zzao zzao6 = zzg0.zza(((zzao)list0.get(v)));
                    zzao zzao7 = zzg0.zza(((zzao)list0.get(v + 1)));
                    if(zzao6 instanceof zzag || zzao7 instanceof zzag) {
                        throw new IllegalStateException("Failed to evaluate map entry");
                    }
                    ((zzal)zzao5).zzm(zzao6.zzc(), zzao7);
                    v += 2;
                }
                return zzao5;
            }
            case 24: {
                zzh.zzb("EXPRESSION_LIST", 1, list0);
                zzao zzao8 = zzao.zzf;
                while(v < list0.size()) {
                    zzao8 = zzg0.zza(((zzao)list0.get(v)));
                    if(zzao8 instanceof zzag) {
                        throw new IllegalStateException("ControlValue cannot be in an expression list");
                    }
                    ++v;
                }
                return zzao8;
            }
            case 33: {
                zzao zzao9 = zzg0.zza(((zzao)Z.i(zzbk.zzH, 1, list0, 0)));
                if(!(zzao9 instanceof zzas)) {
                    throw new IllegalArgumentException(e.b("Expected string for get var. got ", zzao9.getClass().getCanonicalName()));
                }
                return zzg0.zzh(zzao9.zzc());
            }
            case 35: 
            case 36: {
                zzao zzao10 = zzg0.zza(((zzao)Z.i(zzbk.zzK, 2, list0, 0)));
                zzao zzao11 = zzg0.zza(((zzao)list0.get(1)));
                if(zzao10 instanceof zzae && zzh.zzd(zzao11)) {
                    return ((zzae)zzao10).zzl(zzao11.zzd().intValue());
                }
                if(zzao10 instanceof zzak) {
                    return ((zzak)zzao10).zzk(zzao11.zzc());
                }
                if(zzao10 instanceof zzas) {
                    if("length".equals(zzao11.zzc())) {
                        return new zzah(((double)zzao10.zzc().length()));
                    }
                    if(zzh.zzd(zzao11) && ((double)zzao11.zzd()) < ((double)zzao10.zzc().length())) {
                        return new zzas(String.valueOf(zzao10.zzc().charAt(zzao11.zzd().intValue())));
                    }
                }
                return zzao.zzf;
            }
            case 49: {
                zzh.zza("NULL", 0, list0);
                return zzao.zzg;
            }
            case 58: {
                zzao zzao12 = zzg0.zza(((zzao)Z.i(zzbk.zzag, 3, list0, 0)));
                zzao zzao13 = zzg0.zza(((zzao)list0.get(1)));
                zzao zzao14 = zzg0.zza(((zzao)list0.get(2)));
                if(zzao12 == zzao.zzf || zzao12 == zzao.zzg) {
                    throw new IllegalStateException(o.o("Can\'t set property ", zzao13.zzc(), " of ", zzao12.zzc()));
                }
                if(zzao12 instanceof zzae && zzao13 instanceof zzah) {
                    ((zzae)zzao12).zzn(zzao13.zzd().intValue(), zzao14);
                    return zzao14;
                }
                if(!(zzao12 instanceof zzak)) {
                    return zzao14;
                }
                ((zzak)zzao12).zzm(zzao13.zzc(), zzao14);
                return zzao14;
            }
            case 62: {
                zzao zzao15 = zzg0.zza(((zzao)Z.i(zzbk.zzak, 1, list0, 0)));
                if(zzao15 instanceof zzat) {
                    return new zzas("undefined");
                }
                if(zzao15 instanceof zzaf) {
                    return new zzas("boolean");
                }
                if(zzao15 instanceof zzah) {
                    return new zzas("number");
                }
                if(zzao15 instanceof zzas) {
                    return new zzas("string");
                }
                if(zzao15 instanceof zzan) {
                    return new zzas("function");
                }
                if(zzao15 instanceof zzap || zzao15 instanceof zzag) {
                    throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", zzao15));
                }
                return new zzas("object");
            }
            case 0x3F: {
                zzh.zza("UNDEFINED", 0, list0);
                return zzao.zzf;
            }
            case 0x40: {
                zzh.zzb("VAR", 1, list0);
                for(Object object1: list0) {
                    zzao zzao16 = zzg0.zza(((zzao)object1));
                    if(!(zzao16 instanceof zzas)) {
                        throw new IllegalArgumentException(e.b("Expected string for var name. got ", zzao16.getClass().getCanonicalName()));
                    }
                    zzg0.zzf(zzao16.zzc(), zzao.zzf);
                }
                return zzao.zzf;
            }
            default: {
                return this.zzb(s);
            }
        }
    }
}

