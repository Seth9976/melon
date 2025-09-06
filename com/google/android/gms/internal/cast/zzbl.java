package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManagerListener;

final class zzbl implements SessionManagerListener {
    final zzbn zza;

    public zzbl(zzbn zzbn0, zzbm zzbm0) {
        this.zza = zzbn0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionEnded(Session session0, int v) {
        CastSession castSession0 = (CastSession)session0;
        zzbn.zzb().d("onSessionEnded with error = %d", new Object[]{v});
        zzbn zzbn0 = this.zza;
        zzbn.zzg(zzbn0);
        if(zzbn.zza(zzbn0) == 2) {
            return;
        }
        zzbn.zzh(zzbn0);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionEnding(Session session0) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResumeFailed(Session session0, int v) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResumed(Session session0, boolean z) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResuming(Session session0, String s) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStartFailed(Session session0, int v) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStarted(Session session0, String s) {
        CastSession castSession0 = (CastSession)session0;
        zzbn zzbn0 = this.zza;
        zzbn.zza.d("onSessionStarted with transferType = %d", new Object[]{zzbn0.zzf});
        if(zzbn0.zzp() && zzbn0.zzf == 2) {
            zzbn.zzi(zzbn0);
        }
        zzbn0.zzs();
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStarting(Session session0) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionSuspended(Session session0, int v) {
        CastSession castSession0 = (CastSession)session0;
    }
}

