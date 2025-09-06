package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import com.gaa.sdk.auth.e;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionTransferCallback;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import df.B;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import l4.O;
import l4.Q;
import l4.j0;
import l4.k0;
import w1.j;

@TargetApi(30)
public final class zzbn {
    private static final Logger zza;
    private final CastOptions zzb;
    private final Set zzc;
    private final Handler zzd;
    private final Runnable zze;
    private int zzf;
    private boolean zzg;
    private SessionManager zzh;
    private j zzi;
    private SessionState zzj;
    private k0 zzk;

    static {
        zzbn.zza = new Logger("SessionTransController");
    }

    public zzbn(CastOptions castOptions0) {
        this.zzc = Collections.synchronizedSet(new HashSet());
        this.zzb = castOptions0;
        this.zzf = 0;
        this.zzd = new zzet(Looper.getMainLooper());
        this.zze = () -> {
            zzbn.zza.i("transfer with type = %d has timed out", new Object[]{this.zzf});
            this.zzr(101);
        };
    }

    // 检测为 Lambda 实现
    public static void zzc(zzbn zzbn0, SessionState sessionState0) [...]

    // 检测为 Lambda 实现
    public static void zzd(zzbn zzbn0, Exception exception0) [...]

    // 检测为 Lambda 实现
    public static void zze(zzbn zzbn0) [...]

    // 检测为 Lambda 实现
    public static void zzf(zzbn zzbn0) [...]

    public static void zzg(zzbn zzbn0) {
        int v = zzbn0.zzf;
        if(v == 0) {
            zzbn.zza.d("No need to notify transferred if the transfer type is unknown", new Object[0]);
            return;
        }
        SessionState sessionState0 = zzbn0.zzj;
        if(sessionState0 == null) {
            zzbn.zza.d("No need to notify with null sessionState", new Object[0]);
            return;
        }
        zzbn.zza.d("notify transferred with type = %d, sessionState = %s", new Object[]{v, zzbn0.zzj});
        for(Object object0: new HashSet(zzbn0.zzc)) {
            ((SessionTransferCallback)object0).onTransferred(zzbn0.zzf, sessionState0);
        }
    }

    public static void zzi(zzbn zzbn0) {
        if(zzbn0.zzj == null) {
            zzbn.zza.d("skip restoring session state due to null SessionState", new Object[0]);
            return;
        }
        RemoteMediaClient remoteMediaClient0 = zzbn0.zzq();
        if(remoteMediaClient0 == null) {
            zzbn.zza.d("skip restoring session state due to null RemoteMediaClient", new Object[0]);
            return;
        }
        zzbn.zza.d("resume SessionState to current session", new Object[0]);
        remoteMediaClient0.zzr(zzbn0.zzj);
    }

    public final void zzj(SessionManager sessionManager0) {
        this.zzh = sessionManager0;
        ((Handler)Preconditions.checkNotNull(this.zzd)).post(() -> {
            zzbl zzbl0 = new zzbl(this, null);
            ((SessionManager)Preconditions.checkNotNull(this.zzh)).addSessionManagerListener(zzbl0, CastSession.class);
        });
    }

