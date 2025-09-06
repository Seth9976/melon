package com.google.firebase.analytics;

import U6.a;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.measurement.internal.zzlj;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.e;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import z7.c;
import z7.d;

public final class FirebaseAnalytics {
    public final zzfb a;
    public static volatile FirebaseAnalytics b;

    public FirebaseAnalytics(zzfb zzfb0) {
        Preconditions.checkNotNull(zzfb0);
        this.a = zzfb0;
    }

    @Keep
    public String getFirebaseInstanceId() {
        try {
            e e0 = e.c();
            Preconditions.checkArgument(true, "Null is not a valid value of FirebaseApp.");
            return (String)Tasks.await(((c)e0.b(d.class)).c(), 30000L, TimeUnit.MILLISECONDS);
        }
        catch(ExecutionException executionException0) {
            throw new IllegalStateException(executionException0.getCause());
        }
        catch(TimeoutException unused_ex) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
        catch(InterruptedException interruptedException0) {
            throw new IllegalStateException(interruptedException0);
        }
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context0) {
        if(FirebaseAnalytics.b == null) {
            Class class0 = FirebaseAnalytics.class;
            synchronized(class0) {
                if(FirebaseAnalytics.b == null) {
                    FirebaseAnalytics.b = new FirebaseAnalytics(zzfb.zza(context0, null));
                }
            }
        }
        return FirebaseAnalytics.b;
    }

    @Keep
    public static zzlj getScionFrontendApiImplementation(Context context0, Bundle bundle0) {
        zzfb zzfb0 = zzfb.zza(context0, bundle0);
        return zzfb0 == null ? null : new a(zzfb0);
    }

    @Keep
    @Deprecated
    public void setCurrentScreen(Activity activity0, String s, String s1) {
        zzdf zzdf0 = zzdf.zza(activity0);
        this.a.zzp(zzdf0, s, s1);
    }
}

