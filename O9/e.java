package O9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import jd.x2;
import je.p;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import we.k;

public final class e {
    public final k a;
    public final k b;
    public final String c;
    public Job d;
    public final ConcurrentLinkedQueue e;
    public long f;
    public boolean g;

    public e(String s, k k0, k k1) {
        this.a = k0;
        this.b = k1;
        this.c = s;
        this.e = new ConcurrentLinkedQueue();
        this.f = 1000L;
    }

    public final void a(long v, String s, List list0) {
        if(s == null) {
            this.e.addAll(list0);
            List list1 = p.P0(this.e);
            this.e.clear();
            this.a.invoke(list1);
            return;
        }
        ConcurrentLinkedQueue concurrentLinkedQueue0 = this.e;
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            x2 x20 = (x2)object0;
            if(q.b(x20.b, this.c)) {
                this.b.invoke(x20);
            }
            else {
                arrayList0.add(x20);
            }
        }
        concurrentLinkedQueue0.addAll(arrayList0);
        long v1 = this.e.isEmpty() ? v / 2L : v / 2L / ((long)this.e.size());
        this.f = v1 - 6L >= 1L ? v1 - 6L : 1L;
        synchronized(this) {
            if(this.g) {
                return;
            }
            this.g = true;
            Job job0 = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new d(this, null), 3, null);
            job0.invokeOnCompletion(new Mc.q(this, 8));
            this.d = job0;
        }
    }
}

