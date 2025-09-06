package jc;

import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.net.v4x.request.LogReportReq.Type;
import com.iloen.melon.task.ReportService.Reporter;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import d3.g;
import gd.r5;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import je.p;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import ne.a;
import oe.i;
import we.k;

public final class j {
    public static final j a;
    public static final LogU b;
    public static final LinkedBlockingQueue c;
    public static final ArrayList d;
    public static final Semaphore e;
    public static CoroutineScope f;
    public static Job g;

    static {
        j.a = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j.b = Companion.create$default(LogU.Companion, "PlaybackTracker", false, null, 6, null);
        j.c = new LinkedBlockingQueue();
        j.d = new ArrayList();
        j.e = SemaphoreKt.Semaphore$default(5, 0, 2, null);
        g.Q(new r5(11));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new c(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    public static final Object a(CoroutineScope coroutineScope0, i i0) {
        ArrayList arrayList0 = j.d;
        arrayList0.size();
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            d d0 = (d)object0;
            int v = 0;
            for(Object object1: arrayList1) {
                v += ((d)object1).toString().length();
            }
            if(d0.toString().length() + v < 2000) {
                arrayList1.add(d0);
            }
        }
        arrayList0.removeAll(p.T0(arrayList1));
        e e0 = new e(arrayList1, null);
        Object object2 = j.a.d(coroutineScope0, e0, i0);
        return object2 == a.a ? object2 : H.a;
    }

    public static final void b(List list0) {
        Reporter reportService$Reporter0 = Reporter.createReporter(Type.PTRACE, LogLevel.INFO);
        reportService$Reporter0.setMessage(p.q0(list0, "\n", null, null, null, 62));
        reportService$Reporter0.report();
    }

    public static void c(String s) {
        q.g(s, "message");
        DevLog.Companion.get("Playback Procedure").put(s);
        if(!((m)n.b.getValue()).b) {
            return;
        }
        d d0 = new d(s);
        j.c.add(d0);
    }

    public final Object d(CoroutineScope coroutineScope0, k k0, oe.c c0) {
        Semaphore semaphore2;
        Throwable throwable1;
        Semaphore semaphore1;
        k k1;
        int v1;
        f f0;
        if(c0 instanceof f) {
            f0 = (f)c0;
            int v = f0.I;
            if((v & 0x80000000) == 0) {
                f0 = new f(this, c0);
            }
            else {
                f0.I = v ^ 0x80000000;
            }
        }
        else {
            f0 = new f(this, c0);
        }
        Object object0 = f0.E;
        a a0 = a.a;
        switch(f0.I) {
            case 0: {
                d5.n.D(object0);
                f0.r = coroutineScope0;
                f0.w = (i)k0;
                Semaphore semaphore0 = j.e;
                f0.B = semaphore0;
                v1 = 0;
                f0.D = 0;
                f0.I = 1;
                if(semaphore0.acquire(f0) != a0) {
                    k1 = k0;
                    semaphore1 = semaphore0;
                    goto label_34;
                }
                return a0;
            }
            case 1: {
                int v2 = f0.D;
                semaphore1 = f0.B;
                k k2 = (k)f0.w;
                CoroutineScope coroutineScope1 = f0.r;
                d5.n.D(object0);
                k1 = k2;
                v1 = v2;
                coroutineScope0 = coroutineScope1;
                try {
                label_34:
                    CoroutineScopeKt.ensureActive(coroutineScope0);
                    f0.r = null;
                    f0.w = null;
                    f0.B = semaphore1;
                    f0.D = v1;
                    f0.I = 2;
                    if(k1.invoke(f0) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    semaphore2 = semaphore1;
                    goto label_53;
                }
                semaphore2 = semaphore1;
                break;
            }
            case 2: {
                try {
                    semaphore2 = f0.B;
                    d5.n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
                try {
                label_53:
                    d5.n.t(throwable1);
                    break;
                }
                catch(Throwable throwable2) {
                    semaphore2.release();
                    throw throwable2;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        semaphore2.release();
        return H.a;
    }
}

