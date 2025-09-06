package com.google.android.gms.internal.cast;

import android.os.Bundle;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;

public final class zzah {
    public static Map zza(Bundle bundle0, String s) {
        Map map0 = (Map)bundle0.getSerializable(s);
        if(map0 == null) {
            return zzhj.zzd();
        }
        HashMap hashMap0 = new HashMap();
        for(Object object0: map0.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            if(map$Entry0 != null && map$Entry0.getKey() != null && map$Entry0.getValue() != null) {
                hashMap0.put(((Integer)map$Entry0.getKey()), ((Integer)map$Entry0.getValue()));
            }
        }
        return Collections.unmodifiableMap(hashMap0);
    }
}

