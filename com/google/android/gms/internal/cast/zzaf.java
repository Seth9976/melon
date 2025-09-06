package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.zzad;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class zzaf extends zzad {
    public final Set zza;
    static final int zzb;
    private static final Logger zzc;
    private int zzd;

    static {
        zzaf.zzc = new Logger("AppVisibilityProxy");
        zzaf.zzb = 1;
    }

    public zzaf() {
        this.zza = Collections.synchronizedSet(new HashSet());
        this.zzd = zzaf.zzb;
    }

    @Override  // com.google.android.gms.cast.framework.zzae
    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this);
    }

    @Override  // com.google.android.gms.cast.framework.zzae
    public final void zzc() {
        zzaf.zzc.i("onAppEnteredBackground", new Object[0]);
        this.zzd = 2;
        for(Object object0: this.zza) {
            ((zzae)object0).zza();
        }
    }

    @Override  // com.google.android.gms.cast.framework.zzae
    public final void zzd() {
        zzaf.zzc.i("onAppEnteredForeground", new Object[0]);
        this.zzd = 1;
        for(Object object0: this.zza) {
            ((zzae)object0).zzb();
        }
    }

    public final void zze(zzae zzae0) {
        this.zza.add(zzae0);
    }

    public final boolean zzf() {
        return this.zzd == 2;
    }
}

