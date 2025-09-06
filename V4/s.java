package V4;

import U4.F;
import U4.a;
import U4.w;
import Vc.B;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.os.Trace;
import androidx.room.O;
import androidx.room.X;
import androidx.room.l;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import b5.j;
import e5.c;
import e5.e;
import e5.g;
import e5.k;
import ie.m;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

public final class s extends F {
    public final Context h;
    public final a i;
    public final WorkDatabase j;
    public final f5.a k;
    public final List l;
    public final f m;
    public final g n;
    public boolean o;
    public BroadcastReceiver.PendingResult p;
    public final j q;
    public static s r;
    public static s s;
    public static final Object t;

    static {
        new String("WM-WorkManagerImpl");
        s.r = null;
        s.s = null;
        s.t = new Object();
    }

    public s(Context context0, a a0, f5.a a1, WorkDatabase workDatabase0, List list0, f f0, j j0) {
        this.o = false;
        Context context1 = context0.getApplicationContext();
        if(context1.isDeviceProtectedStorage()) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        w w0 = new w(a0.h);
        synchronized(w.b) {
            if(w.c == null) {
                w.c = w0;
            }
        }
        this.h = context1;
        this.k = a1;
        this.j = workDatabase0;
        this.m = f0;
        this.q = j0;
        this.i = a0;
        this.l = list0;
        q.f(a1.b, "taskExecutor.taskCoroutineDispatcher");
        CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(a1.b);
        this.n = new g(workDatabase0, 1);
        f0.a(new i(a1.a, list0, a0, workDatabase0));
        a1.a(new e(context1, this));
        q.g(coroutineScope0, "<this>");
        if(k.a(context1, a0)) {
            d5.s s0 = workDatabase0.g();
            s0.getClass();
            O o0 = O.c(0, "SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1");
            WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)s0.a;
            B b0 = new B(new com.gaa.sdk.iap.e(1, s0, o0), 10);
            l l0 = workDatabase_Impl0.getInvalidationTracker();
            String[] arr_s = (String[])Arrays.copyOf(new String[]{"workspec"}, 1);
            l0.getClass();
            q.g(arr_s, "tables");
            m m0 = l0.c.g(arr_s);
            q.g(((String[])m0.a), "resolvedTableNames");
            q.g(((int[])m0.b), "tableIds");
            Flow flow0 = FlowKt.flow(new X(l0.c, ((int[])m0.b), ((String[])m0.a), null));
            Cb.g g0 = l0.i == null ? null : new Cb.g(l0.i.h, ((String[])m0.a), 2);
            if(g0 != null) {
                flow0 = FlowKt.merge(new Flow[]{flow0, g0});
            }
            FlowKt.launchIn(FlowKt.onEach(FlowKt.distinctUntilChanged(FlowKt.conflate(FlowKt.retryWhen(new z4.j(FlowKt.conflate(flow0), workDatabase_Impl0, b0), new V4.m(4, null)))), new n(context1, null)), coroutineScope0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        }
    }

    public final U4.B b0(String s) {
        q.f(this.k.a, "workManagerImpl.workTask…ecutor.serialTaskExecutor");
        c c0 = new c(s, this);
        return H0.e.O(this.i.m, "CancelWorkByName_" + s, this.k.a, c0);
    }

    public static s c0(Context context0) {
        s s0;
        Object object0 = s.t;
        synchronized(object0) {
            __monitor_enter(object0);
            s0 = s.r;
            if(s0 == null) {
                goto label_7;
            }
            else {
                __monitor_exit(object0);
            }
            goto label_9;
        }
        __monitor_exit(object0);
        goto label_9;
    label_7:
        s0 = s.s;
        __monitor_exit(object0);
    label_9:
        if(s0 != null) {
            __monitor_exit(object0);
            return s0;
        }
        try {
            context0.getApplicationContext();
            throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
        }
        catch(Throwable throwable0) {
            __monitor_exit(object0);
            throw throwable0;
        }
    }

    public final w1.m d0(String s) {
        q.g(this.j, "<this>");
        q.g(this.k, "executor");
        q.g(s, "name");
        B2.s s1 = new B2.s(s, 3);
        q.f(this.k.a, "executor.serialTaskExecutor");
        G.g g0 = new G.g(29, s1, this.j);
        return e.k.q(new H7.c(this.k.a, "loadStatusFuture", g0, 4));
    }

    public final void e0() {
        synchronized(s.t) {
            this.o = true;
            BroadcastReceiver.PendingResult broadcastReceiver$PendingResult0 = this.p;
            if(broadcastReceiver$PendingResult0 != null) {
                broadcastReceiver$PendingResult0.finish();
                this.p = null;
            }
        }
    }

    public final void f0() {
        Nc.f f0 = new Nc.f(this, 19);
        q.g(this.i.m, "<this>");
        boolean z = u.x();
        try {
            if(z) {
                Trace.beginSection("ReschedulingWork");
            }
            f0.invoke();
        }
        catch(Throwable throwable0) {
            if(z) {
                Trace.endSection();
            }
            throw throwable0;
        }
        if(z) {
            Trace.endSection();
        }
    }
}

