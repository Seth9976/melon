package com.google.android.gms.cast.framework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.widget.Toast;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public class SessionManager {
    private static final Logger zza;
    private final zzay zzb;
    private final Context zzc;

    static {
        SessionManager.zza = new Logger("SessionManager");
    }

    public SessionManager(zzay zzay0, Context context0) {
        this.zzb = zzay0;
        this.zzc = context0;
    }

    public void addSessionManagerListener(SessionManagerListener sessionManagerListener0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.addSessionManagerListener(sessionManagerListener0, Session.class);
    }

    public void addSessionManagerListener(SessionManagerListener sessionManagerListener0, Class class0) {
        if(sessionManagerListener0 == null) {
            throw new NullPointerException("SessionManagerListener can\'t be null");
        }
        Preconditions.checkNotNull(class0);
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            zzbj zzbj0 = new zzbj(sessionManagerListener0, class0);
            this.zzb.zzi(zzbj0);
        }
        catch(RemoteException remoteException0) {
            SessionManager.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"addSessionManagerListener", "zzay"});
        }
    }

    public void endCurrentSession(boolean z) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            SessionManager.zza.i("End session for %s", new Object[]{"com.iloen.melon"});
            this.zzb.zzj(true, z);
        }
        catch(RemoteException remoteException0) {
            SessionManager.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"endCurrentSession", "zzay"});
        }
    }

    public CastSession getCurrentCastSession() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Session session0 = this.getCurrentSession();
        return session0 == null || !(session0 instanceof CastSession) ? null : ((CastSession)session0);
    }

    public Session getCurrentSession() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return (Session)ObjectWrapper.unwrap(this.zzb.zzf());
        }
        catch(RemoteException remoteException0) {
            SessionManager.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"getWrappedCurrentSession", "zzay"});
            return null;
        }
    }

    public void removeSessionManagerListener(SessionManagerListener sessionManagerListener0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.removeSessionManagerListener(sessionManagerListener0, Session.class);
    }

    public void removeSessionManagerListener(SessionManagerListener sessionManagerListener0, Class class0) {
        Preconditions.checkNotNull(class0);
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(sessionManagerListener0 == null) {
            return;
        }
        try {
            zzbj zzbj0 = new zzbj(sessionManagerListener0, class0);
            this.zzb.zzl(zzbj0);
        }
        catch(RemoteException remoteException0) {
            SessionManager.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"removeSessionManagerListener", "zzay"});
        }
    }

    public void startSession(Intent intent0) {
        try {
            Context context0 = this.zzc;
            SessionManager.zza.i("Start session for %s", new Object[]{"com.iloen.melon"});
            Bundle bundle0 = intent0.getExtras();
            if(bundle0 != null && bundle0.getString("CAST_INTENT_TO_CAST_ROUTE_ID_KEY") != null) {
                String s = bundle0.getString("CAST_INTENT_TO_CAST_DEVICE_NAME_KEY");
                if(!bundle0.getBoolean("CAST_INTENT_TO_CAST_NO_TOAST_KEY")) {
                    Toast.makeText(context0, context0.getString(string.cast_connecting_to_device, new Object[]{s}), 0).show();
                }
                Bundle bundle1 = new Bundle(bundle0);
                this.zzb.zzm(bundle1);
                intent0.removeExtra("CAST_INTENT_TO_CAST_ROUTE_ID_KEY");
            }
            return;
        }
        catch(RemoteException remoteException0) {
        }
        SessionManager.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"startSession", "zzay"});
    }

    public final int zza() {
        try {
            return this.zzb.zze();
        }
        catch(RemoteException remoteException0) {
            SessionManager.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"addCastStateListener", "zzay"});
            return 1;
        }
    }

    public final IObjectWrapper zzb() {
        try {
            return this.zzb.zzg();
        }
        catch(RemoteException remoteException0) {
            SessionManager.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"getWrappedThis", "zzay"});
            return null;
        }
    }

    public final void zzc(CastStateListener castStateListener0) {
        Preconditions.checkNotNull(castStateListener0);
        try {
            zzab zzab0 = new zzab(castStateListener0);
            this.zzb.zzh(zzab0);
        }
        catch(RemoteException remoteException0) {
            SessionManager.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"addCastStateListener", "zzay"});
        }
    }

    public final void zzd(CastStateListener castStateListener0) {
        try {
            zzab zzab0 = new zzab(castStateListener0);
            this.zzb.zzk(zzab0);
        }
        catch(RemoteException remoteException0) {
            SessionManager.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"removeCastStateListener", "zzay"});
        }
    }
}

