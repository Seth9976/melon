package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class zzba {
    public static zzao zza(String s, zzae zzae0, zzg zzg0, List list0) {
        double f2;
        double f;
        int v;
        switch(s) {
            case "concat": {
                v = 0;
                break;
            }
            case "every": {
                v = 1;
                break;
            }
            case "filter": {
                v = 2;
                break;
            }
            case "forEach": {
                v = 3;
                break;
            }
            case "indexOf": {
                v = 4;
                break;
            }
            case "join": {
                v = 5;
                break;
            }
            case "lastIndexOf": {
                v = 6;
                break;
            }
            case "map": {
                v = 7;
                break;
            }
            case "pop": {
                v = 8;
                break;
            }
            case "push": {
                v = 9;
                break;
            }
            case "reduce": {
                v = 10;
                break;
            }
            case "reduceRight": {
                v = 11;
                break;
            }
            case "reverse": {
                v = 12;
                break;
            }
            case "shift": {
                v = 13;
                break;
            }
            case "slice": {
                v = 14;
                break;
            }
            case "some": {
                v = 15;
                break;
            }
            case "sort": {
                v = 16;
                break;
            }
            case "splice": {
                v = 17;
                break;
            }
            case "toString": {
                v = 18;
                break;
            }
            case "unshift": {
                v = 19;
                break;
            }
            default: {
                v = -1;
            }
        }
        String s1 = ",";
        zzai zzai0 = null;
        switch(v) {
            case 0: {
                zzao zzao0 = (zzae)zzae0.zzt();
                if(!list0.isEmpty()) {
                    for(Object object0: list0) {
                        zzao zzao1 = zzg0.zza(((zzao)object0));
                        if(zzao1 instanceof zzag) {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                        int v1 = ((zzae)zzao0).zzh();
                        if(zzao1 instanceof zzae) {
                            zzae zzae1 = (zzae)zzao1;
                            Iterator iterator1 = zzae1.zzg();
                            while(iterator1.hasNext()) {
                                Object object1 = iterator1.next();
                                ((zzae)zzao0).zzn(((int)(((Integer)object1))) + v1, zzae1.zzl(((int)(((Integer)object1)))));
                            }
                        }
                        else {
                            ((zzae)zzao0).zzn(v1, zzao1);
                        }
                    }
                }
                return zzao0;
            }
            case 1: {
                zzh.zza("every", 1, list0);
                zzao zzao2 = zzg0.zza(((zzao)list0.get(0)));
                if(!(zzao2 instanceof zzan)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if(zzae0.zzh() == 0) {
                    return zzao.zzk;
                }
                return zzba.zzc(zzae0, zzg0, ((zzan)zzao2), Boolean.FALSE, Boolean.TRUE).zzh() == zzae0.zzh() ? zzao.zzk : zzao.zzl;
            }
            case 2: {
                zzh.zza("filter", 1, list0);
                zzao zzao3 = zzg0.zza(((zzao)list0.get(0)));
                if(!(zzao3 instanceof zzan)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if(zzae0.zzi() == 0) {
                    return new zzae();
                }
                zzae zzae2 = (zzae)zzae0.zzt();
                zzae zzae3 = zzba.zzc(zzae0, zzg0, ((zzan)zzao3), null, Boolean.TRUE);
                zzao zzao4 = new zzae();
                Iterator iterator2 = zzae3.zzg();
                while(iterator2.hasNext()) {
                    Object object2 = iterator2.next();
                    zzao zzao5 = zzae2.zzl(((int)(((Integer)object2))));
                    ((zzae)zzao4).zzn(((zzae)zzao4).zzh(), zzao5);
                }
                return zzao4;
            }
            case 3: {
                zzh.zza("forEach", 1, list0);
                zzao zzao6 = zzg0.zza(((zzao)list0.get(0)));
                if(!(zzao6 instanceof zzan)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if(zzae0.zzi() == 0) {
                    return zzao.zzf;
                }
                zzba.zzc(zzae0, zzg0, ((zzan)zzao6), null, null);
                return zzao.zzf;
            }
            case 4: {
                zzh.zzc("indexOf", 2, list0);
                zzao zzao7 = list0.isEmpty() ? zzao.zzf : zzg0.zza(((zzao)list0.get(0)));
                if(list0.size() > 1) {
                    f = zzh.zzi(((double)zzg0.zza(((zzao)list0.get(1))).zzd()));
                    if(f >= ((double)zzae0.zzh())) {
                        return new zzah(-1.0);
                    }
                    if(f < 0.0) {
                        f += (double)zzae0.zzh();
                    }
                }
                else {
                    f = 0.0;
                }
                Iterator iterator3 = zzae0.zzg();
                while(iterator3.hasNext()) {
                    Object object3 = iterator3.next();
                    int v2 = (int)(((Integer)object3));
                    double f1 = (double)v2;
                    if(f1 >= f && zzh.zzf(zzae0.zzl(v2), zzao7)) {
                        return new zzah(f1);
                    }
                    if(false) {
                        break;
                    }
                }
                return new zzah(-1.0);
            }
            case 5: {
                zzh.zzc("join", 1, list0);
                if(zzae0.zzh() == 0) {
                    return zzao.zzm;
                }
                if(!list0.isEmpty()) {
                    zzao zzao8 = zzg0.zza(((zzao)list0.get(0)));
                    if(!(zzao8 instanceof zzam) && !(zzao8 instanceof zzat)) {
                        return new zzas(zzae0.zzs(zzao8.zzc()));
                    }
                    s1 = "";
                }
                return new zzas(zzae0.zzs(s1));
            }
            case 6: {
                zzh.zzc("lastIndexOf", 2, list0);
                zzao zzao9 = list0.isEmpty() ? zzao.zzf : zzg0.zza(((zzao)list0.get(0)));
                int v3 = zzae0.zzh();
                if(list0.size() > 1) {
                    zzao zzao10 = zzg0.zza(((zzao)list0.get(1)));
                    f2 = Double.isNaN(((double)zzao10.zzd())) ? ((double)(zzae0.zzh() - 1)) : zzh.zzi(((double)zzao10.zzd()));
                    if(f2 < 0.0) {
                        f2 += (double)zzae0.zzh();
                    }
                }
                else {
                    f2 = (double)(v3 - 1);
                }
                if(f2 < 0.0) {
                    return new zzah(-1.0);
                }
                for(int v4 = (int)Math.min(zzae0.zzh(), f2); v4 >= 0; --v4) {
                    if(zzae0.zzo(v4) && zzh.zzf(zzae0.zzl(v4), zzao9)) {
                        return new zzah(((double)v4));
                    }
                }
                return new zzah(-1.0);
            }
            case 7: {
                zzh.zza("map", 1, list0);
                zzao zzao11 = zzg0.zza(((zzao)list0.get(0)));
                if(!(zzao11 instanceof zzan)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                return zzae0.zzh() == 0 ? new zzae() : zzba.zzc(zzae0, zzg0, ((zzan)zzao11), null, null);
            }
            case 8: {
                zzh.zza("pop", 0, list0);
                int v5 = zzae0.zzh();
                if(v5 == 0) {
                    return zzao.zzf;
                }
                zzao zzao12 = zzae0.zzl(v5 - 1);
                zzae0.zzr(v5 - 1);
                return zzao12;
            }
            case 9: {
                if(!list0.isEmpty()) {
                    for(Object object4: list0) {
                        zzao zzao13 = zzg0.zza(((zzao)object4));
                        zzae0.zzn(zzae0.zzh(), zzao13);
                    }
                }
                return new zzah(((double)zzae0.zzh()));
            }
            case 10: {
                return zzba.zzb(zzae0, zzg0, list0, true);
            }
            case 11: {
                return zzba.zzb(zzae0, zzg0, list0, false);
            }
            case 12: {
                zzh.zza("reverse", 0, list0);
                int v14 = zzae0.zzh();
                if(v14 != 0) {
                    for(int v15 = 0; v15 < v14 / 2; ++v15) {
                        if(zzae0.zzo(v15)) {
                            zzao zzao23 = zzae0.zzl(v15);
                            zzae0.zzn(v15, null);
                            int v16 = v14 - 1 - v15;
                            if(zzae0.zzo(v16)) {
                                zzae0.zzn(v15, zzae0.zzl(v16));
                            }
                            zzae0.zzn(v16, zzao23);
                        }
                    }
                    return zzae0;
                }
                break;
            }
            case 13: {
                zzh.zza("shift", 0, list0);
                if(zzae0.zzh() == 0) {
                    return zzao.zzf;
                }
                zzao zzao14 = zzae0.zzl(0);
                zzae0.zzr(0);
                return zzao14;
            }
            case 14: {
                zzh.zzc("slice", 2, list0);
                if(list0.isEmpty()) {
                    return zzae0.zzt();
                }
                double f3 = (double)zzae0.zzh();
                double f4 = zzh.zzi(((double)zzg0.zza(((zzao)list0.get(0))).zzd()));
                double f5 = f4 < 0.0 ? Math.max(f4 + f3, 0.0) : Math.min(f4, f3);
                if(list0.size() == 2) {
                    double f6 = zzh.zzi(((double)zzg0.zza(((zzao)list0.get(1))).zzd()));
                    f3 = f6 < 0.0 ? Math.max(f3 + f6, 0.0) : Math.min(f3, f6);
                }
                zzao zzao15 = new zzae();
                for(int v6 = (int)f5; ((double)v6) < f3; ++v6) {
                    zzao zzao16 = zzae0.zzl(v6);
                    ((zzae)zzao15).zzn(((zzae)zzao15).zzh(), zzao16);
                }
                return zzao15;
            }
            case 15: {
                zzh.zza("some", 1, list0);
                zzao zzao17 = zzg0.zza(((zzao)list0.get(0)));
                if(!(zzao17 instanceof zzai)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if(zzae0.zzh() == 0) {
                    return zzao.zzl;
                }
                Iterator iterator5 = zzae0.zzg();
                while(iterator5.hasNext()) {
                    Object object5 = iterator5.next();
                    int v7 = (int)(((Integer)object5));
                    if(zzae0.zzo(v7) && ((zzai)zzao17).zza(zzg0, Arrays.asList(new zzao[]{zzae0.zzl(v7), new zzah(((double)v7)), zzae0})).zze().booleanValue()) {
                        return zzao.zzk;
                    }
                    if(false) {
                        break;
                    }
                }
                return zzao.zzl;
            }
            case 16: {
                zzh.zzc("sort", 1, list0);
                if(zzae0.zzh() >= 2) {
                    List list1 = zzae0.zzb();
                    if(!list0.isEmpty()) {
                        zzao zzao24 = zzg0.zza(((zzao)list0.get(0)));
                        if(!(zzao24 instanceof zzai)) {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                        zzai0 = (zzai)zzao24;
                    }
                    Collections.sort(list1, new zzaz(zzai0, zzg0));
                    zzae0.zzp();
                    Iterator iterator9 = list1.iterator();
                    for(int v17 = 0; true; ++v17) {
                        if(!iterator9.hasNext()) {
                            break;
                        }
                        Object object9 = iterator9.next();
                        zzae0.zzn(v17, ((zzao)object9));
                    }
                }
                break;
            }
            case 17: {
                if(list0.isEmpty()) {
                    return new zzae();
                }
                int v8 = (int)zzh.zzi(((double)zzg0.zza(((zzao)list0.get(0))).zzd()));
                if(v8 < 0) {
                    v8 = Math.max(0, zzae0.zzh() + v8);
                }
                else if(v8 > zzae0.zzh()) {
                    v8 = zzae0.zzh();
                }
                int v9 = zzae0.zzh();
                zzao zzao18 = new zzae();
                if(list0.size() > 1) {
                    int v10 = Math.max(0, ((int)zzh.zzi(((double)zzg0.zza(((zzao)list0.get(1))).zzd()))));
                    if(v10 > 0) {
                        for(int v11 = v8; v11 < Math.min(v9, v8 + v10); ++v11) {
                            zzao zzao19 = zzae0.zzl(v8);
                            ((zzae)zzao18).zzn(((zzae)zzao18).zzh(), zzao19);
                            zzae0.zzr(v8);
                        }
                    }
                    if(list0.size() > 2) {
                        for(int v12 = 2; v12 < list0.size(); ++v12) {
                            zzao zzao20 = zzg0.zza(((zzao)list0.get(v12)));
                            if(zzao20 instanceof zzag) {
                                throw new IllegalArgumentException("Failed to parse elements to add");
                            }
                            zzae0.zzq(v8 + v12 - 2, zzao20);
                        }
                    }
                }
                else {
                    while(v8 < v9) {
                        zzao zzao21 = zzae0.zzl(v8);
                        ((zzae)zzao18).zzn(((zzae)zzao18).zzh(), zzao21);
                        zzae0.zzn(v8, null);
                        ++v8;
                    }
                }
                return zzao18;
            }
            case 18: {
                zzh.zza("toString", 0, list0);
                return new zzas("");
            }
            case 19: {
                if(!list0.isEmpty()) {
                    zzae zzae4 = new zzae();
                    for(Object object6: list0) {
                        zzao zzao22 = zzg0.zza(((zzao)object6));
                        if(zzao22 instanceof zzag) {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                        zzae4.zzn(zzae4.zzh(), zzao22);
                    }
                    int v13 = zzae4.zzh();
                    Iterator iterator7 = zzae0.zzg();
                    while(iterator7.hasNext()) {
                        Object object7 = iterator7.next();
                        zzae4.zzn(((int)(((Integer)object7))) + v13, zzae0.zzl(((int)(((Integer)object7)))));
                    }
                    zzae0.zzp();
                    Iterator iterator8 = zzae4.zzg();
                    while(iterator8.hasNext()) {
                        Object object8 = iterator8.next();
                        zzae0.zzn(((int)(((Integer)object8))), zzae4.zzl(((int)(((Integer)object8)))));
                    }
                }
                return new zzah(((double)zzae0.zzh()));
            }
            default: {
                throw new IllegalArgumentException("Command not supported");
            }
        }
        return zzae0;
    }

    private static zzao zzb(zzae zzae0, zzg zzg0, List list0, boolean z) {
        zzao zzao1;
        zzh.zzb("reduce", 1, list0);
        zzh.zzc("reduce", 2, list0);
        zzao zzao0 = zzg0.zza(((zzao)list0.get(0)));
        if(!(zzao0 instanceof zzai)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if(list0.size() == 2) {
            zzao1 = zzg0.zza(((zzao)list0.get(1)));
            if(zzao1 instanceof zzag) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        }
        else {
            if(zzae0.zzh() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            zzao1 = null;
        }
        int v = zzae0.zzh();
        int v1 = z ? 0 : v - 1;
        if(zzao1 == null) {
            zzao1 = zzae0.zzl(v1);
            v1 += (z ? 1 : -1);
        }
        while(((z ? v - 1 : 0) - v1) * (z ? 1 : -1) >= 0) {
            if(zzae0.zzo(v1)) {
                zzao1 = ((zzai)zzao0).zza(zzg0, Arrays.asList(new zzao[]{zzao1, zzae0.zzl(v1), new zzah(((double)v1)), zzae0}));
                if(zzao1 instanceof zzag) {
                    throw new IllegalStateException("Reduce operation failed");
                }
            }
            v1 += (z ? 1 : -1);
        }
        return zzao1;
    }

    private static zzae zzc(zzae zzae0, zzg zzg0, zzai zzai0, Boolean boolean0, Boolean boolean1) {
        zzae zzae1 = new zzae();
        Iterator iterator0 = zzae0.zzg();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            int v = (int)(((Integer)object0));
            if(zzae0.zzo(v)) {
                zzao zzao0 = zzai0.zza(zzg0, Arrays.asList(new zzao[]{zzae0.zzl(v), new zzah(((double)v)), zzae0}));
                if(zzao0.zze().equals(boolean0)) {
                    break;
                }
                if(boolean1 == null || zzao0.zze().equals(boolean1)) {
                    zzae1.zzn(v, zzao0);
                }
            }
        }
        return zzae1;
    }
}

