package com.google.android.gms.dynamite;

import android.content.Context;

final class zzn implements IVersions {
    private final int zza;

    public zzn(int v, int v1) {
        this.zza = v;
    }

    @Override  // com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions
    public final int zza(Context context0, String s, boolean z) {
        return 0;
    }

    @Override  // com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions
    public final int zzb(Context context0, String s) {
        return this.zza;
    }
}

