package com.google.android.gms.internal.auth;

import android.net.Uri;
import androidx.collection.V;
import javax.annotation.Nullable;

public final class zzci {
    private final V zza;

    public zzci(V v0) {
        this.zza = v0;
    }

    @Nullable
    public final String zza(@Nullable Uri uri0, @Nullable String s, @Nullable String s1, String s2) {
        V v0 = uri0 == null ? null : ((V)this.zza.get(uri0.toString()));
        return v0 == null ? null : ((String)v0.get("" + s2));
    }
}

