package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzg {
    public final zzg zza;
    final zzaw zzb;
    final Map zzc;
    final Map zzd;

    public zzg(zzg zzg0, zzaw zzaw0) {
        this.zzc = new HashMap();
        this.zzd = new HashMap();
        this.zza = zzg0;
        this.zzb = zzaw0;
    }

    public final zzao zza(zzao zzao0) {
        return this.zzb.zzb(this, zzao0);
    }

    public final zzao zzb(zzae zzae0) {
        zzao zzao0 = zzao.zzf;
        Iterator iterator0 = zzae0.zzg();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            zzao zzao1 = zzae0.zzl(((int)(((Integer)object0))));
            zzao0 = this.zzb.zzb(this, zzao1);
            if(zzao0 instanceof zzag) {
                break;
            }
        }
        return zzao0;
    }

    public final zzg zzc() {
        return new zzg(this, this.zzb);
    }

    public final boolean zzd(String s) {
        if(this.zzc.containsKey(s)) {
            return true;
        }
        return this.zza == null ? false : this.zza.zzd(s);
    }

    public final void zze(String s, zzao zzao0) {
        Map map0 = this.zzc;
        if(!map0.containsKey(s)) {
            zzg zzg0 = this.zza;
            if(zzg0 != null && zzg0.zzd(s)) {
                zzg0.zze(s, zzao0);
                return;
            }
        }
        if(this.zzd.containsKey(s)) {
            return;
        }
        if(zzao0 == null) {
            map0.remove(s);
            return;
        }
        map0.put(s, zzao0);
    }

    public final void zzf(String s, zzao zzao0) {
        if(this.zzd.containsKey(s)) {
            return;
        }
        if(zzao0 == null) {
            this.zzc.remove(s);
            return;
        }
        this.zzc.put(s, zzao0);
    }

    public final void zzg(String s, zzao zzao0) {
        this.zzf(s, zzao0);
        this.zzd.put(s, Boolean.TRUE);
    }

    public final zzao zzh(String s) {
        Map map0 = this.zzc;
        if(map0.containsKey(s)) {
            return (zzao)map0.get(s);
        }
        zzg zzg0 = this.zza;
        if(zzg0 == null) {
            throw new IllegalArgumentException(s + " is not defined");
        }
        return zzg0.zzh(s);
    }
}

