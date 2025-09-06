package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;
import java.util.Objects;

final class zzkz extends zzla {
    final zzlg zza;
    private int zzb;
    private final int zzc;

    public zzkz(zzlg zzlg0) {
        Objects.requireNonNull(zzlg0);
        this.zza = zzlg0;
        super();
        this.zzb = 0;
        this.zzc = zzlg0.zzc();
    }

    @Override
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override  // com.google.android.gms.internal.measurement.zzlc
    public final byte zza() {
        int v = this.zzb;
        if(v >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = v + 1;
        return this.zza.zzb(v);
    }
}

