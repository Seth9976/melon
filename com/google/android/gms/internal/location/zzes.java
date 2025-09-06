package com.google.android.gms.internal.location;

import b3.Z;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import k8.Y;

public final class zzes {
    public static String zza(@CheckForNull String s, @CheckForNull Object[] arr_object) {
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
                    String s2 = object0.getClass().getName();
                    String s3 = Integer.toHexString(System.identityHashCode(object0));
                    String s4 = Y.l(new StringBuilder(s2.length() + 1 + String.valueOf(s3).length()), s2, "@", s3);
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for " + s4, exception0);
                    String s5 = exception0.getClass().getName();
                    StringBuilder stringBuilder0 = Z.o(Z.d(s4.length() + 8, 1, s5), "<", s4, " threw ", s5);
                    stringBuilder0.append(">");
                    s1 = stringBuilder0.toString();
                }
            }
            arr_object[v1] = s1;
        }
        StringBuilder stringBuilder1 = new StringBuilder(s.length() + arr_object.length * 16);
        int v2;
        for(v2 = 0; v < arr_object.length; v2 = v3 + 2) {
            int v3 = s.indexOf("%s", v2);
            if(v3 == -1) {
                break;
            }
            stringBuilder1.append(s, v2, v3);
            stringBuilder1.append(arr_object[v]);
            ++v;
        }
        stringBuilder1.append(s, v2, s.length());
        if(v < arr_object.length) {
            stringBuilder1.append(" [");
            int v4 = v + 1;
            stringBuilder1.append(arr_object[v]);
            while(v4 < arr_object.length) {
                stringBuilder1.append(", ");
                stringBuilder1.append(arr_object[v4]);
                ++v4;
            }
            stringBuilder1.append(']');
        }
        return stringBuilder1.toString();
    }
}

