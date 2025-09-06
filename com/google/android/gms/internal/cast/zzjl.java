package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

public final class zzjl extends zziz {
    public static final int zza;
    private static final Set zzb;
    private static final zzis zzc;
    private static final zzji zzd;

    static {
        Set set0 = Collections.unmodifiableSet(new HashSet(Arrays.asList(new zzie[]{zzib.zza, zzig.zza, zzih.zza})));
        zzjl.zzb = set0;
        zzjl.zzc = zziv.zza(set0).zza();
        zzjl.zzd = new zzji(null);
    }

    public zzjl(String s, String s1, boolean z, int v, Level level0, Set set0, zzis zzis0, zzjk zzjk0) {
        super(s1);
        if(s1.length() > 23) {
            int v1 = -1;
            int v2 = s1.length() - 1;
            while(v2 >= 0) {
                if(s1.charAt(v2) != 36 && s1.charAt(v2) != 46) {
                    --v2;
                }
                else {
                    v1 = v2;
                    if(true) {
                        break;
                    }
                }
            }
            s1 = s1.substring(v1 + 1);
        }
        ("" + s1).substring(0, Math.min(("" + s1).length(), 23));
    }

    public static zzis zzb() {
        return zzjl.zzc;
    }

    public static zzji zzc() {
        return zzjl.zzd;
    }

    public static Set zzd() {
        return zzjl.zzb;
    }
}

