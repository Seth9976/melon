package com.melon.utils.lifecycle;

import A8.b;
import Pd.a;
import Pd.c;
import Pd.d;
import Pd.e;
import Pd.f;
import Pd.g;
import Pd.h;
import Pd.i;
import Pd.j;
import Pd.k;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.iloen.melon.eventbus.EventActivityState.EventActivityPaused;
import com.iloen.melon.eventbus.EventActivityState.EventActivityResumed;
import com.iloen.melon.eventbus.EventActivityState.EventActivityStarted;
import com.iloen.melon.eventbus.EventActivityState.EventActivityStopped;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import ie.p;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;

@Singleton
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/melon/utils/lifecycle/AppVisibilityManagerImpl;", "LPd/i;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AppVisibilityManagerImpl implements i, Application.ActivityLifecycleCallbacks {
    public final LogU a;
    public final CoroutineScope b;
    public final MutableSharedFlow c;
    public final SharedFlow d;
    public boolean e;
    public boolean f;

    @Inject
    public AppVisibilityManagerImpl(@NotNull Context context0) {
        q.g(context0, "context");
        H h0;
        super();
        this.a = Companion.create$default(LogU.Companion, "AppVisibilityManager", false, null, 6, null);
        this.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        MutableSharedFlow mutableSharedFlow0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.c = mutableSharedFlow0;
        this.d = FlowKt.asSharedFlow(mutableSharedFlow0);
        try {
            ((Application)context0).registerActivityLifecycleCallbacks(this);
            j j0 = new j(this);
            () -> this.f.f.a(j0);
            h0 = H.a;
        }
        catch(Throwable throwable0) {
            h0 = n.t(throwable0);
        }
        Throwable throwable1 = p.a(h0);
        if(throwable1 != null) {
            LogU.error$default(this.a, "Failed to register ActivityLifecycleCallbacks", throwable1, false, 4, null);
            if(!b.d()) {
                throw throwable1;
            }
        }
    }

    public final void a(h h0) {
        k k0 = new k(this, h0, null);
        BuildersKt__Builders_commonKt.launch$default(this.b, null, null, k0, 3, null);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity0, Bundle bundle0) {
        q.g(activity0, "activity");
        String s = Cb.i.o(activity0);
        LogConstantsKt.infoOnlyDebugMode(this.a, "onActivityCreated() activity: " + s + ", " + bundle0);
        this.a(new a(activity0, bundle0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity0) {
        q.g(activity0, "activity");
        String s = "onActivityDestroyed() activity: " + Cb.i.o(activity0);
        LogConstantsKt.infoOnlyDebugMode(this.a, s);
        this.a(new Pd.b(activity0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity0) {
        q.g(activity0, "activity");
        String s = "onActivityPaused() activity: " + Cb.i.o(activity0);
        LogU logU0 = this.a;
        LogConstantsKt.infoOnlyDebugMode(logU0, s);
        LogConstantsKt.debugOnlyDebugMode(logU0, "isForeground: false");
        this.e = false;
        r8.b b0 = activity0 instanceof r8.b ? ((r8.b)activity0) : null;
        if(b0 != null) {
            boolean z = b0.isLockScreen();
            LogConstantsKt.debugOnlyDebugMode(logU0, "isLockScreenForeground: " + z);
            this.f = z;
        }
        this.a(new c(activity0));
        EventBusHelper.post(new EventActivityPaused(activity0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity0) {
        q.g(activity0, "activity");
        String s = "onActivityResumed() activity: " + Cb.i.o(activity0);
        LogU logU0 = this.a;
        LogConstantsKt.infoOnlyDebugMode(logU0, s);
        if(!(activity0 instanceof r8.b) || !((r8.b)activity0).shouldIgnoreForeground()) {
            LogConstantsKt.debugOnlyDebugMode(logU0, "isForeground: true");
            this.e = true;
            LogConstantsKt.debugOnlyDebugMode(logU0, "isLockScreenForeground: false");
            this.f = false;
        }
        this.a(new d(activity0));
        EventBusHelper.post(new EventActivityResumed(activity0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity0, Bundle bundle0) {
        q.g(activity0, "activity");
        q.g(bundle0, "outState");
        String s = Cb.i.o(activity0);
        LogConstantsKt.infoOnlyDebugMode(this.a, "onActivitySaveInstanceState() activity: " + s + ", " + bundle0);
        this.a(new e(activity0, bundle0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity0) {
        q.g(activity0, "activity");
        String s = "onActivityStarted() activity: " + Cb.i.o(activity0);
        LogConstantsKt.infoOnlyDebugMode(this.a, s);
        this.a(new f(activity0));
        EventBusHelper.post(new EventActivityStarted(activity0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity0) {
        q.g(activity0, "activity");
        String s = "onActivityStopped() activity: " + Cb.i.o(activity0);
        LogConstantsKt.infoOnlyDebugMode(this.a, s);
        this.a(new g(activity0));
        EventBusHelper.post(new EventActivityStopped(activity0));
    }
}

