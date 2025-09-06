package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzht;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzls;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzfb {
    protected final Clock zza;
    protected final ExecutorService zzb;
    private static volatile zzfb zzc;
    private final String zzd;
    private final AppMeasurementSdk zze;
    private final List zzf;
    private int zzg;
    private boolean zzh;
    private final String zzi;
    private volatile zzcr zzj;

    public zzfb(Context context0, Bundle bundle0) {
        this.zzd = "FA";
        this.zza = DefaultClock.getInstance();
        zzed zzed0 = new zzed(this);
        ThreadPoolExecutor threadPoolExecutor0 = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzed0);
        threadPoolExecutor0.allowCoreThreadTimeOut(true);
        this.zzb = Executors.unconfigurableExecutorService(threadPoolExecutor0);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        try {
            if(zzls.zza(context0, "google_app_id", zzht.zza(context0)) != null) {
                goto label_10;
            }
        }
        catch(IllegalStateException unused_ex) {
        }
        goto label_16;
        try {
        label_10:
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, zzfb.class.getClassLoader());
        }
        catch(ClassNotFoundException unused_ex) {
            this.zzi = null;
            this.zzh = true;
            Log.w(this.zzd, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Add Google Analytics for Firebase to resume data collection.");
            return;
        }
    label_16:
        this.zzi = "fa";
        this.zzS(new zzdr(this, context0, bundle0));
        Application application0 = (Application)context0.getApplicationContext();
        if(application0 == null) {
            Log.w(this.zzd, "Unable to register lifecycle notifications. Application null.");
            return;
        }
        application0.registerActivityLifecycleCallbacks(new zzfa(this));
    }

    public final String zzA() {
        zzco zzco0 = new zzco();
        this.zzS(new zzdz(this, zzco0));
        return zzco0.zzc(500L);
    }

    public final String zzB() {
        zzco zzco0 = new zzco();
        this.zzS(new zzea(this, zzco0));
        return zzco0.zzc(500L);
    }

    public final Map zzC(String s, String s1, boolean z) {
        zzco zzco0 = new zzco();
        this.zzS(new zzeb(this, s, s1, z, zzco0));
        Bundle bundle0 = zzco0.zze(5000L);
        if(bundle0 != null && bundle0.size() != 0) {
            Map map0 = new HashMap(bundle0.size());
            for(Object object0: bundle0.keySet()) {
                String s2 = (String)object0;
                Object object1 = bundle0.get(s2);
                if(object1 instanceof Double || object1 instanceof Long || object1 instanceof String) {
                    ((HashMap)map0).put(s2, object1);
                }
            }
            return map0;
        }
        return Collections.EMPTY_MAP;
    }

    public final void zzD(int v, String s, Object object0, Object object1, Object object2) {
        this.zzS(new zzec(this, false, 5, s, object0, null, null));
    }

    public final Bundle zzE(Bundle bundle0, boolean z) {
        zzco zzco0 = new zzco();
        this.zzS(new zzee(this, bundle0, zzco0));
        return z ? zzco0.zze(5000L) : null;
    }

    public final int zzF(String s) {
        zzco zzco0 = new zzco();
        this.zzS(new zzef(this, s, zzco0));
        Integer integer0 = (Integer)zzco.zzf(zzco0.zze(10000L), Integer.class);
        return integer0 == null ? 25 : ((int)integer0);
    }

    public final String zzG() {
        zzco zzco0 = new zzco();
        this.zzS(new zzeg(this, zzco0));
        return zzco0.zzc(120000L);
    }

    public final Long zzH() {
        zzco zzco0 = new zzco();
        this.zzS(new zzeh(this, zzco0));
        return zzco0.zzd(120000L);
    }

    public final String zzI() {
        return this.zzi;
    }

    public final Object zzJ(int v) {
        zzco zzco0 = new zzco();
        this.zzS(new zzei(this, zzco0, v));
        return zzco.zzf(zzco0.zze(15000L), Object.class);
    }

    public final void zzK(boolean z) {
        this.zzS(new zzej(this, z));
    }

    public final void zzL(Bundle bundle0) {
        this.zzS(new zzek(this, bundle0));
    }

    public final void zzM(zzeq zzeq0) {
        this.zzS(zzeq0);
    }

    public final void zzN(Exception exception0, boolean z, boolean z1) {
        this.zzT(exception0, z, z1);
    }

    public final String zzO() {
        return this.zzd;
    }

    public final boolean zzP() {
        return this.zzh;
    }

    public final zzcr zzQ() {
        return this.zzj;
    }

    public final void zzR(zzcr zzcr0) {
        this.zzj = zzcr0;
    }

    private final void zzS(zzeq zzeq0) {
        this.zzb.execute(zzeq0);
    }

    private final void zzT(Exception exception0, boolean z, boolean z1) {
        this.zzh |= z;
        if(z) {
            Log.w(this.zzd, "Data collection startup failed. No data will be collected.", exception0);
            return;
        }
        if(z1) {
            this.zzD(5, "Error with data collection. Data lost.", exception0, null, null);
        }
        Log.w(this.zzd, "Error with data collection. Data lost.", exception0);
    }

    private final void zzU(String s, String s1, Bundle bundle0, boolean z, boolean z1, Long long0) {
        this.zzS(new zzep(this, long0, s, s1, bundle0, z, z1));
    }

    public static zzfb zza(Context context0, Bundle bundle0) {
        Preconditions.checkNotNull(context0);
        if(zzfb.zzc == null) {
            synchronized(zzfb.class) {
                if(zzfb.zzc == null) {
                    zzfb.zzc = new zzfb(context0, bundle0);
                }
            }
        }
        return zzfb.zzc;
    }

    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    public final zzcr zzc(Context context0, boolean z) {
        try {
            return zzcq.asInterface(DynamiteModule.load(context0, (z ? DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION : DynamiteModule.PREFER_LOCAL), "com.google.android.gms.measurement.dynamite").instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        }
        catch(LoadingException dynamiteModule$LoadingException0) {
        }
        this.zzT(dynamiteModule$LoadingException0, true, false);
        return null;
    }

    public final void zzd(zzjo zzjo0) {
        zzer zzer0 = new zzer(zzjo0);
        if(this.zzj != null) {
            try {
                this.zzj.setEventInterceptor(zzer0);
                return;
            }
            catch(RemoteException | BadParcelableException | IllegalArgumentException | IllegalStateException | NetworkOnMainThreadException | NullPointerException | SecurityException | UnsupportedOperationException unused_ex) {
                Log.w(this.zzd, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        this.zzS(new zzel(this, zzer0));
    }

    public final void zze(Intent intent0) {
        this.zzS(new zzem(this, intent0));
    }

    public final void zzf(zzjp zzjp0) {
        zzes zzes0;
        Preconditions.checkNotNull(zzjp0);
        List list0 = this.zzf;
        synchronized(list0) {
            for(int v1 = 0; v1 < list0.size(); ++v1) {
                if(zzjp0.equals(((Pair)list0.get(v1)).first)) {
                    Log.w(this.zzd, "OnEventListener already registered.");
                    return;
                }
            }
            zzes0 = new zzes(zzjp0);
            list0.add(new Pair(zzjp0, zzes0));
        }
        if(this.zzj != null) {
            try {
                this.zzj.registerOnMeasurementEventListener(zzes0);
                return;
            }
            catch(RemoteException | BadParcelableException | IllegalArgumentException | IllegalStateException | NetworkOnMainThreadException | NullPointerException | SecurityException | UnsupportedOperationException unused_ex) {
                Log.w(this.zzd, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
            }
        }
        this.zzS(new zzen(this, zzes0));
    }

    public final void zzg(zzjp zzjp0) {
        zzes zzes0;
        Pair pair0;
        Preconditions.checkNotNull(zzjp0);
        List list0 = this.zzf;
        synchronized(list0) {
            for(int v1 = 0; true; ++v1) {
                pair0 = null;
                if(v1 >= list0.size()) {
                    break;
                }
                if(zzjp0.equals(((Pair)list0.get(v1)).first)) {
                    pair0 = (Pair)list0.get(v1);
                    break;
                }
            }
            if(pair0 == null) {
                Log.w(this.zzd, "OnEventListener had not been registered.");
                return;
            }
            list0.remove(pair0);
            zzes0 = (zzes)pair0.second;
        }
        if(this.zzj != null) {
            try {
                this.zzj.unregisterOnMeasurementEventListener(zzes0);
                return;
            }
            catch(RemoteException | BadParcelableException | IllegalArgumentException | IllegalStateException | NetworkOnMainThreadException | NullPointerException | SecurityException | UnsupportedOperationException unused_ex) {
                Log.w(this.zzd, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
            }
        }
        this.zzS(new zzeo(this, zzes0));
    }

    public final void zzh(String s, Bundle bundle0) {
        this.zzU(null, s, bundle0, false, true, null);
    }

    public final void zzi(String s, String s1, Bundle bundle0) {
        this.zzU(s, s1, bundle0, true, true, null);
    }

    public final void zzj(String s, String s1, Bundle bundle0, long v) {
        this.zzU(s, s1, bundle0, true, false, v);
    }

    public final void zzk(String s, String s1, Object object0, boolean z) {
        this.zzS(new zzdh(this, s, s1, object0, z));
    }

    public final void zzl(Bundle bundle0) {
        this.zzS(new zzdi(this, bundle0));
    }

    public final void zzm(String s, String s1, Bundle bundle0) {
        this.zzS(new zzdj(this, s, s1, bundle0));
    }

    public final List zzn(String s, String s1) {
        zzco zzco0 = new zzco();
        this.zzS(new zzdk(this, s, s1, zzco0));
        List list0 = (List)zzco.zzf(zzco0.zze(5000L), List.class);
        return list0 == null ? Collections.EMPTY_LIST : list0;
    }

    public final void zzo(String s) {
        this.zzS(new zzdl(this, s));
    }

    public final void zzp(zzdf zzdf0, String s, String s1) {
        this.zzS(new zzdm(this, zzdf0, s, s1));
    }

    public final void zzq(Boolean boolean0) {
        this.zzS(new zzdn(this, boolean0));
    }

    public final void zzr(Bundle bundle0) {
        this.zzS(new zzdo(this, bundle0));
    }

    public final void zzs() {
        this.zzS(new zzdp(this));
    }

    public final void zzt(long v) {
        this.zzS(new zzdq(this, v));
    }

    public final void zzu(String s) {
        this.zzS(new zzds(this, s));
    }

    public final void zzv(String s) {
        this.zzS(new zzdt(this, s));
    }

    public final void zzw(Runnable runnable0) {
        this.zzS(new zzdv(this, runnable0));
    }

    public final String zzx() {
        zzco zzco0 = new zzco();
        this.zzS(new zzdw(this, zzco0));
        return zzco0.zzc(500L);
    }

    public final String zzy() {
        zzco zzco0 = new zzco();
        this.zzS(new zzdx(this, zzco0));
        return zzco0.zzc(50L);
    }

    public final long zzz() {
        zzco zzco0 = new zzco();
        this.zzS(new zzdy(this, zzco0));
        Long long0 = zzco0.zzd(500L);
        if(long0 == null) {
            long v = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
            int v1 = this.zzg + 1;
            this.zzg = v1;
            return v + ((long)v1);
        }
        return (long)long0;
    }
}

