package com.google.android.gms.internal.play_billing;

public class zzdi {
    protected volatile zzec zza;
    private static final zzcd zzb;
    private volatile zzbq zzc;

    static {
        zzdi.zzb = zzcd.zza;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzdi)) {
            return false;
        }
        zzec zzec0 = this.zza;
        zzec zzec1 = ((zzdi)object0).zza;
        if(zzec0 == null && zzec1 == null) {
            return this.zzb().equals(((zzdi)object0).zzb());
        }
        if(zzec0 != null && zzec1 != null) {
            return zzec0.equals(zzec1);
        }
        if(zzec0 != null) {
            ((zzdi)object0).zzd(zzec0.zzh());
            return zzec0.equals(((zzdi)object0).zza);
        }
        this.zzd(zzec1.zzh());
        return this.zza.equals(zzec1);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if(this.zzc != null) {
            return ((zzbn)this.zzc).zza.length;
        }
        return this.zza == null ? 0 : this.zza.zzf();
    }

    public final zzbq zzb() {
        if(this.zzc != null) {
            return this.zzc;
        }
        synchronized(this) {
            if(this.zzc != null) {
                return this.zzc;
            }
            this.zzc = this.zza == null ? zzbq.zzb : this.zza.zzb();
            return this.zzc;
        }
    }

    public final zzec zzc(zzec zzec0) {
        zzec zzec1 = this.zza;
        this.zzc = null;
        this.zza = zzec0;
        return zzec1;
    }

    public final void zzd(zzec zzec0) {
        if(this.zza == null) {
            synchronized(this) {
                if(this.zza != null) {
                    return;
                }
                this.zza = zzec0;
                this.zzc = zzbq.zzb;
            }
        }
    }
}

