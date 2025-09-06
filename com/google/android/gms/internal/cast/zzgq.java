package com.google.android.gms.internal.cast;

import java.util.logging.Level;
import java.util.logging.Logger;
import k8.Y;
import va.e;

public final class zzgq {
    public static String zza(String s, Object[] arr_object) {
        String s1;
        int v = 0;
        for(int v1 = 0; v1 < arr_object.length; ++v1) {
            Object object0 = arr_object[v1];
            if(object0 == null) {
                s1 = "null";
            }
            else {
                try {
                    s1 = object0.toString();
                }
                catch(Exception exception0) {
                    String s2 = e.c(object0.getClass().getName(), "@", Integer.toHexString(System.identityHashCode(object0)));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for " + s2, exception0);
                    s1 = Y.k("<", s2, " threw ", exception0.getClass().getName(), ">");
                }
            }
            arr_object[v1] = s1;
        }
        StringBuilder stringBuilder0 = new StringBuilder(s.length() + arr_object.length * 16);
        int v2;
        for(v2 = 0; v < arr_object.length; v2 = v3 + 2) {
            int v3 = s.indexOf("%s", v2);
            if(v3 == -1) {
                break;
            }
            stringBuilder0.append(s, v2, v3);
            stringBuilder0.append(arr_object[v]);
            ++v;
        }
        stringBuilder0.append(s, v2, s.length());
        if(v < arr_object.length) {
            stringBuilder0.append(" [");
            int v4 = v + 1;
            stringBuilder0.append(arr_object[v]);
            while(v4 < arr_object.length) {
                stringBuilder0.append(", ");
                stringBuilder0.append(arr_object[v4]);
                ++v4;
            }
            stringBuilder0.append(']');
        }
        return stringBuilder0.toString();
    }
}

