package com.google.android.gms.internal.auth;

import android.net.Uri;
import androidx.collection.f;

public final class zzcr {
    private static final f zza;

    static {
        zzcr.zza = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
    }

    public static Uri zza(String s) {
        synchronized(zzcr.class) {
            f f0 = zzcr.zza;
            Uri uri0 = (Uri)f0.get("com.google.android.gms.auth_account");
            if(uri0 == null) {
                Uri uri1 = Uri.parse(("content://com.google.android.gms.phenotype/" + Uri.encode("com.google.android.gms.auth_account")));
                f0.put("com.google.android.gms.auth_account", uri1);
                return uri1;
            }
            return uri0;
        }
    }
}

