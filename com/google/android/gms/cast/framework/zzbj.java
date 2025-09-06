package com.google.android.gms.cast.framework;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zzbj extends zzaz {
    @NotOnlyInitialized
    private final SessionManagerListener zza;
    private final Class zzb;

    public zzbj(SessionManagerListener sessionManagerListener0, Class class0) {
        this.zza = sessionManagerListener0;
        this.zzb = class0;
    }

    @Override  // com.google.android.gms.cast.framework.zzba
    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override  // com.google.android.gms.cast.framework.zzba
    public final void zzc(IObjectWrapper iObjectWrapper0, int v) {
        Session session0 = (Session)ObjectWrapper.unwrap(iObjectWrapper0);
        Class class0 = this.zzb;
        if(class0.isInstance(session0)) {
            SessionManagerListener sessionManagerListener0 = this.zza;
            if(sessionManagerListener0 != null) {
                sessionManagerListener0.onSessionEnded(((Session)class0.cast(session0)), v);
            }
        }
    }

    @Override  // com.google.android.gms.cast.framework.zzba
    public final void zzd(IObjectWrapper iObjectWrapper0) {
        Session session0 = (Session)ObjectWrapper.unwrap(iObjectWrapper0);
        Class class0 = this.zzb;
        if(class0.isInstance(session0)) {
            SessionManagerListener sessionManagerListener0 = this.zza;
            if(sessionManagerListener0 != null) {
                sessionManagerListener0.onSessionEnding(((Session)class0.cast(session0)));
            }
        }
    }

    @Override  // com.google.android.gms.cast.framework.zzba
    public final void zze(IObjectWrapper iObjectWrapper0, int v) {
        Session session0 = (Session)ObjectWrapper.unwrap(iObjectWrapper0);
        Class class0 = this.zzb;
        if(class0.isInstance(session0)) {
            SessionManagerListener sessionManagerListener0 = this.zza;
            if(sessionManagerListener0 != null) {
                sessionManagerListener0.onSessionResumeFailed(((Session)class0.cast(session0)), v);
            }
        }
    }

    @Override  // com.google.android.gms.cast.framework.zzba
    public final void zzf(IObjectWrapper iObjectWrapper0, boolean z) {
        Session session0 = (Session)ObjectWrapper.unwrap(iObjectWrapper0);
        Class class0 = this.zzb;
        if(class0.isInstance(session0)) {
            SessionManagerListener sessionManagerListener0 = this.zza;
            if(sessionManagerListener0 != null) {
                sessionManagerListener0.onSessionResumed(((Session)class0.cast(session0)), z);
            }
        }
    }

    @Override  // com.google.android.gms.cast.framework.zzba
    public final void zzg(IObjectWrapper iObjectWrapper0, String s) {
        Session session0 = (Session)ObjectWrapper.unwrap(iObjectWrapper0);
        Class class0 = this.zzb;
        if(class0.isInstance(session0)) {
            SessionManagerListener sessionManagerListener0 = this.zza;
            if(sessionManagerListener0 != null) {
                sessionManagerListener0.onSessionResuming(((Session)class0.cast(session0)), s);
            }
        }
    }

    @Override  // com.google.android.gms.cast.framework.zzba
    public final void zzh(IObjectWrapper iObjectWrapper0, int v) {
        Session session0 = (Session)ObjectWrapper.unwrap(iObjectWrapper0);
        Class class0 = this.zzb;
        if(class0.isInstance(session0)) {
            SessionManagerListener sessionManagerListener0 = this.zza;
            if(sessionManagerListener0 != null) {
                sessionManagerListener0.onSessionStartFailed(((Session)class0.cast(session0)), v);
            }
        }
    }

    @Override  // com.google.android.gms.cast.framework.zzba
    public final void zzi(IObjectWrapper iObjectWrapper0, String s) {
        Session session0 = (Session)ObjectWrapper.unwrap(iObjectWrapper0);
        Class class0 = this.zzb;
        if(class0.isInstance(session0)) {
            SessionManagerListener sessionManagerListener0 = this.zza;
            if(sessionManagerListener0 != null) {
                sessionManagerListener0.onSessionStarted(((Session)class0.cast(session0)), s);
            }
        }
    }

    @Override  // com.google.android.gms.cast.framework.zzba
    public final void zzj(IObjectWrapper iObjectWrapper0) {
        Session session0 = (Session)ObjectWrapper.unwrap(iObjectWrapper0);
        Class class0 = this.zzb;
        if(class0.isInstance(session0)) {
            SessionManagerListener sessionManagerListener0 = this.zza;
            if(sessionManagerListener0 != null) {
                sessionManagerListener0.onSessionStarting(((Session)class0.cast(session0)));
            }
        }
    }

    @Override  // com.google.android.gms.cast.framework.zzba
    public final void zzk(IObjectWrapper iObjectWrapper0, int v) {
        Session session0 = (Session)ObjectWrapper.unwrap(iObjectWrapper0);
        Class class0 = this.zzb;
        if(class0.isInstance(session0)) {
            SessionManagerListener sessionManagerListener0 = this.zza;
            if(sessionManagerListener0 != null) {
                sessionManagerListener0.onSessionSuspended(((Session)class0.cast(session0)), v);
            }
        }
    }
}

