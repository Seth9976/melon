package com.google.android.gms.internal.cast;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Objects;

final class zzho extends zzhg {
    final zzhp zza;

    public zzho(zzhp zzhp0) {
        this.zza = zzhp0;
        super();
    }

    @Override
    public final Object get(int v) {
        zzgo.zza(v, zzhp.zzm(this.zza), "index");
        int v1 = v + v;
        Object object0 = zzhp.zzn(this.zza)[v1];
        Objects.requireNonNull(object0);
        Object object1 = zzhp.zzn(this.zza)[v1 + 1];
        Objects.requireNonNull(object1);
        return new AbstractMap.SimpleImmutableEntry(object0, object1);
    }

    @Override
    public final int size() {
        return zzhp.zzm(this.zza);
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final boolean zzf() {
        return true;
    }
}

