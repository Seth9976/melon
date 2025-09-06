package com.google.android.gms.internal.common;

final class zzag extends zzab {
    private final zzaj zza;

    public zzag(zzaj zzaj0, int v) {
        super(zzaj0.size(), v);
        this.zza = zzaj0;
    }

    @Override  // com.google.android.gms.internal.common.zzab
    public final Object zza(int v) {
        return this.zza.get(v);
    }
}

