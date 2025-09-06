package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzag;

public abstract class Session {
    private static final Logger zza;
    private final zzaw zzb;
    private final zzbh zzc;

    static {
        Session.zza = new Logger("Session");
    }

    public Session(Context context0, String s, String s1) {
        zzbh zzbh0 = new zzbh(this, null);
        this.zzc = zzbh0;
        this.zzb = zzag.zzd(context0, s, s1, zzbh0);
    }

    public abstract void end(boolean arg1);

    public final String getCategory() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaw zzaw0 = this.zzb;
        if(zzaw0 != null) {
            try {
                return zzaw0.zzh();
            }
            catch(RemoteException remoteException0) {
                Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"getCategory", "zzaw"});
            }
        }
        return null;
    }

    public final String getSessionId() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaw zzaw0 = this.zzb;
        if(zzaw0 != null) {
            try {
                return zzaw0.zzi();
            }
            catch(RemoteException remoteException0) {
                Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"getSessionId", "zzaw"});
            }
        }
        return null;
    }

    public long getSessionRemainingTimeMs() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return 0L;
    }

    public boolean isConnected() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaw zzaw0 = this.zzb;
        if(zzaw0 != null) {
            try {
                return zzaw0.zzp();
            }
            catch(RemoteException remoteException0) {
                Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"isConnected", "zzaw"});
            }
        }
        return false;
    }

    public boolean isConnecting() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaw zzaw0 = this.zzb;
        if(zzaw0 != null) {
            try {
                return zzaw0.zzq();
            }
            catch(RemoteException remoteException0) {
                Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"isConnecting", "zzaw"});
            }
        }
        return false;
    }

    public boolean isDisconnected() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaw zzaw0 = this.zzb;
        if(zzaw0 != null) {
            try {
                return zzaw0.zzr();
            }
            catch(RemoteException remoteException0) {
                Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"isDisconnected", "zzaw"});
            }
        }
        return true;
    }

    public boolean isDisconnecting() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaw zzaw0 = this.zzb;
        if(zzaw0 != null) {
            try {
                return zzaw0.zzs();
            }
            catch(RemoteException remoteException0) {
                Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"isDisconnecting", "zzaw"});
            }
        }
        return false;
    }

    public boolean isResuming() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaw zzaw0 = this.zzb;
        if(zzaw0 != null) {
            try {
                return zzaw0.zzt();
            }
            catch(RemoteException remoteException0) {
                Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"isResuming", "zzaw"});
            }
        }
        return false;
    }

    public boolean isSuspended() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaw zzaw0 = this.zzb;
        if(zzaw0 != null) {
            try {
                return zzaw0.zzu();
            }
            catch(RemoteException remoteException0) {
                Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"isSuspended", "zzaw"});
            }
        }
        return false;
    }

    public final void notifyFailedToResumeSession(int v) {
        zzaw zzaw0 = this.zzb;
        if(zzaw0 == null) {
            return;
        }
        try {
            zzaw0.zzj(v);
        }
        catch(RemoteException remoteException0) {
            Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"notifyFailedToResumeSession", "zzaw"});
        }
    }

    public final void notifyFailedToStartSession(int v) {
        zzaw zzaw0 = this.zzb;
        if(zzaw0 == null) {
            return;
        }
        try {
            zzaw0.zzk(v);
        }
        catch(RemoteException remoteException0) {
            Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"notifyFailedToStartSession", "zzaw"});
        }
    }

    public final void notifySessionEnded(int v) {
        zzaw zzaw0 = this.zzb;
        if(zzaw0 == null) {
            return;
        }
        try {
            zzaw0.zzl(v);
        }
        catch(RemoteException remoteException0) {
            Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"notifySessionEnded", "zzaw"});
        }
    }

    public final void notifySessionResumed(boolean z) {
        zzaw zzaw0 = this.zzb;
        if(zzaw0 == null) {
            return;
        }
        try {
            zzaw0.zzm(z);
        }
        catch(RemoteException remoteException0) {
            Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"notifySessionResumed", "zzaw"});
        }
    }

    public final void notifySessionStarted(String s) {
        zzaw zzaw0 = this.zzb;
        if(zzaw0 == null) {
            return;
        }
        try {
            zzaw0.zzn(s);
        }
        catch(RemoteException remoteException0) {
            Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"notifySessionStarted", "zzaw"});
        }
    }

    public final void notifySessionSuspended(int v) {
        zzaw zzaw0 = this.zzb;
        if(zzaw0 == null) {
            return;
        }
        try {
            zzaw0.zzo(v);
        }
        catch(RemoteException remoteException0) {
            Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"notifySessionSuspended", "zzaw"});
        }
    }

    public void onResuming(Bundle bundle0) {
    }

    public void onStarting(Bundle bundle0) {
    }

    public abstract void resume(Bundle arg1);

    public abstract void start(Bundle arg1);

    public void zzk(Bundle bundle0) {
    }

    public final int zzm() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaw zzaw0 = this.zzb;
        if(zzaw0 != null) {
            try {
                if(zzaw0.zze() >= 211100000) {
                    return zzaw0.zzf();
                }
            }
            catch(RemoteException remoteException0) {
                Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"getSessionStartType", "zzaw"});
            }
        }
        return 0;
    }

    public final IObjectWrapper zzn() {
        zzaw zzaw0 = this.zzb;
        if(zzaw0 != null) {
            try {
                return zzaw0.zzg();
            }
            catch(RemoteException remoteException0) {
                Session.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"getWrappedObject", "zzaw"});
            }
        }
        return null;
    }
}

