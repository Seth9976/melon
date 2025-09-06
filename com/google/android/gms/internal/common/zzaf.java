package com.google.android.gms.internal.common;

import java.util.Iterator;

public final class zzaf extends zzac {
    public zzaf() {
        super(4);
    }

    public zzaf(int v) {
        super(4);
    }

    public final zzaf zzb(Object object0) {
        this.zza(object0);
        return this;
    }

    public final zzaf zzc(Iterator iterator0) {
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            this.zza(object0);
        }
        return this;
    }

    public final zzaj zzd() {
        this.zzc = true;
        return zzaj.zzq(this.zza, this.zzb);
    }
}

