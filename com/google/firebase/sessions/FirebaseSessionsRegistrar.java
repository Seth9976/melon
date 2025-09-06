package com.google.firebase.sessions;

import B3.n;
import M7.M;
import M7.V;
import M7.i;
import M7.m;
import M7.p;
import M7.t;
import M7.x;
import M7.y;
import N5.g;
import X6.a;
import X6.b;
import Y6.c;
import Y6.k;
import Y6.s;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.e;
import java.util.List;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import z7.d;

@Keep
@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0001\u0018\u0000 \n2\u00020\u0001:\u0001\u000BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\b\u001A0\u0012,\u0012*\u0012\u000E\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000E\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "<init>", "()V", "", "LY6/c;", "", "kotlin.jvm.PlatformType", "getComponents", "()Ljava/util/List;", "Companion", "M7/x", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {
    @NotNull
    private static final x Companion = null;
    @Deprecated
    @NotNull
    public static final String LIBRARY_NAME = "fire-sessions";
    @Deprecated
    @NotNull
    public static final String TAG = "FirebaseSessions";
    @NotNull
    private static final s appContext;
    @NotNull
    private static final s backgroundDispatcher;
    @NotNull
    private static final s blockingDispatcher;
    @NotNull
    private static final s firebaseApp;
    @NotNull
    private static final s firebaseInstallationsApi;
    @NotNull
    private static final s firebaseSessionsComponent;
    @NotNull
    private static final s transportFactory;

    static {
        FirebaseSessionsRegistrar.Companion = new x();  // 初始化器: Ljava/lang/Object;-><init>()V
        FirebaseSessionsRegistrar.appContext = s.a(Context.class);
        FirebaseSessionsRegistrar.firebaseApp = s.a(e.class);
        FirebaseSessionsRegistrar.firebaseInstallationsApi = s.a(d.class);
        FirebaseSessionsRegistrar.backgroundDispatcher = new s(a.class, CoroutineDispatcher.class);
        FirebaseSessionsRegistrar.blockingDispatcher = new s(b.class, CoroutineDispatcher.class);
        FirebaseSessionsRegistrar.transportFactory = s.a(g.class);
        FirebaseSessionsRegistrar.firebaseSessionsComponent = s.a(M7.s.class);
    }

    public static final s access$getAppContext$cp() {
        return FirebaseSessionsRegistrar.appContext;
    }

    public static final s access$getBackgroundDispatcher$cp() {
        return FirebaseSessionsRegistrar.backgroundDispatcher;
    }

    public static final s access$getBlockingDispatcher$cp() {
        return FirebaseSessionsRegistrar.blockingDispatcher;
    }

    public static final s access$getFirebaseApp$cp() {
        return FirebaseSessionsRegistrar.firebaseApp;
    }

    public static final s access$getFirebaseInstallationsApi$cp() {
        return FirebaseSessionsRegistrar.firebaseInstallationsApi;
    }

    public static final s access$getFirebaseSessionsComponent$cp() {
        return FirebaseSessionsRegistrar.firebaseSessionsComponent;
    }

    public static final s access$getTransportFactory$cp() {
        return FirebaseSessionsRegistrar.transportFactory;
    }

    @Override  // com.google.firebase.components.ComponentRegistrar
    @NotNull
    public List getComponents() {
        Y6.b b0 = c.b(p.class);
        b0.a = "fire-sessions";
        b0.a(k.a(FirebaseSessionsRegistrar.firebaseSessionsComponent));
        b0.g = new n(18);
        b0.c(2);
        c c0 = b0.b();
        Y6.b b1 = c.b(M7.s.class);
        b1.a = "fire-sessions-component";
        b1.a(k.a(FirebaseSessionsRegistrar.appContext));
        b1.a(k.a(FirebaseSessionsRegistrar.backgroundDispatcher));
        b1.a(k.a(FirebaseSessionsRegistrar.blockingDispatcher));
        b1.a(k.a(FirebaseSessionsRegistrar.firebaseApp));
        b1.a(k.a(FirebaseSessionsRegistrar.firebaseInstallationsApi));
        b1.a(new k(FirebaseSessionsRegistrar.transportFactory, 1, 1));
        b1.g = new n(19);
        return e.k.A(new c[]{c0, b1.b(), x1.a.q("fire-sessions", "2.1.2")});
    }

    private static final p getComponents$lambda$0(Y6.d d0) {
        return (p)((i)(((M7.s)d0.d(FirebaseSessionsRegistrar.firebaseSessionsComponent)))).m.get();
    }

    private static final M7.s getComponents$lambda$1(Y6.d d0) {
        Object object0 = d0.d(FirebaseSessionsRegistrar.appContext);
        q.f(object0, "container[appContext]");
        Object object1 = d0.d(FirebaseSessionsRegistrar.backgroundDispatcher);
        q.f(object1, "container[backgroundDispatcher]");
        Object object2 = d0.d(FirebaseSessionsRegistrar.blockingDispatcher);
        q.f(object2, "container[blockingDispatcher]");
        me.i i0 = (me.i)object2;
        Object object3 = d0.d(FirebaseSessionsRegistrar.firebaseApp);
        q.f(object3, "container[firebaseApp]");
        Object object4 = d0.d(FirebaseSessionsRegistrar.firebaseInstallationsApi);
        q.f(object4, "container[firebaseInstallationsApi]");
        y7.b b0 = d0.c(FirebaseSessionsRegistrar.transportFactory);
        q.f(b0, "container.getProvider(transportFactory)");
        M7.s s0 = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
        s0.a = P7.c.a(((e)object3));
        P7.c c0 = P7.c.a(((Context)object0));
        s0.b = c0;
        s0.c = P7.a.a(new m(c0, 5));
        s0.d = P7.c.a(((me.i)object1));
        s0.e = P7.c.a(((d)object4));
        Provider provider0 = P7.a.a(new m(s0.a, 1));
        s0.f = provider0;
        s0.g = P7.a.a(new M(provider0, s0.d, 2));
        Provider provider1 = P7.a.a(new m(s0.b, 2));
        s0.h = provider1;
        Provider provider2 = P7.a.a(new m(provider1, 6));
        s0.i = provider2;
        Provider provider3 = P7.a.a(new V(s0.d, s0.e, s0.f, s0.g, provider2));
        s0.j = provider3;
        s0.k = P7.a.a(new M(s0.c, provider3, 3));
        Provider provider4 = P7.a.a(new m(s0.b, 4));
        s0.l = provider4;
        s0.m = P7.a.a(new y(s0.a, s0.k, s0.d, provider4));
        Provider provider5 = P7.a.a(new m(s0.b, 3));
        s0.n = provider5;
        s0.o = P7.a.a(new M(s0.d, provider5, 0));
        Provider provider6 = P7.a.a(new m(P7.c.a(b0), 0));
        s0.p = provider6;
        s0.q = P7.a.a(new V(s0.a, s0.e, s0.k, provider6, s0.d));
        s0.r = P7.a.a(t.a);
        Provider provider7 = P7.a.a(t.b);
        s0.s = provider7;
        s0.t = P7.a.a(new M(s0.r, provider7, 1));
        return s0;
    }
}

