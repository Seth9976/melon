package com.google.android.gms.internal.cast;

public class zzxf extends zzvz {
    protected zzxi zza;
    private final zzxi zzb;

    public zzxf(zzxi zzxi0) {
        this.zzb = zzxi0;
        if(zzxi0.zzM()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = zzxi0.zzA();
    }

    @Override  // com.google.android.gms.internal.cast.zzvz
    public final Object clone() {
        return this.zzp();
    }

    private static void zza(Object object0, Object object1) {
        zzys.zza().zzb(object0.getClass()).zze(object0, object1);
    }

    @Override  // com.google.android.gms.internal.cast.zzvz
    public final zzvz zzo() {
        return this.zzp();
    }

    public final zzxf zzp() {
        zzxf zzxf0 = (zzxf)this.zzb.zzb(5, null, null);
        zzxf0.zza = this.zzs();
        return zzxf0;
    }

    public final zzxf zzq(zzxi zzxi0) {
        if(!this.zzb.equals(zzxi0)) {
            if(!this.zza.zzM()) {
                this.zzw();
            }
            zzxf.zza(this.zza, zzxi0);
        }
        return this;
    }

    public final zzxi zzr() {
        zzxi zzxi0 = this.zzs();
        if(!zzxi0.zzx()) {
            throw new zzzg(zzxi0);
        }
        return zzxi0;
    }

    public zzxi zzs() {
        if(!this.zza.zzM()) {
            return this.zza;
        }
        this.zza.zzH();
        return this.zza;
    }

    @Override  // com.google.android.gms.internal.cast.zzyk
    public zzyl zzt() {
        return this.zzs();
    }

    @Override  // com.google.android.gms.internal.cast.zzym
    public final zzyl zzu() {
        throw null;
    }

    public final void zzv() {
        if(!this.zza.zzM()) {
            this.zzw();
        }
    }

    public void zzw() {
        zzxi zzxi0 = this.zzb.zzA();
        zzxf.zza(zzxi0, this.zza);
        this.zza = zzxi0;
    }

    @Override  // com.google.android.gms.internal.cast.zzym
    public final boolean zzx() {
        return zzxi.zzL(this.zza, false);
    }
}

