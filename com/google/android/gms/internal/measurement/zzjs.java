package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.V;

public final class zzjs {
    private final V zza;

    public zzjs(V v0) {
        this.zza = v0;
    }

    public final String zza(Uri uri0, String s, String s1, String s2) {
        V v0 = uri0 == null ? null : ((V)this.zza.get(uri0.toString()));
        return v0 == null ? null : ((String)v0.get("" + s2));
    }
}

