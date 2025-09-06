package androidx.glance.session;

import E9.h;
import L2.L;
import L2.k;
import L2.q;
import L2.r;
import L2.x;
import U4.i;
import U4.t;
import U4.u;
import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import d5.n;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006\u0012\b\b\u0002\u0010\t\u001A\u00020\b\u0012\b\b\u0002\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\f\u0010\u000E¨\u0006\u000F"}, d2 = {"Landroidx/glance/session/SessionWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "params", "LL2/k;", "sessionManager", "LL2/L;", "timeouts", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineContext", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;LL2/k;LL2/L;Lkotlinx/coroutines/CoroutineDispatcher;)V", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "glance_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SessionWorker extends CoroutineWorker {
    public final WorkerParameters g;
    public final k h;
    public final L i;
    public final CoroutineDispatcher j;
    public final String k;

    public SessionWorker(@NotNull Context context0, @NotNull WorkerParameters workerParameters0) {
        this(context0, workerParameters0, q.a, null, null, 24, null);
    }

    public SessionWorker(@NotNull Context context0, @NotNull WorkerParameters workerParameters0, @NotNull k k0, @NotNull L l0, @NotNull CoroutineDispatcher coroutineDispatcher0) {
        super(context0, workerParameters0);
        this.g = workerParameters0;
        this.h = k0;
        this.i = l0;
        this.j = coroutineDispatcher0;
        i i0 = this.b.b;
        k0.getClass();
        Object object0 = i0.a.get("KEY");
        String s = object0 instanceof String ? ((String)object0) : null;
        if(s == null) {
            throw new IllegalStateException("SessionWorker must be started with a key");
        }
        this.k = s;
    }

    public SessionWorker(Context context0, WorkerParameters workerParameters0, k k0, L l0, CoroutineDispatcher coroutineDispatcher0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            k0 = q.a;
        }
        if((v & 8) != 0) {
            l0 = new L();
        }
        if((v & 16) != 0) {
            coroutineDispatcher0 = Dispatchers.getMain();
        }
        this(context0, workerParameters0, k0, l0, coroutineDispatcher0);
    }

    @Override  // androidx.work.CoroutineWorker
    public final Object c(Continuation continuation0) {
        r r0;
        if(continuation0 instanceof r) {
            r0 = (r)continuation0;
            int v = r0.B;
            if((v & 0x80000000) == 0) {
                r0 = new r(this, ((c)continuation0));
            }
            else {
                r0.B = v ^ 0x80000000;
            }
        }
        else {
            r0 = new r(this, ((c)continuation0));
        }
        Object object0 = r0.r;
        a a0 = a.a;
        switch(r0.B) {
            case 0: {
                n.D(object0);
                x x0 = new x(this, null);
                r0.B = 1;
                object0 = y5.a.Z(this.i.d, x0, r0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((u)object0) == null) {
            LinkedHashMap linkedHashMap0 = new LinkedHashMap();
            linkedHashMap0.put("TIMEOUT_EXIT_REASON", Boolean.TRUE);
            i i0 = new i(linkedHashMap0);
            h.X(i0);
            return new t(i0);
        }
        return (u)object0;
    }

    @Override  // androidx.work.CoroutineWorker
    public final CoroutineDispatcher d() {
        return this.j;
    }
}

