package com.google.android.gms.cast.internal;

public class zzq {
    protected final Logger zza;
    private final String zzb;
    private zzas zzc;

    public zzq(String s, String s1, String s2) {
        CastUtils.throwIfInvalidNamespace(s);
        this.zzb = s;
        this.zza = new Logger("MediaControlChannel", null);
    }

    public final long zzd() {
        zzas zzas0 = this.zzc;
        if(zzas0 == null) {
            this.zza.e("Attempt to generate requestId without a sink", new Object[0]);
            return 0L;
        }
        return zzas0.zza();
    }

    public final String zze() {
        return this.zzb;
    }

    public void zzf() {
        throw null;
    }

    public final void zzg(String s, long v, String s1) {
        Logger logger0 = this.zza;
        logger0.v("Sending text message: %s to: %s", new Object[]{s, 0});
        zzas zzas0 = this.zzc;
        if(zzas0 == null) {
            logger0.e("Attempt to send text message without a sink", new Object[0]);
            return;
        }
        zzas0.zzb(this.zzb, s, v, null);
    }

    public final void zzh(zzas zzas0) {
        this.zzc = zzas0;
        if(zzas0 == null) {
            this.zzf();
        }
    }
}

