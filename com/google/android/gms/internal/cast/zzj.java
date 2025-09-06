package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.common.internal.Preconditions;

public final class zzj implements SessionManagerListener {
    final zzl zza;

    public zzj(zzl zzl0) {
        this.zza = zzl0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionEnded(Session session0, int v) {
        zzl.zzh(this.zza, ((CastSession)session0));
        zzl.zzm(this.zza, v);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionEnding(Session session0) {
        zzl.zzh(this.zza, ((CastSession)session0));
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResumeFailed(Session session0, int v) {
        zzl.zzh(this.zza, ((CastSession)session0));
        zzl.zzm(this.zza, v);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResumed(Session session0, boolean z) {
        zzl.zze().d("onSessionResumed with wasSuspended = %b", new Object[]{Boolean.valueOf(z)});
        zzl.zzh(this.zza, ((CastSession)session0));
        zzl.zzk(this.zza);
        Preconditions.checkNotNull(zzl.zzc(this.zza));
        zzqe zzqe0 = zzl.zzd(this.zza).zzb(zzl.zzc(this.zza), z);
        zzl.zzb(this.zza).zzf(zzqe0, 0xE3);
        zzl.zzo(this.zza);
        zzl.zzp(this.zza);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResuming(Session session0, String s) {
        zzl.zze().d("onSessionResuming with sessionId = %s", new Object[]{s});
        zzl.zzh(this.zza, ((CastSession)session0));
        zzl.zzn(this.zza, zzl.zza(this.zza), s);
        Preconditions.checkNotNull(zzl.zzc(this.zza));
        zzqe zzqe0 = zzl.zzd(this.zza).zzc(zzl.zzc(this.zza));
        zzl.zzb(this.zza).zzf(zzqe0, 0xE2);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStartFailed(Session session0, int v) {
        zzl.zzh(this.zza, ((CastSession)session0));
        zzl.zzm(this.zza, v);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStarted(Session session0, String s) {
        zzl.zze().d("onSessionStarted with sessionId = %s", new Object[]{s});
        zzl.zzh(this.zza, ((CastSession)session0));
        zzl.zzk(this.zza);
        zzl.zzc(this.zza).zzf = s;
        zzqe zzqe0 = zzl.zzd(this.zza).zza(zzl.zzc(this.zza));
        zzl.zzb(this.zza).zzf(zzqe0, 0xDE);
        zzl.zzo(this.zza);
        zzl.zzp(this.zza);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStarting(Session session0) {
        zzl.zze().d("onSessionStarting", new Object[0]);
        zzl zzl0 = this.zza;
        zzl.zzh(zzl0, ((CastSession)session0));
        if(zzl.zzc(zzl0) != null) {
            zzl.zze().w("Start a session while there\'s already an active session. Create a new one.", new Object[0]);
        }
        zzl.zzl(zzl0);
        zzl.zzb(zzl0).zzf(zzl.zzd(zzl0).zzd(zzl.zzc(zzl0)), 0xDD);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionSuspended(Session session0, int v) {
        zzl.zze().d("onSessionSuspended with reason = %d", new Object[]{v});
        zzl.zzh(this.zza, ((CastSession)session0));
        zzl.zzk(this.zza);
        Preconditions.checkNotNull(zzl.zzc(this.zza));
        zzqe zzqe0 = zzl.zzd(this.zza).zze(zzl.zzc(this.zza), v);
        zzl.zzb(this.zza).zzf(zzqe0, 0xE1);
        zzl.zzo(this.zza);
        zzl.zzj(this.zza);
    }
}

