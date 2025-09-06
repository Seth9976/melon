package com.google.android.gms.internal.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class zzy {
    private final zzp zza;
    private final boolean zzb;
    private final zzw zzc;

    private zzy(zzw zzw0, boolean z, zzp zzp0, int v) {
        this.zzc = zzw0;
        this.zzb = z;
        this.zza = zzp0;
    }

    public static zzy zza(zzp zzp0) {
        return new zzy(new zzw(zzp0), false, zzo.zza, 0x7FFFFFFF);
    }

    public final zzy zzb() {
        return new zzy(this.zzc, true, this.zza, 0x7FFFFFFF);
    }

    public final Iterable zzc(CharSequence charSequence0) {
        return new zzv(this, charSequence0);
    }

    public final List zzd(CharSequence charSequence0) {
        charSequence0.getClass();
        Iterator iterator0 = this.zzc.zza(this, charSequence0);
        ArrayList arrayList0 = new ArrayList();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            arrayList0.add(((String)object0));
        }
        return Collections.unmodifiableList(arrayList0);
    }

    public final Iterator zze(CharSequence charSequence0) {
        return this.zzc.zza(this, charSequence0);
    }

    public final zzp zzf() {
        return this.zza;
    }

    public final boolean zzg() {
        return this.zzb;
    }
}

