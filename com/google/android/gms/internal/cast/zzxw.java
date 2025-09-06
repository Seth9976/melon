package com.google.android.gms.internal.cast;

public class zzxw {
    protected volatile zzyl zza;
    private volatile zzwn zzb;
    private volatile boolean zzc;

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzxw)) {
            return false;
        }
        zzyl zzyl0 = this.zza;
        zzyl zzyl1 = ((zzxw)object0).zza;
        if(zzyl0 == null && zzyl1 == null) {
            return this.zzb().equals(((zzxw)object0).zzb());
        }
        if(zzyl0 != null && zzyl1 != null) {
            return zzyl0.equals(zzyl1);
        }
        if(zzyl0 != null) {
            ((zzxw)object0).zzd(zzyl0.zzu());
            return zzyl0.equals(((zzxw)object0).zza);
        }
        this.zzd(zzyl1.zzu());
        return this.zza.equals(zzyl1);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if(this.zzb != null) {
            return ((zzwl)this.zzb).zza.length;
        }
        return this.zza == null ? 0 : this.zza.zzw();
    }

    public final zzwn zzb() {
        if(this.zzb != null) {
            return this.zzb;
        }
        synchronized(this) {
            if(this.zzb != null) {
                return this.zzb;
            }
            this.zzb = this.zza == null ? zzwn.zzb : this.zza.zzs();
            return this.zzb;
        }
    }

    public final zzyl zzc(zzyl zzyl0) {
        zzyl zzyl1 = this.zza;
        this.zzb = null;
        this.zza = zzyl0;
        return zzyl1;
    }

    public final void zzd(zzyl zzyl0) {
        if(this.zza == null) {
            synchronized(this) {
                if(this.zza != null) {
                    return;
                }
                this.zza = zzyl0;
                this.zzb = zzwn.zzb;
            }
        }
    }
}

