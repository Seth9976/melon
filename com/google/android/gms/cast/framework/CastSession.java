package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.CastOptions.Builder;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.internal.zzu;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzar;
import com.google.android.gms.cast.zzax;
import com.google.android.gms.cast.zzba;
import com.google.android.gms.cast.zzbg;
import com.google.android.gms.cast.zzbr;
import com.google.android.gms.cast.zzr;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzag;
import com.google.android.gms.internal.cast.zzbf;
import com.google.android.gms.internal.cast.zzbs;
import com.google.android.gms.tasks.Task;
import java.util.HashSet;
import java.util.Set;
import org.checkerframework.dataflow.qual.Pure;

public class CastSession extends Session {
    public static final int zza;
    private static final Logger zzb;
    private final Context zzc;
    private final Set zzd;
    private final zzam zze;
    private final CastOptions zzf;
    private final zzbf zzg;
    private final zzu zzh;
    private zzr zzi;
    private RemoteMediaClient zzj;
    private CastDevice zzk;
    private ApplicationConnectionResult zzl;
    private com.google.android.gms.cast.framework.zzu zzm;

    static {
        CastSession.zzb = new Logger("CastSession");
    }

    public CastSession(Context context0, String s, String s1, CastOptions castOptions0, zzbf zzbf0, zzu zzu0) {
        super(context0, s, s1);
        this.zzd = new HashSet();
        this.zzc = context0.getApplicationContext();
        this.zzf = castOptions0;
        this.zzg = zzbf0;
        this.zzh = zzu0;
        this.zze = zzag.zzb(context0, castOptions0, this.zzn(), new zzx(this, null));
    }

    public void addCastListener(Listener cast$Listener0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(cast$Listener0 != null) {
            this.zzd.add(cast$Listener0);
        }
    }

    @Override  // com.google.android.gms.cast.framework.Session
    public void end(boolean z) {
        zzam zzam0 = this.zze;
        if(zzam0 != null) {
            try {
                zzam0.zze(z, 0);
            }
            catch(RemoteException remoteException0) {
                CastSession.zzb.d(remoteException0, "Unable to call %s on %s.", new Object[]{"disconnectFromDevice", "zzam"});
            }
            this.notifySessionEnded(0);
        }
    }

