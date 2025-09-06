package com.google.firebase.sessions;

import android.content.Context;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Singleton
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleServiceBinderImpl;", "Landroid/content/Context;", "appContext", "<init>", "(Landroid/content/Context;)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SessionLifecycleServiceBinderImpl {
    public final Context a;

    @Inject
    public SessionLifecycleServiceBinderImpl(@NotNull Context context0) {
        q.g(context0, "appContext");
        super();
        this.a = context0;
    }
}

