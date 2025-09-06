package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k8.Y;

public final class zzas implements zzao, Iterable {
    private final String zza;

    public zzas(String s) {
        if(s == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzas ? this.zza.equals(((zzas)object0).zza) : false;
    }

    @Override
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override
    public final Iterator iterator() {
        return new zzar(this);
    }

    @Override
    public final String toString() {
        return Y.l(new StringBuilder(this.zza.length() + 2), "\"", this.zza, "\"");
    }

    public final String zzb() {
        return this.zza;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return this.zza;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String s, zzg zzg0, List list0) {
        boolean z1;
        int v3;
        int v;
        if(!"charAt".equals(s) && !"concat".equals(s) && !"hasOwnProperty".equals(s) && !"indexOf".equals(s) && !"lastIndexOf".equals(s) && !"match".equals(s) && !"replace".equals(s) && !"search".equals(s) && !"slice".equals(s) && !"split".equals(s) && !"substring".equals(s) && !"toLowerCase".equals(s) && !"toLocaleLowerCase".equals(s) && !"toString".equals(s) && !"toUpperCase".equals(s) && !"toLocaleUpperCase".equals(s) && !"trim".equals(s)) {
            throw new IllegalArgumentException(s + " is not a String function");
        }
        switch(s) {
            case "charAt": {
                v = 0;
                break;
            }
            case "concat": {
                v = 1;
                break;
            }
            case "hasOwnProperty": {
                v = 2;
                break;
            }
            case "indexOf": {
                v = 3;
                break;
            }
            case "lastIndexOf": {
                v = 4;
                break;
            }
            case "match": {
                v = 5;
                break;
            }
            case "replace": {
                v = 6;
                break;
            }
            case "search": {
                v = 7;
                break;
            }
            case "slice": {
                v = 8;
                break;
            }
            case "split": {
                v = 9;
                break;
            }
            case "substring": {
                v = 10;
                break;
            }
            case "toLocaleLowerCase": {
                v = 12;
                break;
            }
            case "toLocaleUpperCase": {
                v = 11;
                break;
            }
            case "toLowerCase": {
                v = 13;
                break;
            }
            case "toString": {
                v = 14;
                break;
            }
            case "toUpperCase": {
                v = 15;
                break;
            }
            case "trim": {
                v = 16;
                break;
            }
            default: {
                v = -1;
            }
        }
        String s1 = "undefined";
        double f = 0.0;
        switch(v) {
            case 0: {
                zzh.zzc("charAt", 1, list0);
                int v1 = list0.isEmpty() ? 0 : ((int)zzh.zzi(((double)zzg0.zza(((zzao)list0.get(0))).zzd())));
                String s2 = this.zza;
                return v1 >= 0 && v1 < s2.length() ? new zzas(String.valueOf(s2.charAt(v1))) : zzao.zzm;
            }
            case 1: {
                if(!list0.isEmpty()) {
                    StringBuilder stringBuilder0 = new StringBuilder(this.zza);
                    for(int v9 = 0; v9 < list0.size(); ++v9) {
                        stringBuilder0.append(zzg0.zza(((zzao)list0.get(v9))).zzc());
                    }
                    return new zzas(stringBuilder0.toString());
                }
                break;
            }
            case 2: {
                zzh.zza("hasOwnProperty", 1, list0);
                String s3 = this.zza;
                zzao zzao0 = zzg0.zza(((zzao)list0.get(0)));
                if("length".equals(zzao0.zzc())) {
                    return zzao.zzk;
                }
                double f1 = (double)zzao0.zzd();
                return f1 != Math.floor(f1) || ((int)f1) < 0 || ((int)f1) >= s3.length() ? zzao.zzl : zzao.zzk;
            }
            case 3: {
                zzh.zzc("indexOf", 2, list0);
                String s4 = this.zza;
                if(list0.size() > 0) {
                    s1 = zzg0.zza(((zzao)list0.get(0))).zzc();
                }
                if(list0.size() >= 2) {
                    f = (double)zzg0.zza(((zzao)list0.get(1))).zzd();
                }
                return new zzah(((double)s4.indexOf(s1, ((int)zzh.zzi(f)))));
            }
            case 4: {
                zzh.zzc("lastIndexOf", 2, list0);
                String s5 = this.zza;
                if(list0.size() > 0) {
                    s1 = zzg0.zza(((zzao)list0.get(0))).zzc();
                }
                double f2 = list0.size() >= 2 ? ((double)zzg0.zza(((zzao)list0.get(1))).zzd()) : NaN;
                return Double.isNaN(f2) ? new zzah(((double)s5.lastIndexOf(s1, 0x7FFFFFFF))) : new zzah(((double)s5.lastIndexOf(s1, ((int)zzh.zzi(f2)))));
            }
            case 5: {
                zzh.zzc("match", 1, list0);
                Matcher matcher0 = Pattern.compile((list0.size() > 0 ? zzg0.zza(((zzao)list0.get(0))).zzc() : "")).matcher(this.zza);
                return matcher0.find() ? new zzae(Arrays.asList(new zzao[]{new zzas(matcher0.group())})) : zzao.zzg;
            }
            case 6: {
                zzh.zzc("replace", 2, list0);
                zzao zzao1 = zzao.zzf;
                if(!list0.isEmpty()) {
                    s1 = zzg0.zza(((zzao)list0.get(0))).zzc();
                    if(list0.size() > 1) {
                        zzao1 = zzg0.zza(((zzao)list0.get(1)));
                    }
                }
                String s8 = this.zza;
                int v10 = s8.indexOf(s1);
                if(v10 >= 0) {
                    if(zzao1 instanceof zzai) {
                        zzao1 = ((zzai)zzao1).zza(zzg0, Arrays.asList(new zzao[]{new zzas(s1), new zzah(((double)v10)), this}));
                    }
                    String s9 = s8.substring(0, v10);
                    String s10 = zzao1.zzc();
                    String s11 = s8.substring(s1.length() + v10);
                    return new zzas(Y.l(new StringBuilder(String.valueOf(s9).length() + String.valueOf(s10).length() + String.valueOf(s11).length()), s9, s10, s11));
                }
                break;
            }
            case 7: {
                zzh.zzc("search", 1, list0);
                if(!list0.isEmpty()) {
                    s1 = zzg0.zza(((zzao)list0.get(0))).zzc();
                }
                Matcher matcher1 = Pattern.compile(s1).matcher(this.zza);
                return matcher1.find() ? new zzah(((double)matcher1.start())) : new zzah(-1.0);
            }
            case 8: {
                zzh.zzc("slice", 2, list0);
                double f3 = zzh.zzi((list0.isEmpty() ? 0.0 : ((double)zzg0.zza(((zzao)list0.get(0))).zzd())));
                double f4 = f3 < 0.0 ? Math.max(((double)this.zza.length()) + f3, 0.0) : Math.min(f3, this.zza.length());
                double f5 = zzh.zzi((list0.size() <= 1 ? ((double)this.zza.length()) : ((double)zzg0.zza(((zzao)list0.get(1))).zzd())));
                return f5 < 0.0 ? new zzas(this.zza.substring(((int)f4), Math.max(0, ((int)Math.max(((double)this.zza.length()) + f5, 0.0)) - ((int)f4)) + ((int)f4))) : new zzas(this.zza.substring(((int)f4), Math.max(0, ((int)Math.min(f5, this.zza.length())) - ((int)f4)) + ((int)f4)));
            }
            case 9: {
                zzh.zzc("split", 2, list0);
                String s6 = this.zza;
                if(s6.length() == 0) {
                    return new zzae(Arrays.asList(new zzao[]{this}));
                }
                ArrayList arrayList0 = new ArrayList();
                if(list0.isEmpty()) {
                    arrayList0.add(this);
                    return new zzae(arrayList0);
                }
                String s7 = zzg0.zza(((zzao)list0.get(0))).zzc();
                long v2 = list0.size() <= 1 ? 0x7FFFFFFFL : zzh.zzh(((double)zzg0.zza(((zzao)list0.get(1))).zzd()));
                if(v2 == 0L) {
                    return new zzae();
                }
                String[] arr_s = s6.split(Pattern.quote(s7), ((int)v2) + 1);
                if(!s7.isEmpty() || arr_s.length <= 0) {
                    v3 = arr_s.length;
                    z1 = false;
                }
                else {
                    boolean z = arr_s[0].isEmpty();
                    v3 = arr_s[arr_s.length - 1].isEmpty() ? arr_s.length - 1 : arr_s.length;
                    z1 = z;
                }
                if(((long)arr_s.length) > v2) {
                    --v3;
                }
                for(int v4 = z1; v4 < v3; ++v4) {
                    arrayList0.add(new zzas(arr_s[v4]));
                }
                return new zzae(arrayList0);
            }
            case 10: {
                zzh.zzc("substring", 2, list0);
                int v5 = list0.isEmpty() ? 0 : ((int)zzh.zzi(((double)zzg0.zza(((zzao)list0.get(0))).zzd())));
                int v6 = list0.size() <= 1 ? this.zza.length() : ((int)zzh.zzi(((double)zzg0.zza(((zzao)list0.get(1))).zzd())));
                int v7 = Math.min(Math.max(v5, 0), this.zza.length());
                int v8 = Math.min(Math.max(v6, 0), this.zza.length());
                return new zzas(this.zza.substring(Math.min(v7, v8), Math.max(v7, v8)));
            }
            case 11: {
                zzh.zza("toLocaleUpperCase", 0, list0);
                return new zzas(this.zza.toUpperCase());
            }
            case 12: {
                zzh.zza("toLocaleLowerCase", 0, list0);
                return new zzas(this.zza.toLowerCase());
            }
            case 13: {
                zzh.zza("toLowerCase", 0, list0);
                return new zzas(this.zza.toLowerCase(Locale.ENGLISH));
            }
            case 14: {
                zzh.zza("toString", 0, list0);
                return this;
            }
            case 15: {
                zzh.zza("toUpperCase", 0, list0);
                return new zzas(this.zza.toUpperCase(Locale.ENGLISH));
            }
            case 16: {
                zzh.zza("toUpperCase", 0, list0);
                return new zzas(this.zza.trim());
            }
            default: {
                throw new IllegalArgumentException("Command not supported");
            }
        }
        return this;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        String s = this.zza;
        if(!s.isEmpty()) {
            try {
                return Double.valueOf(s);
            }
            catch(NumberFormatException unused_ex) {
                return NaN;
            }
        }
        return 0.0;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return new zzaq(this);
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        return new zzas(this.zza);
    }
}