    public int getActiveInputState() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr0 = this.zzi;
        return zzr0 == null || !zzr0.zzl() ? -1 : zzr0.zzb();
    }

    public ApplicationConnectionResult getApplicationConnectionResult() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzl;
    }

    public ApplicationMetadata getApplicationMetadata() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr0 = this.zzi;
        return zzr0 == null || !zzr0.zzl() ? null : zzr0.zzd();
    }

    public String getApplicationStatus() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr0 = this.zzi;
        return zzr0 == null || !zzr0.zzl() ? null : zzr0.zzj();
    }

    @Pure
    public CastDevice getCastDevice() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzk;
    }

    public RemoteMediaClient getRemoteMediaClient() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzj;
    }

    @Override  // com.google.android.gms.cast.framework.Session
    public long getSessionRemainingTimeMs() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzj == null ? 0L : this.zzj.getStreamDuration() - this.zzj.getApproximateStreamPosition();
    }

    public int getStandbyState() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr0 = this.zzi;
        return zzr0 == null || !zzr0.zzl() ? -1 : zzr0.zzc();
    }

    public double getVolume() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr0 = this.zzi;
        return zzr0 == null || !zzr0.zzl() ? 0.0 : zzr0.zza();
    }

    public boolean isMute() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr0 = this.zzi;
        return zzr0 != null && zzr0.zzl() && zzr0.zzm();
    }

    @Override  // com.google.android.gms.cast.framework.Session
    public void onResuming(Bundle bundle0) {
        this.zzk = CastDevice.getFromBundle(bundle0);
    }

    @Override  // com.google.android.gms.cast.framework.Session
    public void onStarting(Bundle bundle0) {
        this.zzk = CastDevice.getFromBundle(bundle0);
    }

    public void removeCastListener(Listener cast$Listener0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(cast$Listener0 != null) {
            this.zzd.remove(cast$Listener0);
        }
    }

    public void removeMessageReceivedCallbacks(String s) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr0 = this.zzi;
        if(zzr0 != null) {
            zzr0.zzg(s);
        }
    }

    public void requestStatus() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr0 = this.zzi;
        if(zzr0 != null) {
            ((zzbr)zzr0).doWrite(TaskApiCall.builder().run(new zzbg()).setMethodKey(8404).build());
        }
    }

    @Override  // com.google.android.gms.cast.framework.Session
    public void resume(Bundle bundle0) {
        this.zzo(bundle0);
    }

    public PendingResult sendMessage(String s, String s1) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzi == null ? PendingResults.immediatePendingResult(new Status(17)) : zzbs.zza(this.zzi.zzh(s, s1), new com.google.android.gms.cast.framework.zzr(), new zzs());
    }

    public void setMessageReceivedCallbacks(String s, MessageReceivedCallback cast$MessageReceivedCallback0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr0 = this.zzi;
        if(zzr0 != null && zzr0.zzl()) {
            zzr0.zzi(s, cast$MessageReceivedCallback0);
        }
    }

    public void setMute(boolean z) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr0 = this.zzi;
        if(zzr0 != null && zzr0.zzl()) {
            ((zzbr)zzr0).doWrite(TaskApiCall.builder().run(new zzba(((zzbr)zzr0), z)).setMethodKey(0x20DC).build());
        }
    }

    public void setVolume(double f) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr0 = this.zzi;
        if(zzr0 != null && zzr0.zzl()) {
            if(Double.isInfinite(f) || Double.isNaN(f)) {
                throw new IllegalArgumentException("Volume cannot be " + f);
            }
            ((zzbr)zzr0).doWrite(TaskApiCall.builder().run(new zzax(((zzbr)zzr0), f)).setMethodKey(0x20DB).build());
        }
    }

    @Override  // com.google.android.gms.cast.framework.Session
    public void start(Bundle bundle0) {
        this.zzo(bundle0);
    }

    public final zzu zze() {
        return this.zzh;
    }

    public static void zzh(CastSession castSession0, int v) {
        castSession0.zzh.zzi(v);
        zzr zzr0 = castSession0.zzi;
        if(zzr0 != null) {
            zzr0.zzf();
            castSession0.zzi = null;
        }
        castSession0.zzk = null;
        RemoteMediaClient remoteMediaClient0 = castSession0.zzj;
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.zzs(null);
            castSession0.zzj = null;
        }
        castSession0.zzl = null;
    }

    public static void zzi(CastSession castSession0, String s, Task task0) {
        zzam zzam0 = castSession0.zze;
        if(zzam0 == null) {
            return;
        }
        try {
            if(task0.isSuccessful()) {
                ApplicationConnectionResult cast$ApplicationConnectionResult0 = (ApplicationConnectionResult)task0.getResult();
                castSession0.zzl = cast$ApplicationConnectionResult0;
                if(cast$ApplicationConnectionResult0.getStatus() != null && cast$ApplicationConnectionResult0.getStatus().isSuccess()) {
                    CastSession.zzb.d("%s() -> success result", new Object[]{s});
                    RemoteMediaClient remoteMediaClient0 = new RemoteMediaClient(new zzar(null));
                    castSession0.zzj = remoteMediaClient0;
                    remoteMediaClient0.zzs(castSession0.zzi);
                    castSession0.zzj.registerCallback(new zzt(castSession0));
                    castSession0.zzj.zzq();
                    RemoteMediaClient remoteMediaClient1 = castSession0.zzj;
                    CastDevice castDevice0 = castSession0.getCastDevice();
                    castSession0.zzh.zzh(remoteMediaClient1, castDevice0);
                    zzam0.zzf(((ApplicationMetadata)Preconditions.checkNotNull(cast$ApplicationConnectionResult0.getApplicationMetadata())), cast$ApplicationConnectionResult0.getApplicationStatus(), ((String)Preconditions.checkNotNull(cast$ApplicationConnectionResult0.getSessionId())), cast$ApplicationConnectionResult0.getWasLaunched());
                    return;
                }
                if(cast$ApplicationConnectionResult0.getStatus() != null) {
                    CastSession.zzb.d("%s() -> failure result", new Object[]{s});
                    zzam0.zzg(cast$ApplicationConnectionResult0.getStatus().getStatusCode());
                    return;
                }
            }
            else {
                Exception exception0 = task0.getException();
                if(exception0 instanceof ApiException) {
                    zzam0.zzg(((ApiException)exception0).getStatusCode());
                    return;
                }
            }
            zzam0.zzg(0x9AC);
        }
        catch(RemoteException remoteException0) {
            CastSession.zzb.d(remoteException0, "Unable to call %s on %s.", new Object[]{"methods", "zzam"});
        }
    }

    public final void zzj(com.google.android.gms.cast.framework.zzu zzu0) {
        this.zzm = zzu0;
    }

    @Override  // com.google.android.gms.cast.framework.Session
    public final void zzk(Bundle bundle0) {
        int v = 0;
        CastDevice castDevice0 = CastDevice.getFromBundle(bundle0);
        if(castDevice0 != null && !castDevice0.equals(this.zzk)) {
            if(!TextUtils.isEmpty(castDevice0.getFriendlyName()) && (this.zzk == null || !TextUtils.equals(this.zzk.getFriendlyName(), castDevice0.getFriendlyName()))) {
                v = 1;
            }
            this.zzk = castDevice0;
            CastSession.zzb.d("update to device (%s) with name %s", new Object[]{castDevice0, (1 == v ? "changed" : "unchanged")});
            if(v != 0) {
                CastDevice castDevice1 = this.zzk;
                if(castDevice1 != null) {
                    zzu zzu0 = this.zzh;
                    if(zzu0 != null) {
                        zzu0.zzk(castDevice1);
                    }
                    for(Object object0: new HashSet(this.zzd)) {
                        ((Listener)object0).onDeviceNameChanged();
                    }
                    com.google.android.gms.cast.framework.zzu zzu1 = this.zzm;
                    if(zzu1 != null) {
                        zzu1.zzb();
                    }
                }
            }
        }
    }

    public final boolean zzl() {
        return this.zzg.zzw();
    }

    private final void zzo(Bundle bundle0) {
        CastDevice castDevice0 = CastDevice.getFromBundle(bundle0);
        this.zzk = castDevice0;
        if(castDevice0 == null) {
            if(this.isResuming()) {
                this.notifyFailedToResumeSession(0x869);
                return;
            }
            this.notifyFailedToStartSession(0x867);
            return;
        }
        zzr zzr0 = this.zzi;
        if(zzr0 != null) {
            zzr0.zzf();
            this.zzi = null;
        }
        CastSession.zzb.d("Acquiring a connection to Google Play Services for %s", new Object[]{this.zzk});
        CastDevice castDevice1 = (CastDevice)Preconditions.checkNotNull(this.zzk);
        Bundle bundle1 = new Bundle();
        CastMediaOptions castMediaOptions0 = this.zzf == null ? null : this.zzf.getCastMediaOptions();
        boolean z = true;
        boolean z1 = castMediaOptions0 != null && castMediaOptions0.zza();
        if((castMediaOptions0 == null ? null : castMediaOptions0.getNotificationOptions()) == null) {
            z = false;
        }
        bundle1.putBoolean("com.google.android.gms.cast.EXTRA_CAST_FRAMEWORK_NOTIFICATION_ENABLED", z);
        bundle1.putBoolean("com.google.android.gms.cast.EXTRA_CAST_REMOTE_CONTROL_NOTIFICATION_ENABLED", z1);
        bundle1.putBoolean("com.google.android.gms.cast.EXTRA_CAST_ALWAYS_FOLLOW_SESSION_ENABLED", this.zzg.zzw());
        bundle1.putBoolean("com.google.android.gms.cast.EXTRA_USE_ROUTE_CONNECTION", this.zzg.zzv());
        Builder cast$CastOptions$Builder0 = new Builder(castDevice1, new zzy(this, null));
        cast$CastOptions$Builder0.zzc(bundle1);
        com.google.android.gms.cast.Cast.CastOptions cast$CastOptions0 = cast$CastOptions$Builder0.build();
        zzr zzr1 = Cast.zza(this.zzc, cast$CastOptions0);
        zzr1.zzk(new zzz(this, null));
        this.zzi = zzr1;
        zzr1.zze();
    }
}

