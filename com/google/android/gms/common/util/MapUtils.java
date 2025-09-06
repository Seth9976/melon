package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;
import va.e;

@KeepForSdk
public class MapUtils {
    @KeepForSdk
    public static void writeStringMapToJson(StringBuilder stringBuilder0, HashMap hashMap0) {
        stringBuilder0.append("{");
        boolean z = true;
        for(Object object0: hashMap0.keySet()) {
            if(!z) {
                stringBuilder0.append(",");
            }
            String s = (String)hashMap0.get(((String)object0));
            e.g(stringBuilder0, "\"", ((String)object0), "\":");
            if(s == null) {
                stringBuilder0.append("null");
            }
            else {
                e.g(stringBuilder0, "\"", s, "\"");
            }
            z = false;
        }
        stringBuilder0.append("}");
    }
}