    public final void zzk(O o0, O o1, j j0) {
        int v = 1;
        Set set0 = this.zzc;
        if(new HashSet(set0).isEmpty()) {
            zzbn.zza.d("No need to prepare transfer without any callback", new Object[0]);
            j0.a(null);
            return;
        }
        if(o0.l != 1) {
            zzbn.zza.d("No need to prepare transfer when transferring from local", new Object[0]);
            j0.a(null);
            return;
        }
        RemoteMediaClient remoteMediaClient0 = this.zzq();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            Logger logger0 = zzbn.zza;
            logger0.d("Prepare route transfer for changing endpoint", new Object[0]);
            if(o1.l == 0) {
                zzp.zzd(zzpb.zzP);
            }
            else {
                v = CastDevice.getFromBundle(o1.s) == null ? 3 : 2;
            }
            this.zzf = v;
            this.zzi = j0;
            logger0.d("notify transferring with type = %d", new Object[]{v});
            for(Object object0: new HashSet(set0)) {
                ((SessionTransferCallback)object0).onTransferring(this.zzf);
            }
            this.zzj = null;
            remoteMediaClient0.zzk(null).addOnSuccessListener((SessionState sessionState0) -> {
                this.zzj = sessionState0;
                j j0 = this.zzi;
                if(j0 != null) {
                    j0.a(null);
                }
            }).addOnFailureListener((Exception exception0) -> {
                zzbn.zza.w(exception0, "Fail to store SessionState", new Object[0]);
                this.zzr(100);
            });
            ((Handler)Preconditions.checkNotNull(this.zzd)).postDelayed(((Runnable)Preconditions.checkNotNull(this.zze)), 20000L);
            return;
        }
        zzbn.zza.d("No need to prepare transfer when there is no media session", new Object[0]);
        j0.a(null);
    }

    public final void zzl(SessionTransferCallback sessionTransferCallback0) {
        zzbn.zza.d("register callback = %s", new Object[]{sessionTransferCallback0});
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(sessionTransferCallback0);
        this.zzc.add(sessionTransferCallback0);
    }

    public final void zzm(boolean z) {
        this.zzg = z;
    }

    public final void zzn(SessionTransferCallback sessionTransferCallback0) {
        zzbn.zza.d("unregister callback = %s", new Object[]{sessionTransferCallback0});
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(sessionTransferCallback0 != null) {
            this.zzc.remove(sessionTransferCallback0);
        }
    }

    public final void zzo(Q q0) {
        if(this.zzp()) {
            CastDevice castDevice0 = null;
            CastSession castSession0 = this.zzh == null ? null : this.zzh.getCurrentCastSession();
            if(castSession0 != null) {
                castDevice0 = castSession0.getCastDevice();
            }
            if(castDevice0 != null) {
                ArrayList arrayList0 = new ArrayList();
                q0.getClass();
                for(Object object0: Q.f()) {
                    O o0 = (O)object0;
                    CastDevice castDevice1 = CastDevice.getFromBundle(o0.s);
                    if(castDevice1 != null && !castDevice1.isSameDevice(castDevice0)) {
                        arrayList0.add(new j0(new e(o0.c)));
                    }
                }
                zzbn.zza.d("updateRouteListingPreference with %d available routes", new Object[]{arrayList0.size()});
                B b0 = new B();
                b0.b = Collections.unmodifiableList(new ArrayList(arrayList0));
                k0 k00 = new k0(b0);
                this.zzk = k00;
                Q.k(k00);
            }
        }
    }

    // 去混淆评级： 低(20)
    public final boolean zzp() {
        return this.zzg && this.zzb.zzh();
    }

    private final RemoteMediaClient zzq() {
        SessionManager sessionManager0 = this.zzh;
        if(sessionManager0 == null) {
            zzbn.zza.d("skip transferring as SessionManager is null", new Object[0]);
            return null;
        }
        CastSession castSession0 = sessionManager0.getCurrentCastSession();
        if(castSession0 == null) {
            zzbn.zza.d("skip transferring as CastSession is null", new Object[0]);
            return null;
        }
        return castSession0.getRemoteMediaClient();
    }

    private final void zzr(int v) {
        j j0 = this.zzi;
        if(j0 != null) {
            j0.b();
        }
        zzbn.zza.d("notify failed transfer with type = %d, reason = %d", new Object[]{this.zzf, v});
        for(Object object0: new HashSet(this.zzc)) {
            ((SessionTransferCallback)object0).onTransferFailed(this.zzf, v);
        }
        this.zzs();
    }

    private final void zzs() {
        ((Handler)Preconditions.checkNotNull(this.zzd)).removeCallbacks(((Runnable)Preconditions.checkNotNull(this.zze)));
        this.zzf = 0;
        this.zzj = null;
    }
}

