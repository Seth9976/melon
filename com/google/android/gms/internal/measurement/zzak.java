package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import va.e;

public interface zzak {
    boolean zzj(String arg1);

    zzao zzk(String arg1);

    void zzm(String arg1, zzao arg2);

    static zzao zzu(zzak zzak0, zzao zzao0, zzg zzg0, List list0) {
        if(zzak0.zzj(zzao0.zzc())) {
            zzao zzao1 = zzak0.zzk(zzao0.zzc());
            if(!(zzao1 instanceof zzai)) {
                throw new IllegalArgumentException(e.h(zzao0.zzc(), " is not a function"));
            }
            return ((zzai)zzao1).zza(zzg0, list0);
        }
        if(!"hasOwnProperty".equals(zzao0.zzc())) {
            throw new IllegalArgumentException(e.b("Object has no function ", zzao0.zzc()));
        }
        zzh.zza("hasOwnProperty", 1, list0);
        return zzak0.zzj(zzg0.zza(((zzao)list0.get(0))).zzc()) ? zzao.zzk : zzao.zzl;
    }

    static Iterator zzv(Map map0) {
        return new zzaj(map0.keySet().iterator());
    }
}

