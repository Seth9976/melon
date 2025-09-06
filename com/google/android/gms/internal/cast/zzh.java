package com.google.android.gms.internal.cast;

import B3.n;
import H8.i;
import N5.c;
import N5.d;
import N5.f;
import O5.a;
import Q5.u;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.zzav;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.checkerframework.dataflow.qual.Pure;

@ShowFirstParty
public final class zzh {
    @ShowFirstParty
    public static boolean zza;
    f zzb;
    private static final Logger zzc;
    private final Context zzd;
    private final zzn zze;
    private final SessionManager zzf;
    private final zzbn zzg;
    private final zzaf zzh;
    private final String zzi;
    private Long zzj;
    private final ExecutorService zzk;
    private zzbw zzl;
    private int zzm;

    static {
        zzh.zzc = new Logger("ClientCastAnalytics");
        zzh.zza = true;
    }

    private zzh(Context context0, zzn zzn0, SessionManager sessionManager0, zzbn zzbn0, zzaf zzaf0) {
        this.zzd = context0;
        this.zze = zzn0;
        this.zzf = sessionManager0;
        this.zzg = zzbn0;
        this.zzh = zzaf0;
        this.zzm = 1;
        this.zzi = "8f413e5d-d326-4836-a40b-66915681ed00";
        this.zzk = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
    }

    public static zzh zza(Context context0, zzn zzn0, SessionManager sessionManager0, zzbn zzbn0, zzaf zzaf0) {
        return new zzh(context0, zzn0, sessionManager0, zzbn0, zzaf0);
    }

    // 检测为 Lambda 实现
    public static void zzb(zzh zzh0, String s, int v, SharedPreferences sharedPreferences0, Bundle bundle0) [...]

    public final void zzc(Bundle bundle0) {
        int v1;
        int v = 1;
        if(bundle0.containsKey("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE")) {
            v1 = bundle0.getInt("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE", 0);
        }
        else {
            v1 = !bundle0.containsKey("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED") || !bundle0.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", false) ? 0 : 1;
        }
        boolean z = bundle0.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED", false);
        boolean z1 = bundle0.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_ANALYTICS_ENABLED", false);
        zzh.zza = z1;
        if(v1 != 0) {
        label_11:
            long v2 = bundle0.getLong("com.google.android.gms.cast.FLAG_ANALYTICS_CONSENT_TIMEOUT_SECONDS", 5L);
            Context context0 = this.zzd;
            this.zzl = new zzbw(context0, v2);
            if(bundle0.getLong("com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE") != 0L) {
                v = 2;
            }
            this.zzm = v;
            u.b(context0);
            this.zzb = u.a().c(a.e).a("CAST_SENDER_SDK", new c("proto"), new zze());
            if(bundle0.containsKey("com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE")) {
                this.zzj = bundle0.getLong("com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE");
            }
            SharedPreferences sharedPreferences0 = context0.getApplicationContext().getSharedPreferences("com.iloen.melon.client_cast_analytics_data", 0);
            if(v1 != 0) {
                TaskApiCall taskApiCall0 = TaskApiCall.builder().run(new com.google.android.gms.cast.internal.zze(this.zze, new String[]{"com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR", "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON"})).setFeatures(new Feature[]{zzav.zzg}).setAutoResolveMissingFeatures(false).setMethodKey(0x20EA).build();
                this.zze.doRead(taskApiCall0).addOnSuccessListener((Bundle bundle0) -> {
                    SessionManager sessionManager0 = this.zzf;
                    Preconditions.checkNotNull(sessionManager0);
                    zzbn zzbn0 = this.zzg;
                    Class class0 = CastSession.class;
                    if(v1 == 3) {
                    label_7:
                        zzx zzx0 = new zzx(this, this.zzh, "com.iloen.melon");
                        sessionManager0.addSessionManagerListener(new zzu(zzx0), class0);
                        if(zzbn0 != null) {
                            zzbn0.zzl(new zzv(zzx0));
                        }
                    }
                    else if(v1 == 2) {
                        v1 = 2;
                        goto label_7;
                    }
                    if(v1 == 1 || v1 == 2) {
                        zzl zzl0 = new zzl(sharedPreferences0, this, this.zzh, bundle0, "com.iloen.melon");
                        sessionManager0.addSessionManagerListener(new zzj(zzl0), class0);
                        if(zzbn0 != null) {
                            zzbn0.zzl(new zzk(zzl0));
                        }
                    }
                });
            }
            if(z) {
                Preconditions.checkNotNull(sharedPreferences0);
                zzp.zza(sharedPreferences0, this, "com.iloen.melon").zze();
                zzp.zzd(zzpb.zzf);
            }
            if(zzh.zza) {
                zzs.zza(this, "com.iloen.melon");
            }
        }
        else if(z || z1) {
            v1 = 0;
            goto label_11;
        }
    }

    // 检测为 Lambda 实现
    public static void zzd(zzh zzh0, zzqe zzqe0, int v) [...]

    // 检测为 Lambda 实现
    public static void zze(zzh zzh0, zzqe zzqe0, int v, Boolean boolean0) [...]

    @Pure
    public final void zzf(zzqe zzqe0, int v) {
        zzf zzf0 = () -> {
            zzbw zzbw0 = this.zzl;
            if(zzbw0 == null) {
                return;
            }
            zzbw0.zza().addOnSuccessListener((Boolean boolean0) -> if(boolean0.booleanValue()) {
                zzqd zzqd0 = zzqe.zzd(zzqe0);
                zzqd0.zzl(zzh0.zzi);
                zzqd0.zzf(zzh0.zzi);
                Long long0 = zzh0.zzj;
                if(long0 != null) {
                    zzqd0.zzi(((int)(((long)long0))));
                }
                zzqe zzqe1 = (zzqe)zzqd0.zzr();
                int v1 = zzh0.zzm - 1;
                N5.a a0 = null;
                if(zzh0.zzm == 0) {
                    throw null;
                }
                switch(v1) {
                    case 0: {
                        a0 = new N5.a(((int)(v - 1)), zzqe1, d.b, null);
                        break;
                    }
                    case 1: {
                        a0 = new N5.a(((int)(v - 1)), zzqe1, d.a, null);
                    }
                }
                zzh.zzc.d("analytics event: %s", new Object[]{a0});
                Preconditions.checkNotNull(a0);
                f f0 = zzh0.zzb;
                if(f0 != null) {
                    ((i)f0).x(a0, new n(26));
                }
            });
        };
        this.zzk.execute(zzf0);
    }
}

