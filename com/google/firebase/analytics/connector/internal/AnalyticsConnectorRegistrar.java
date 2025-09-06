package com.google.firebase.analytics.connector.internal;

import R6.d;
import Y6.b;
import Y6.c;
import Y6.k;
import Y6.m;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.e;
import java.util.Arrays;
import java.util.List;
import x1.a;

@Keep
@KeepForSdk
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Override  // com.google.firebase.components.ComponentRegistrar
    @SuppressLint({"MissingPermission"})
    @Keep
    @KeepForSdk
    public List getComponents() {
        b b0 = c.b(V6.b.class);
        b0.a(k.b(e.class));
        b0.a(k.b(Context.class));
        b0.a(k.b(v7.c.class));
        b0.g = d.b;
        b0.c(2);
        return Arrays.asList(new c[]{b0.b(), a.q("fire-analytics", "22.5.0")});
    }

    private static V6.b lambda$getComponents$0(Y6.d d0) {
        e e0 = (e)d0.get(e.class);
        Context context0 = (Context)d0.get(Context.class);
        v7.c c0 = (v7.c)d0.get(v7.c.class);
        Preconditions.checkNotNull(e0);
        Preconditions.checkNotNull(context0);
        Preconditions.checkNotNull(c0);
        Preconditions.checkNotNull(context0.getApplicationContext());
        if(V6.c.c == null) {
            synchronized(V6.c.class) {
                if(V6.c.c == null) {
                    Bundle bundle0 = new Bundle(1);
                    e0.a();
                    if("[DEFAULT]".equals(e0.b)) {
                        ((m)c0).a((V6.d this) -> runnable0.run(), R6.c.b);
                        bundle0.putBoolean("dataCollectionDefaultEnabled", e0.h());
                    }
                    V6.c.c = new V6.c(zzfb.zza(context0, bundle0).zzb());
                }
            }
        }
        return V6.c.c;
    }

    public static V6.b zza(Y6.d d0) {
        return AnalyticsConnectorRegistrar.lambda$getComponents$0(d0);
    }
}

