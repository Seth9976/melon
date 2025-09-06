package pd;

import Db.i;
import De.I;
import Hb.h;
import Ub.q;
import Xb.j;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.melon.ui.P0;
import d5.w;
import ed.w0;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ob.z;
import p8.e;
import r8.b;

public final class f implements Application.ActivityLifecycleCallbacks {
    public final q a;
    public final z b;
    public final i c;
    public final MutableStateFlow d;

    public f(q q0, z z0) {
        kotlin.jvm.internal.q.g(q0, "playbackManager");
        kotlin.jvm.internal.q.g(z0, "playerUseCase");
        super();
        this.a = q0;
        this.b = z0;
        i i0 = new i("PlaybackUiHelper");
        i0.e(h.b);
        this.c = i0;
        this.d = StateFlowKt.MutableStateFlow(new g(null, null));
    }

    public final void a(d d0, j j0) {
        w0 w00 = new w0(26, d0, j0);
        i i0 = this.c;
        I.x(i0, w00);
        if(d0.shouldSkipEvent(j0)) {
            i.a(i0, null, new e(3), 3);
            return;
        }
        Activity activity0 = d0.getActivity();
        z z0 = this.b;
        if(activity0 instanceof b && ((b)activity0).isLockScreen()) {
            j0.a(d0, z0);
            return;
        }
        j0.b(d0, z0);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity0, Bundle bundle0) {
        kotlin.jvm.internal.q.g(activity0, "activity");
        P0 p00 = new P0(activity0, 8);
        I.M(this.c, p00);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity0) {
        kotlin.jvm.internal.q.g(activity0, "activity");
        P0 p00 = new P0(activity0, 5);
        I.M(this.c, p00);
        d d0 = w.W(activity0);
        if(d0 != null) {
            w.v(d0);
        }
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity0) {
        kotlin.jvm.internal.q.g(activity0, "activity");
        P0 p00 = new P0(activity0, 7);
        I.M(this.c, p00);
        do {
            Object object0 = this.d.getValue();
            ((g)object0).getClass();
            g g0 = new g(null, ((g)object0).b);
        }
        while(!this.d.compareAndSet(object0, g0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity0) {
        kotlin.jvm.internal.q.g(activity0, "activity");
        P0 p00 = new P0(activity0, 6);
        I.M(this.c, p00);
        d d0 = w.W(activity0);
        MutableStateFlow mutableStateFlow0 = this.d;
        j j0 = ((g)mutableStateFlow0.getValue()).b;
        if(d0 != null && j0 != null) {
            this.a(d0, j0);
        }
        do {
            Object object0 = mutableStateFlow0.getValue();
            ((g)object0).getClass();
        }
        while(!mutableStateFlow0.compareAndSet(object0, new g(d0, (d0 == null ? j0 : null))));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity0, Bundle bundle0) {
        kotlin.jvm.internal.q.g(activity0, "activity");
        kotlin.jvm.internal.q.g(bundle0, "outState");
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity0) {
        kotlin.jvm.internal.q.g(activity0, "activity");
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity0) {
        kotlin.jvm.internal.q.g(activity0, "activity");
        d d0 = w.W(activity0);
        if(d0 != null && d0.dismissDialogOnStop()) {
            P0 p00 = new P0(activity0, 4);
            I.x(this.c, p00);
            w.v(d0);
        }
    }
}

