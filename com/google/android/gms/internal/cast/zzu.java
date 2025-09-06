package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.common.internal.Preconditions;

public final class zzu implements SessionManagerListener {
    final zzx zza;

    public zzu(zzx zzx0) {
        this.zza = zzx0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionEnded(Session session0, int v) {
        CastSession castSession0 = (CastSession)session0;
        zzca zzca0 = new zzca(9);
        zzca0.zzb(v);
        zzca0.zza(Boolean.valueOf(zzx.zzd(this.zza).zzf()));
        zzcb zzcb0 = new zzcb(zzca0);
        zzx.zzf(this.zza, zzcb0);
        zzx.zze(this.zza);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionEnding(Session session0) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResumeFailed(Session session0, int v) {
        CastSession castSession0 = (CastSession)session0;
        zzca zzca0 = new zzca(8);
        zzca0.zzb(v);
        zzcb zzcb0 = new zzcb(zzca0);
        zzx.zzf(this.zza, zzcb0);
        zzx.zze(this.zza);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResumed(Session session0, boolean z) {
        zzcb zzcb0 = new zzcb(new zzca(4));
        zzx.zzf(this.zza, zzcb0);
        ((zzz)Preconditions.checkNotNull(zzx.zzb(this.zza))).zzg(((CastSession)session0));
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResuming(Session session0, String s) {
        zzcb zzcb0 = new zzcb(new zzca(7));
        zzx.zzf(this.zza, zzcb0);
        ((zzz)Preconditions.checkNotNull(zzx.zzb(this.zza))).zzg(((CastSession)session0));
        ((zzz)Preconditions.checkNotNull(zzx.zzb(this.zza))).zzh(s);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStartFailed(Session session0, int v) {
        CastSession castSession0 = (CastSession)session0;
        zzca zzca0 = new zzca(5);
        zzca0.zzb(v);
        zzcb zzcb0 = new zzcb(zzca0);
        zzx.zzf(this.zza, zzcb0);
        zzx.zze(this.zza);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStarted(Session session0, String s) {
        zzcb zzcb0 = new zzcb(new zzca(4));
        zzx.zzf(this.zza, zzcb0);
        ((zzz)Preconditions.checkNotNull(zzx.zzb(this.zza))).zzg(((CastSession)session0));
        ((zzz)Preconditions.checkNotNull(zzx.zzb(this.zza))).zzh(s);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStarting(Session session0) {
        zzca zzca0 = new zzca(2);
        zzca0.zza(Boolean.valueOf(zzx.zzd(this.zza).zzf()));
        zzcb zzcb0 = new zzcb(zzca0);
        zzx.zzf(this.zza, zzcb0);
        ((zzz)Preconditions.checkNotNull(zzx.zzb(this.zza))).zzg(((CastSession)session0));
        ((CastSession)session0).zzj(zzx.zza(this.zza));
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionSuspended(Session session0, int v) {
        zzca zzca0 = new zzca(6);
        zzca0.zzb(v);
        zzcb zzcb0 = new zzcb(zzca0);
        zzx.zzf(this.zza, zzcb0);
        ((zzz)Preconditions.checkNotNull(zzx.zzb(this.zza))).zzg(((CastSession)session0));
    }
}

