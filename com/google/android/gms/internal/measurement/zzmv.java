package com.google.android.gms.internal.measurement;

public class zzmv {
    protected volatile zznl zza;
    private volatile zzlg zzb;
    private volatile boolean zzc;

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzmv)) {
            return false;
        }
        zznl zznl0 = this.zza;
        zznl zznl1 = ((zzmv)object0).zza;
        if(zznl0 == null && zznl1 == null) {
            return this.zzc().equals(((zzmv)object0).zzc());
        }
        if(zznl0 != null && zznl1 != null) {
            return zznl0.equals(zznl1);
        }
        if(zznl0 != null) {
            ((zzmv)object0).zzd(zznl0.zzcE());
            return zznl0.equals(((zzmv)object0).zza);
        }
        this.zzd(zznl1.zzcE());
        return this.zza.equals(zznl1);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public final zznl zza(zznl zznl0) {
        zznl zznl1 = this.zza;
        this.zzb = null;
        this.zza = zznl0;
        return zznl1;
    }

    public final int zzb() {
        if(this.zzb != null) {
            return ((zzlf)this.zzb).zza.length;
        }
        return this.zza == null ? 0 : this.zza.zzcn();
    }

    public final zzlg zzc() {
        if(this.zzb != null) {
            return this.zzb;
        }
        synchronized(this) {
            if(this.zzb != null) {
                return this.zzb;
            }
            this.zzb = this.zza == null ? zzlg.zzb : this.zza.zzcb();
            return this.zzb;
        }
    }

    public final void zzd(zznl zznl0) {
        if(this.zza == null) {
            synchronized(this) {
                if(this.zza != null) {
                    return;
                }
                this.zza = zznl0;
                this.zzb = zzlg.zzb;
            }
        }
    }
}

