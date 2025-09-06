package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.util.Objects;

final class zzfa implements Application.ActivityLifecycleCallbacks {
    final zzfb zza;

    public zzfa(zzfb zzfb0) {
        Objects.requireNonNull(zzfb0);
        this.zza = zzfb0;
        super();
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity0, Bundle bundle0) {
        zzet zzet0 = new zzet(this, bundle0, activity0);
        this.zza.zzM(zzet0);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity0) {
        zzez zzez0 = new zzez(this, activity0);
        this.zza.zzM(zzez0);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity0) {
        zzew zzew0 = new zzew(this, activity0);
        this.zza.zzM(zzew0);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity0) {
        zzev zzev0 = new zzev(this, activity0);
        this.zza.zzM(zzev0);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity0, Bundle bundle0) {
        zzco zzco0 = new zzco();
        zzey zzey0 = new zzey(this, activity0, zzco0);
        this.zza.zzM(zzey0);
        Bundle bundle1 = zzco0.zze(50L);
        if(bundle1 != null) {
            bundle0.putAll(bundle1);
        }
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity0) {
        zzeu zzeu0 = new zzeu(this, activity0);
        this.zza.zzM(zzeu0);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity0) {
        zzex zzex0 = new zzex(this, activity0);
        this.zza.zzM(zzex0);
    }
}

