package com.google.android.gms.measurement.internal;

import P1.c;
import W.m;
import android.app.Application;
import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzkl;
import com.google.android.gms.internal.measurement.zzql;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import k8.Y;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzib implements zzjf {
    private volatile Boolean zzA;
    private volatile boolean zzB;
    private int zzC;
    private int zzD;
    private final AtomicInteger zzE;
    final long zza;
    private static volatile zzib zzb;
    private final Context zzc;
    private final boolean zzd;
    private final zzae zze;
    private final zzal zzf;
    private final zzhg zzg;
    private final zzgt zzh;
    private final zzhy zzi;
    private final zzob zzj;
    private final zzpo zzk;
    private final zzgm zzl;
    private final Clock zzm;
    private final zzma zzn;
    private final zzli zzo;
    private final zzd zzp;
    private final zzln zzq;
    private final String zzr;
    private zzgk zzs;
    private zznk zzt;
    private zzba zzu;
    private zzgh zzv;
    private zzlp zzw;
    private boolean zzx;
    private Boolean zzy;
    private long zzz;

    public zzib(zzjr zzjr0) {
        boolean z = false;
        this.zzx = false;
        this.zzE = new AtomicInteger(0);
        Preconditions.checkNotNull(zzjr0);
        Context context0 = zzjr0.zza;
        zzae zzae0 = new zzae(context0);
        this.zze = zzae0;
        zzfr.zza = zzae0;
        this.zzc = context0;
        this.zzd = zzjr0.zze;
        this.zzA = zzjr0.zzb;
        this.zzr = zzjr0.zzg;
        this.zzB = true;
        zzkl.zzb(context0);
        Clock clock0 = DefaultClock.getInstance();
        this.zzm = clock0;
        this.zza = zzjr0.zzf == null ? clock0.currentTimeMillis() : ((long)zzjr0.zzf);
        this.zzf = new zzal(this);
        zzhg zzhg0 = new zzhg(this);
        zzhg0.zzx();
        this.zzg = zzhg0;
        zzgt zzgt0 = new zzgt(this);
        zzgt0.zzx();
        this.zzh = zzgt0;
        zzpo zzpo0 = new zzpo(this);
        zzpo0.zzx();
        this.zzk = zzpo0;
        this.zzl = new zzgm(new zzjq(zzjr0, this));
        this.zzp = new zzd(this);
        zzma zzma0 = new zzma(this);
        zzma0.zzc();
        this.zzn = zzma0;
        zzli zzli0 = new zzli(this);
        zzli0.zzc();
        this.zzo = zzli0;
        zzob zzob0 = new zzob(this);
        zzob0.zzc();
        this.zzj = zzob0;
        zzln zzln0 = new zzln(this);
        zzln0.zzx();
        this.zzq = zzln0;
        zzhy zzhy0 = new zzhy(this);
        zzhy0.zzx();
        this.zzi = zzhy0;
        if(zzjr0.zzd == null || zzjr0.zzd.zzb == 0L) {
            z = true;
        }
        if(context0.getApplicationContext() instanceof Application) {
            zzib.zzO(zzli0);
            if(zzli0.zzu.zzc.getApplicationContext() instanceof Application) {
                Application application0 = (Application)zzli0.zzu.zzc.getApplicationContext();
                if(zzli0.zza == null) {
                    zzli0.zza = new zzkx(zzli0);
                }
                if(z) {
                    application0.unregisterActivityLifecycleCallbacks(zzli0.zza);
                    application0.registerActivityLifecycleCallbacks(zzli0.zza);
                    zzib.zzP(zzli0.zzu.zzh);
                    zzli0.zzu.zzh.zzk().zza("Registered activity lifecycle callback");
                }
            }
        }
        else {
            zzib.zzP(zzgt0);
            zzgt0.zze().zza("Application context is not an Application");
        }
        zzhy0.zzj(new zzhz(this, zzjr0));
    }

    public final boolean zzA() {
        return this.zzA != null && this.zzA.booleanValue();
    }

    public final boolean zzB() {
        return this.zzC() == 0;
    }

    public final int zzC() {
        zzhy zzhy0 = this.zzi;
        zzib.zzP(zzhy0);
        zzhy0.zzg();
        zzal zzal0 = this.zzf;
        if(!zzal0.zzt()) {
            zzib.zzP(zzhy0);
            zzhy0.zzg();
            if(this.zzB) {
                zzib.zzN(this.zzg);
                Boolean boolean0 = this.zzg.zzi();
                if(boolean0 != null) {
                    return boolean0.booleanValue() ? 0 : 3;
                }
                Boolean boolean1 = zzal0.zzr("firebase_analytics_collection_enabled");
                if(boolean1 != null) {
                    return boolean1.booleanValue() ? 0 : 4;
                }
                return this.zzA != null && !this.zzA.booleanValue() ? 7 : 0;
            }
            return 8;
        }
        return 1;
    }

    public final void zzD(boolean z) {
        zzib.zzP(this.zzi);
        this.zzi.zzg();
        this.zzB = z;
    }

    public final boolean zzE() {
        zzib.zzP(this.zzi);
        this.zzi.zzg();
        return this.zzB;
    }

    public final void zzF() {
        ++this.zzC;
    }

    public final void zzG() {
        this.zzE.incrementAndGet();
    }

    public final boolean zzH() {
        if(!this.zzx) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        zzib.zzP(this.zzi);
        this.zzi.zzg();
        if(this.zzy == null || this.zzz == 0L || !this.zzy.booleanValue() && Math.abs(this.zzm.elapsedRealtime() - this.zzz) > 1000L) {
            this.zzz = this.zzm.elapsedRealtime();
            zzpo zzpo0 = this.zzk;
            zzib.zzN(zzpo0);
            boolean z = false;
            if(zzpo0.zzY("android.permission.INTERNET")) {
                zzib.zzN(zzpo0);
                if(zzpo0.zzY("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzc).isCallerInstantApp() || this.zzf.zzE() || zzpo.zzau(this.zzc) && zzpo.zzQ(this.zzc, false))) {
                    z = true;
                }
            }
            Boolean boolean0 = Boolean.valueOf(z);
            this.zzy = boolean0;
            if(boolean0.booleanValue()) {
                zzib.zzN(zzpo0);
                this.zzy = Boolean.valueOf(zzpo0.zzA(this.zzv().zzk()));
            }
        }
        return this.zzy.booleanValue();
    }

    public final boolean zzI() {
        zzib.zzP(this.zzi);
        this.zzi.zzg();
        zzln zzln0 = this.zzq;
        zzib.zzP(zzln0);
        zzib.zzP(zzln0);
        String s = this.zzv().zzj();
        boolean z = false;
        if(this.zzf.zzu()) {
            zzib.zzN(this.zzg);
            Pair pair0 = this.zzg.zzb(s);
            if(!((Boolean)pair0.second).booleanValue() && !TextUtils.isEmpty(((CharSequence)pair0.first))) {
                zzib.zzP(zzln0);
                zzln0.zzw();
                ConnectivityManager connectivityManager0 = (ConnectivityManager)zzln0.zzu.zzc.getSystemService("connectivity");
                Bundle bundle0 = null;
                NetworkInfo networkInfo0 = null;
                if(connectivityManager0 != null) {
                    try {
                        networkInfo0 = connectivityManager0.getActiveNetworkInfo();
                    }
                    catch(SecurityException unused_ex) {
                    }
                }
                if(networkInfo0 != null && networkInfo0.isConnected()) {
                    StringBuilder stringBuilder0 = new StringBuilder();
                    zznk zznk0 = this.zzt();
                    zznk0.zzg();
                    zznk0.zzb();
                    if(zznk0.zzK()) {
                        zzib.zzN(zznk0.zzu.zzk);
                        if(zznk0.zzu.zzk.zzah() >= 234200) {
                            goto label_26;
                        }
                    }
                    else {
                    label_26:
                        zzib.zzO(this.zzo);
                        this.zzo.zzg();
                        zzao zzao0 = this.zzo.zzu.zzt().zzz();
                        if(zzao0 != null) {
                            bundle0 = zzao0.zza;
                        }
                        if(bundle0 == null) {
                            int v = this.zzD;
                            this.zzD = v + 1;
                            if(v < 10) {
                                z = true;
                            }
                            zzib.zzP(this.zzh);
                            String s1 = v >= 10 ? "Skipping." : "Retrying.";
                            this.zzh.zzj().zzb(Y.l(new StringBuilder(s1.length() + 60), "Failed to retrieve DMA consent from the service, ", s1, " retryCount"), this.zzD);
                            return z;
                        }
                        zzjk zzjk0 = zzjk.zze(bundle0, 100);
                        stringBuilder0.append("&gcs=");
                        stringBuilder0.append(zzjk0.zzk());
                        zzaz zzaz0 = zzaz.zzh(bundle0, 100);
                        stringBuilder0.append("&dma=");
                        stringBuilder0.append(!Objects.equals(zzaz0.zzj(), Boolean.FALSE));
                        if(!TextUtils.isEmpty(zzaz0.zzk())) {
                            stringBuilder0.append("&dma_cps=");
                            stringBuilder0.append(zzaz0.zzk());
                        }
                        boolean z1 = Objects.equals(zzaz.zzi(bundle0), Boolean.TRUE);
                        stringBuilder0.append("&npa=");
                        stringBuilder0.append(!z1);
                        zzib.zzP(this.zzh);
                        this.zzh.zzk().zzb("Consent query parameters to Bow", stringBuilder0);
                    }
                    zzib.zzN(this.zzk);
                    this.zzv().zzu.zzf.zzi();
                    String s2 = (String)pair0.first;
                    zzib.zzN(this.zzg);
                    long v1 = this.zzg.zzp.zza();
                    URL uRL0 = this.zzk.zzat(130000L, s, s2, v1 - 1L, stringBuilder0.toString());
                    if(uRL0 != null) {
                        zzib.zzP(this.zzq);
                        zzia zzia0 = (String s, int v, Throwable throwable0, byte[] arr_b, Map map0) -> {
                            int v1 = 304;
                            switch(v) {
                                case 200: 
                                case 204: {
                                    v1 = v;
                                    goto label_5;
                                }
                                case 304: {
                                label_5:
                                    if(throwable0 == null) {
                                        zzib.zzN(this.zzg);
                                        this.zzg.zzo.zzb(true);
                                        if(arr_b != null && arr_b.length != 0) {
                                            try {
                                                JSONObject jSONObject0 = new JSONObject(new String(arr_b));
                                                String s1 = jSONObject0.optString("deeplink", "");
                                                if(TextUtils.isEmpty(s1)) {
                                                    zzib.zzP(this.zzh);
                                                    this.zzh.zzj().zza("Deferred Deep Link is empty.");
                                                    return;
                                                }
                                                String s2 = jSONObject0.optString("gclid", "");
                                                String s3 = jSONObject0.optString("gbraid", "");
                                                String s4 = jSONObject0.optString("gad_source", "");
                                                double f = jSONObject0.optDouble("timestamp", 0.0);
                                                Bundle bundle0 = new Bundle();
                                                zzpo zzpo0 = this.zzk;
                                                zzib.zzN(zzpo0);
                                                zzib zzib0 = zzpo0.zzu;
                                                if(TextUtils.isEmpty(s1)) {
                                                    zzib.zzP(this.zzh);
                                                    this.zzh.zze().zzd("Deferred Deep Link validation failed. gclid, gbraid, deep link", s2, s3, s1);
                                                    return;
                                                }
                                                Context context0 = zzib0.zzc;
                                                List list0 = context0.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(s1)), 0);
                                                if(list0 == null || list0.isEmpty()) {
                                                    zzib.zzP(this.zzh);
                                                    this.zzh.zze().zzd("Deferred Deep Link validation failed. gclid, gbraid, deep link", s2, s3, s1);
                                                    return;
                                                }
                                                if(!TextUtils.isEmpty(s3)) {
                                                    bundle0.putString("gbraid", s3);
                                                }
                                                if(!TextUtils.isEmpty(s4)) {
                                                    bundle0.putString("gad_source", s4);
                                                }
                                                bundle0.putString("gclid", s2);
                                                bundle0.putString("_cis", "ddp");
                                                this.zzo.zzF("auto", "_cmp", bundle0);
                                                zzib.zzN(zzpo0);
                                                if(!TextUtils.isEmpty(s1)) {
                                                    try {
                                                        SharedPreferences.Editor sharedPreferences$Editor0 = context0.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                                        sharedPreferences$Editor0.putString("deeplink", s1);
                                                        sharedPreferences$Editor0.putLong("timestamp", Double.doubleToRawLongBits(f));
                                                        if(sharedPreferences$Editor0.commit()) {
                                                            goto label_48;
                                                        }
                                                    }
                                                    catch(RuntimeException runtimeException0) {
                                                        zzib.zzP(zzpo0.zzu.zzh);
                                                        zzpo0.zzu.zzh.zzb().zzb("Failed to persist Deferred Deep Link. exception", runtimeException0);
                                                    }
                                                    return;
                                                label_48:
                                                    Intent intent0 = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
                                                    Context context1 = zzpo0.zzu.zzc;
                                                    if(Build.VERSION.SDK_INT < 34) {
                                                        context1.sendBroadcast(intent0);
                                                        return;
                                                    }
                                                    m.u(context1, intent0, m.e(BroadcastOptions.makeBasic()).toBundle());
                                                    return;
                                                }
                                                return;
                                            }
                                            catch(JSONException jSONException0) {
                                            }
                                            zzib.zzP(this.zzh);
                                            this.zzh.zzb().zzb("Failed to parse the Deferred Deep Link response. exception", jSONException0);
                                            return;
                                        }
                                        zzib.zzP(this.zzh);
                                        this.zzh.zzj().zza("Deferred Deep Link response empty.");
                                        return;
                                    }
                                    break;
                                }
                                default: {
                                    v1 = v;
                                }
                            }
                            zzib.zzP(this.zzh);
                            this.zzh.zze().zzc("Network Request for Deferred Deep Link failed. response, exception", v1, throwable0);
                        };
                        this.zzq.zzw();
                        Preconditions.checkNotNull(uRL0);
                        Preconditions.checkNotNull(zzia0);
                        zzib.zzP(this.zzq.zzu.zzi);
                        zzlm zzlm0 = new zzlm(this.zzq, s, uRL0, null, null, zzia0);
                        this.zzq.zzu.zzi.zzm(zzlm0);
                    }
                    return false;
                }
                zzib.zzP(this.zzh);
                this.zzh.zze().zza("Network is not available for Deferred Deep Link request. Skipping");
                return false;
            }
            zzib.zzP(this.zzh);
            this.zzh.zzk().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return false;
        }
        zzib.zzP(this.zzh);
        this.zzh.zzk().zza("ADID collection is disabled from Manifest. Skipping");
        return false;
    }

    // 检测为 Lambda 实现
    public final void zzJ(String s, int v, Throwable throwable0, byte[] arr_b, Map map0) [...]

    public final void zzK(zzjr zzjr0) {
        zzib.zzP(this.zzi);
        this.zzi.zzg();
        zzba zzba0 = new zzba(this);
        zzba0.zzx();
        this.zzu = zzba0;
        zzgh zzgh0 = new zzgh(this, zzjr0.zzc, (zzjr0.zzd == null ? 0L : zzjr0.zzd.zza));
        zzgh0.zzc();
        this.zzv = zzgh0;
        zzgk zzgk0 = new zzgk(this);
        zzgk0.zzc();
        this.zzs = zzgk0;
        zznk zznk0 = new zznk(this);
        zznk0.zzc();
        this.zzt = zznk0;
        this.zzk.zzy();
        this.zzg.zzy();
        this.zzv.zzd();
        zzlp zzlp0 = new zzlp(this);
        zzlp0.zzc();
        this.zzw = zzlp0;
        zzlp0.zzd();
        zzgt zzgt0 = this.zzh;
        zzib.zzP(zzgt0);
        this.zzf.zzi();
        zzgt0.zzi().zzb("App measurement initialized, version", 130000L);
        zzib.zzP(zzgt0);
        zzgt0.zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String s = zzgh0.zzj();
        zzib.zzN(this.zzk);
        if(this.zzk.zzaa(s, this.zzf.zzz())) {
            zzib.zzP(zzgt0);
            zzgt0.zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
        }
        else {
            zzib.zzP(zzgt0);
            zzgt0.zzi().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app " + s);
        }
        zzib.zzP(zzgt0);
        zzgt0.zzj().zza("Debug-level message logging enabled");
        AtomicInteger atomicInteger0 = this.zzE;
        if(this.zzC != atomicInteger0.get()) {
            zzib.zzP(zzgt0);
            zzgt0.zzb().zzc("Not all components initialized", this.zzC, atomicInteger0.get());
        }
        this.zzx = true;
    }

    public static final void zzL() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzM(zzf zzf0) {
        if(zzf0 == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzN(zzjd zzjd0) {
        if(zzjd0 == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzO(zzg zzg0) {
        if(zzg0 == null) {
            throw new IllegalStateException("Component not created");
        }
        if(!zzg0.zza()) {
            throw new IllegalStateException("Component not initialized: " + zzg0.getClass());
        }
    }

    private static final void zzP(zzje zzje0) {
        if(zzje0 == null) {
            throw new IllegalStateException("Component not created");
        }
        if(!zzje0.zzv()) {
            throw new IllegalStateException("Component not initialized: " + zzje0.getClass());
        }
    }

    public final void zza(zzdd zzdd0) {
        zzjk zzjk1;
        zzib.zzP(this.zzi);
        this.zzi.zzg();
        zzin zzin0 = this.zzx().zzj();
        zzql.zza();
        zzal zzal0 = this.zzf;
        boolean z = zzal0.zzp(null, zzfx.zzaQ);
        boolean z1 = zzin0 == zzin.zzb;
        if(z) {
            zzib.zzN(this.zzk);
            if(this.zzk.zzS()) {
                goto label_12;
            }
            else {
                goto label_10;
            }
        }
        else {
        label_10:
            if(z1) {
                z1 = true;
            label_12:
                zzib.zzN(this.zzk);
                this.zzk.zzg();
                IntentFilter intentFilter0 = new IntentFilter();
                intentFilter0.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                intentFilter0.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                zzw zzw0 = new zzw(this.zzk.zzu);
                c.registerReceiver(this.zzk.zzu.zzc, zzw0, intentFilter0, 2);
                zzib.zzP(this.zzk.zzu.zzh);
                this.zzk.zzu.zzh.zzj().zza("Registered app receiver");
                if(z1) {
                    this.zzx().zzh(((long)(((Long)zzfx.zzB.zzb(null)))));
                }
            }
        }
        zzhg zzhg0 = this.zzg;
        zzib.zzN(zzhg0);
        zzjk zzjk0 = zzhg0.zzl();
        int v = zzjk0.zzb();
        zzjh zzjh0 = zzal0.zzw("google_analytics_default_allow_ad_storage", false);
        zzjh zzjh1 = zzal0.zzw("google_analytics_default_allow_analytics_storage", false);
        zzjh zzjh2 = zzjh.zza;
        if(zzjh0 == zzjh2 && zzjh1 == zzjh2) {
        label_35:
            if(!TextUtils.isEmpty(this.zzv().zzk()) && (v == 0 || v == 30 || (v == 10 || v == 40))) {
                zzib.zzO(this.zzo);
                zzjk zzjk2 = new zzjk(null, null, -10);
                this.zzo.zzs(zzjk2, false);
            }
            zzjk1 = null;
        }
        else {
            zzib.zzN(zzhg0);
            if(zzhg0.zzk(-10)) {
                zzjk1 = zzjk.zza(zzjh0, zzjh1, -10);
                goto label_40;
            }
            goto label_35;
        }
    label_40:
        if(zzjk1 != null) {
            zzib.zzO(this.zzo);
            this.zzo.zzs(zzjk1, true);
            zzjk0 = zzjk1;
        }
        zzli zzli0 = this.zzo;
        zzib.zzO(zzli0);
        zzli0.zzA(zzjk0);
        zzib.zzN(zzhg0);
        int v1 = zzhg0.zzj().zzb();
        zzjh zzjh3 = zzal0.zzw("google_analytics_default_allow_ad_personalization_signals", true);
        if(zzjh3 != zzjh2) {
            zzib.zzP(this.zzh);
            this.zzh.zzk().zzb("Default ad personalization consent from Manifest", zzjh3);
        }
        zzjh zzjh4 = zzal0.zzw("google_analytics_default_allow_ad_user_data", true);
        if(zzjh4 != zzjh2 && zzjk.zzu(-10, v1)) {
            zzib.zzO(zzli0);
            zzli0.zzq(zzaz.zza(zzjh4, -10), true);
        }
        else if(!TextUtils.isEmpty(this.zzv().zzk()) && (v1 == 0 || v1 == 30)) {
            zzib.zzO(zzli0);
            zzli0.zzq(new zzaz(null, -10, null, null), true);
        }
        else if(TextUtils.isEmpty(this.zzv().zzk()) && zzdd0 != null) {
            Bundle bundle0 = zzdd0.zzd;
            if(bundle0 != null && zzjk.zzu(30, v1)) {
                zzaz zzaz0 = zzaz.zzh(bundle0, 30);
                if(zzaz0.zzd()) {
                    zzib.zzO(zzli0);
                    zzli0.zzq(zzaz0, true);
                }
            }
        }
        Boolean boolean0 = zzal0.zzr("google_analytics_tcf_data_enabled");
        if(boolean0 == null || boolean0.booleanValue()) {
            zzib.zzP(this.zzh);
            this.zzh.zzj().zza("TCF client enabled.");
            zzib.zzO(zzli0);
            zzli0.zzE();
            zzib.zzO(zzli0);
            zzli0.zzD();
        }
        zzib.zzN(zzhg0);
        zzhd zzhd0 = zzhg0.zzc;
        if(zzhd0.zza() == 0L) {
            zzib.zzP(this.zzh);
            this.zzh.zzk().zzb("Persisting first open", this.zza);
            zzib.zzN(zzhg0);
            zzhd0.zzb(this.zza);
        }
        zzib.zzO(zzli0);
        zzli0.zzb.zzc();
        if(this.zzH()) {
            if(!TextUtils.isEmpty(this.zzv().zzk())) {
                zzib.zzN(this.zzk);
                String s = this.zzv().zzk();
                zzib.zzN(zzhg0);
                zzhg0.zzg();
                String s1 = zzhg0.zzd().getString("gmp_app_id", null);
                if(this.zzk.zzB(s, s1)) {
                    zzib.zzP(this.zzh);
                    this.zzh.zzi().zza("Rechecking which service to use due to a GMP App Id change");
                    zzib.zzN(zzhg0);
                    zzhg0.zzg();
                    Boolean boolean1 = zzhg0.zzi();
                    SharedPreferences.Editor sharedPreferences$Editor0 = zzhg0.zzd().edit();
                    sharedPreferences$Editor0.clear();
                    sharedPreferences$Editor0.apply();
                    if(boolean1 != null) {
                        zzhg0.zzh(boolean1);
                    }
                    this.zzm().zzh();
                    this.zzt.zzM();
                    this.zzt.zzI();
                    zzib.zzN(zzhg0);
                    zzhd0.zzb(this.zza);
                    zzib.zzN(zzhg0);
                    zzhg0.zze.zzb(null);
                }
                zzib.zzN(zzhg0);
                String s2 = this.zzv().zzk();
                zzhg0.zzg();
                SharedPreferences.Editor sharedPreferences$Editor1 = zzhg0.zzd().edit();
                sharedPreferences$Editor1.putString("gmp_app_id", s2);
                sharedPreferences$Editor1.apply();
            }
            zzib.zzN(zzhg0);
            if(!zzhg0.zzl().zzo(zzjj.zzb)) {
                zzib.zzN(zzhg0);
                zzhg0.zze.zzb(null);
            }
            zzib.zzO(zzli0);
            zzib.zzN(zzhg0);
            zzli0.zzR(zzhg0.zze.zza());
            zzib.zzN(this.zzk);
            try {
                this.zzk.zzu.zzc.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            }
            catch(ClassNotFoundException unused_ex) {
                zzhg zzhg1 = this.zzg;
                zzib.zzN(zzhg1);
                zzhf zzhf0 = zzhg1.zzq;
                if(!TextUtils.isEmpty(zzhf0.zza())) {
                    zzib.zzP(this.zzh);
                    this.zzh.zze().zza("Remote config removed with active feature rollouts");
                    zzib.zzN(zzhg1);
                    zzhf0.zzb(null);
                }
            }
            if(!TextUtils.isEmpty(this.zzv().zzk())) {
                boolean z2 = this.zzB();
                zzhg zzhg2 = this.zzg;
                zzib.zzN(zzhg2);
                if(!zzhg2.zzo() && !this.zzf.zzt()) {
                    zzib.zzN(zzhg2);
                    zzhg2.zzn(!z2);
                }
                if(z2) {
                    zzib.zzO(this.zzo);
                    this.zzo.zzU();
                }
                zzib.zzO(this.zzj);
                this.zzj.zza.zza();
                this.zzt().zzC(new AtomicReference());
                zznk zznk0 = this.zzt();
                zzib.zzN(zzhg2);
                zznk0.zzH(zzhg2.zzt.zza());
            }
        }
        else if(this.zzB()) {
            zzpo zzpo0 = this.zzk;
            zzib.zzN(zzpo0);
            if(!zzpo0.zzY("android.permission.INTERNET")) {
                zzib.zzP(this.zzh);
                this.zzh.zzb().zza("App is missing INTERNET permission");
            }
            zzib.zzN(zzpo0);
            if(!zzpo0.zzY("android.permission.ACCESS_NETWORK_STATE")) {
                zzib.zzP(this.zzh);
                this.zzh.zzb().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            Context context0 = this.zzc;
            if(!Wrappers.packageManager(context0).isCallerInstantApp() && !this.zzf.zzE()) {
                if(!zzpo.zzau(context0)) {
                    zzib.zzP(this.zzh);
                    this.zzh.zzb().zza("AppMeasurementReceiver not registered/enabled");
                }
                if(!zzpo.zzQ(context0, false)) {
                    zzib.zzP(this.zzh);
                    this.zzh.zzb().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzib.zzP(this.zzh);
            this.zzh.zzb().zza("Uploading is not possible. App measurement disabled");
        }
        zzql.zza();
        if(this.zzf.zzp(null, zzfx.zzaQ)) {
            zzib.zzN(this.zzk);
            if(this.zzk.zzS()) {
                long v2 = Math.max(500L, ((long)(((int)(((Integer)zzfx.zzax.zzb(null)))))) * 1000L + ((long)new Random().nextInt(5000)) - this.zzm.elapsedRealtime());
                if(v2 > 500L) {
                    zzib.zzP(this.zzh);
                    this.zzh.zzk().zzb("Waiting to fetch trigger URIs until some time after boot. Delay in millis", v2);
                }
                zzib.zzO(this.zzo);
                this.zzo.zzu(v2);
            }
        }
        zzib.zzN(this.zzg);
        this.zzg.zzj.zzb(true);
    }

    @Override  // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final zzae zzaU() {
        return this.zze;
    }

    @Override  // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final zzgt zzaV() {
        zzib.zzP(this.zzh);
        return this.zzh;
    }

    @Override  // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final zzhy zzaW() {
        zzib.zzP(this.zzi);
        return this.zzi;
    }

    @Override  // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final Context zzaY() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final Clock zzaZ() {
        return this.zzm;
    }

    @Pure
    public final zzal zzc() {
        return this.zzf;
    }

    @Pure
    public final zzhg zzd() {
        zzib.zzN(this.zzg);
        return this.zzg;
    }

    public final zzgt zzf() {
        return this.zzh == null || !this.zzh.zzv() ? null : this.zzh;
    }

    @Pure
    public final zzob zzh() {
        zzib.zzO(this.zzj);
        return this.zzj;
    }

    @SideEffectFree
    public final zzhy zzi() {
        return this.zzi;
    }

    @Pure
    public final zzli zzj() {
        zzib.zzO(this.zzo);
        return this.zzo;
    }

    @Pure
    public final zzpo zzk() {
        zzib.zzN(this.zzk);
        return this.zzk;
    }

    @Pure
    public final zzgm zzl() {
        return this.zzl;
    }

    @Pure
    public final zzgk zzm() {
        zzib.zzO(this.zzs);
        return this.zzs;
    }

    @Pure
    public final zzln zzn() {
        zzib.zzP(this.zzq);
        return this.zzq;
    }

    @Pure
    public final boolean zzp() {
        return this.zzd;
    }

    @Pure
    public final String zzq() {
        return this.zzr;
    }

    @Pure
    public final zzma zzs() {
        zzib.zzO(this.zzn);
        return this.zzn;
    }

    @Pure
    public final zznk zzt() {
        zzib.zzO(this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzba zzu() {
        zzib.zzP(this.zzu);
        return this.zzu;
    }

    @Pure
    public final zzgh zzv() {
        zzib.zzO(this.zzv);
        return this.zzv;
    }

    @Pure
    public final zzd zzw() {
        zzib.zzM(this.zzp);
        return this.zzp;
    }

    @Pure
    public final zzlp zzx() {
        zzib.zzM(this.zzw);
        return this.zzw;
    }

    public static zzib zzy(Context context0, zzdd zzdd0, Long long0) {
        if(zzdd0 != null) {
            zzdd0 = new zzdd(zzdd0.zza, zzdd0.zzb, zzdd0.zzc, zzdd0.zzd, null);
        }
        Preconditions.checkNotNull(context0);
        Preconditions.checkNotNull(context0.getApplicationContext());
        if(zzib.zzb == null) {
            synchronized(zzib.class) {
                if(zzib.zzb == null) {
                    zzib.zzb = new zzib(new zzjr(context0, zzdd0, long0));
                }
            }
        }
        else if(zzdd0 != null) {
            Bundle bundle0 = zzdd0.zzd;
            if(bundle0 != null && bundle0.containsKey("dataCollectionDefaultEnabled")) {
                Preconditions.checkNotNull(zzib.zzb);
                zzib zzib0 = zzib.zzb;
                zzib0.zzA = Boolean.valueOf(bundle0.getBoolean("dataCollectionDefaultEnabled"));
            }
        }
        Preconditions.checkNotNull(zzib.zzb);
        return zzib.zzb;
    }

    public final void zzz(boolean z) {
        this.zzA = Boolean.valueOf(z);
    }
}

