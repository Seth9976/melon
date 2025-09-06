package z4;

import G4.a;
import G4.c;
import e.k;
import java.util.ArrayList;
import java.util.List;
import je.p;
import je.w;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import me.i;

public final class h implements a, Mutex {
    public final a a;
    public final Mutex b;
    public i c;
    public Throwable d;

    public h(a a0) {
        Mutex mutex0 = MutexKt.Mutex$default(false, 1, null);
        q.g(a0, "delegate");
        q.g(mutex0, "lock");
        super();
        this.a = a0;
        this.b = mutex0;
    }

    public final void c(StringBuilder stringBuilder0) {
        List list0;
        if(this.c == null && this.d == null) {
            stringBuilder0.append("\t\tStatus: Free connection");
            stringBuilder0.append('\n');
            return;
        }
        stringBuilder0.append("\t\tStatus: Acquired connection");
        stringBuilder0.append('\n');
        i i0 = this.c;
        if(i0 != null) {
            stringBuilder0.append("\t\tCoroutine: " + i0);
            stringBuilder0.append('\n');
        }
        Throwable throwable0 = this.d;
        if(throwable0 != null) {
            stringBuilder0.append("\t\tAcquired:");
            stringBuilder0.append('\n');
            Tf.h h0 = new Tf.h(e2.a.T(throwable0));
            if(h0.hasNext()) {
                Object object0 = h0.next();
                if(h0.hasNext()) {
                    ArrayList arrayList0 = new ArrayList();
                    arrayList0.add(object0);
                    while(h0.hasNext()) {
                        arrayList0.add(h0.next());
                    }
                    list0 = arrayList0;
                }
                else {
                    list0 = k.z(object0);
                }
            }
            else {
                list0 = w.a;
            }
            for(Object object1: p.f0(1, list0)) {
                stringBuilder0.append("\t\t" + ((String)object1));
                stringBuilder0.append('\n');
            }
        }
    }

    @Override
    public final void close() {
        this.a.close();
    }

    @Override  // kotlinx.coroutines.sync.Mutex
    public final boolean isLocked() {
        return this.b.isLocked();
    }

    @Override  // G4.a
    public final c l0(String s) {
        q.g(s, "sql");
        return this.a.l0(s);
    }

    @Override  // kotlinx.coroutines.sync.Mutex
    public final Object lock(Object object0, Continuation continuation0) {
        return this.b.lock(object0, continuation0);
    }

    @Override
    public final String toString() {
        return this.a.toString();
    }

    @Override  // kotlinx.coroutines.sync.Mutex
    public final boolean tryLock(Object object0) {
        return this.b.tryLock(object0);
    }

    @Override  // kotlinx.coroutines.sync.Mutex
    public final void unlock(Object object0) {
        this.b.unlock(object0);
    }
}

