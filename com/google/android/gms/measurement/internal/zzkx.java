package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzdf;
import java.util.Objects;

final class zzkx implements Application.ActivityLifecycleCallbacks, zzkv {
    final zzli zza;

    public zzkx(zzli zzli0) {
        Objects.requireNonNull(zzli0);
        this.zza = zzli0;
        super();
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity0, Bundle bundle0) {
        this.zza(zzdf.zza(activity0), bundle0);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity0) {
        this.zzb(zzdf.zza(activity0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity0) {
        this.zzc(zzdf.zza(activity0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity0) {
        this.zzd(zzdf.zza(activity0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity0, Bundle bundle0) {
        this.zze(zzdf.zza(activity0), bundle0);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity0) {
    }

    @Override  // com.google.android.gms.measurement.internal.zzkv
    public final void zza(zzdf zzdf0, Bundle bundle0) {
        zzib zzib1;
        Uri uri1;
        try {
            try {
                zzli zzli0 = this.zza;
                zzib zzib0 = zzli0.zzu;
                zzib0.zzaV().zzk().zza("onActivityCreated");
                Intent intent0 = zzdf0.zzc;
                if(intent0 == null) {
                    zzib1 = zzli0.zzu;
                }
                else {
                    Uri uri0 = intent0.getData();
                    if(uri0 == null || !uri0.isHierarchical()) {
                        Bundle bundle1 = intent0.getExtras();
                        uri1 = null;
                        if(bundle1 != null) {
                            String s = bundle1.getString("com.android.vending.referral_url");
                            if(!TextUtils.isEmpty(s)) {
                                uri1 = Uri.parse(s);
                            }
                        }
                    }
                    else {
                        uri1 = uri0;
                    }
                    if(uri1 == null || !uri1.isHierarchical()) {
                        zzib1 = zzli0.zzu;
                    }
                    else {
                        zzib0.zzk();
                        String s1 = intent0.getStringExtra("android.intent.extra.REFERRER_NAME");
                        String s2 = uri1.getQueryParameter("referrer");
                        zzib0.zzaW().zzj(new zzkw(this, bundle0 == null, uri1, ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(s1) || "https://www.google.com".equals(s1) || "android-app://com.google.appcrawler".equals(s1) ? "gs" : "auto"), s2));
                        zzib1 = this.zza.zzu;
                    }
                }
                goto label_33;
            }
            catch(RuntimeException runtimeException0) {
            }
            this.zza.zzu.zzaV().zzb().zzb("Throwable caught in onActivityCreated", runtimeException0);
        }
        catch(Throwable throwable0) {
            this.zza.zzu.zzs().zzm(zzdf0, bundle0);
            throw throwable0;
        }
        zzib1 = this.zza.zzu;
    label_33:
        zzib1.zzs().zzm(zzdf0, bundle0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzkv
    public final void zzb(zzdf zzdf0) {
        this.zza.zzu.zzs().zzs(zzdf0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzkv
    public final void zzc(zzdf zzdf0) {
        this.zza.zzu.zzs().zzp(zzdf0);
        zzob zzob0 = this.zza.zzu.zzh();
        long v = zzob0.zzu.zzaZ().elapsedRealtime();
        zzob0.zzu.zzaW().zzj(new zznu(zzob0, v));
    }

    @Override  // com.google.android.gms.measurement.internal.zzkv
    public final void zzd(zzdf zzdf0) {
        zzob zzob0 = this.zza.zzu.zzh();
        long v = zzob0.zzu.zzaZ().elapsedRealtime();
        zzob0.zzu.zzaW().zzj(new zznt(zzob0, v));
        this.zza.zzu.zzs().zzn(zzdf0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzkv
    public final void zze(zzdf zzdf0, Bundle bundle0) {
        this.zza.zzu.zzs().zzq(zzdf0, bundle0);
    }
}

