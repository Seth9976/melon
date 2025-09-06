package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.f;

public final class zzka {
    public static final int zza;
    private static final f zzb;

    static {
        zzka.zzb = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
    }

    public static Uri zza(String s) {
        synchronized(zzka.class) {
            f f0 = zzka.zzb;
            Uri uri0 = (Uri)f0.get("com.google.android.gms.measurement");
            if(uri0 == null) {
                Uri uri1 = Uri.parse(("content://com.google.android.gms.phenotype/" + Uri.encode("com.google.android.gms.measurement")));
                f0.put("com.google.android.gms.measurement", uri1);
                return uri1;
            }
            return uri0;
        }
    }
}

