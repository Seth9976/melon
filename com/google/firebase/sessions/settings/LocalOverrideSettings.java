package com.google.firebase.sessions.settings;

import Q7.n;
import Uf.b;
import Uf.d;
import android.content.Context;
import android.os.Bundle;
import ie.H;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import x1.a;

@Singleton
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/settings/LocalOverrideSettings;", "LQ7/n;", "Landroid/content/Context;", "appContext", "<init>", "(Landroid/content/Context;)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class LocalOverrideSettings implements n {
    public final Bundle a;

    @Inject
    public LocalOverrideSettings(@NotNull Context context0) {
        q.g(context0, "appContext");
        super();
        Bundle bundle0 = context0.getPackageManager().getApplicationInfo("com.iloen.melon", 0x80).metaData;
        if(bundle0 == null) {
            bundle0 = Bundle.EMPTY;
        }
        this.a = bundle0;
    }

    // 去混淆评级： 低(20)
    @Override  // Q7.n
    public final Boolean a() {
        return this.a.containsKey("firebase_sessions_enabled") ? Boolean.valueOf(this.a.getBoolean("firebase_sessions_enabled")) : null;
    }

    // 去混淆评级： 低(20)
    @Override  // Q7.n
    public final b b() {
        return this.a.containsKey("firebase_sessions_sessions_restart_timeout") ? new b(a.P(this.a.getInt("firebase_sessions_sessions_restart_timeout"), d.d)) : null;
    }

    // 去混淆评级： 低(20)
    @Override  // Q7.n
    public final Double c() {
        return this.a.containsKey("firebase_sessions_sampling_rate") ? this.a.getDouble("firebase_sessions_sampling_rate") : null;
    }

    @Override  // Q7.n
    public final Object d(Continuation continuation0) {
        return H.a;
    }
}

