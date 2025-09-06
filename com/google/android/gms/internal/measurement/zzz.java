package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.TreeMap;

public final class zzz {
    final TreeMap zza;
    final TreeMap zzb;

    public zzz() {
        this.zza = new TreeMap();
        this.zzb = new TreeMap();
    }

    public final void zza(String s, int v, zzan zzan0, String s1) {
        TreeMap treeMap0;
        if("create".equals(s1)) {
            treeMap0 = this.zzb;
        }
        else if("edit".equals(s1)) {
            treeMap0 = this.zza;
        }
        else {
            throw new IllegalStateException("Unknown callback type: " + s1);
        }
        if(treeMap0.containsKey(v)) {
            v = ((int)(((Integer)treeMap0.lastKey()))) + 1;
        }
        treeMap0.put(v, zzan0);
    }

    public final void zzb(zzg zzg0, zzab zzab0) {
        zzl zzl0 = new zzl(zzab0);
        TreeMap treeMap0 = this.zza;
        for(Object object0: treeMap0.keySet()) {
            zzaa zzaa0 = zzab0.zzc().zzg();
            switch(zzz.zzc(zzg0, ((zzan)treeMap0.get(((Integer)object0))), zzl0)) {
                case -1: 
                case 2: {
                    zzab0.zzd(zzaa0);
                }
            }
        }
        TreeMap treeMap1 = this.zzb;
        for(Object object1: treeMap1.keySet()) {
            zzz.zzc(zzg0, ((zzan)treeMap1.get(((Integer)object1))), zzl0);
        }
    }

    private static final int zzc(zzg zzg0, zzan zzan0, zzao zzao0) {
        zzao zzao1 = zzan0.zza(zzg0, Collections.singletonList(zzao0));
        return zzao1 instanceof zzah ? zzh.zzg(((double)zzao1.zzd())) : -1;
    }
}

