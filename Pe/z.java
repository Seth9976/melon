package Pe;

import Y3.d;
import e.k;
import e3.b;
import i.n.i.b.a.s.e.M3;
import i.n.i.b.a.s.e.M7;
import i.n.i.b.a.s.e.T4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.q;
import lf.S;
import lf.T;
import lf.Z;

public final class z implements d, T4 {
    public final int a;
    public final List b;

    public z(int v, int v1) {
        this.a = 5;
        super();
        this.b = Collections.singletonList(new byte[]{0, 0, 0, 1, 0x7C, 1, 1, ((byte)v), ((byte)v1), 0, 0, 0});
    }

    public z(ArrayList arrayList0) {
        this.a = 3;
        super();
        this.b = Collections.unmodifiableList(arrayList0);
    }

    public z(List list0, int v) {
        this.a = v;
        this.b = list0;
        super();
    }

    public z(Z z0) {
        this.a = 7;
        q.g(z0, "typeTable");
        super();
        List list0 = z0.c;
        if((z0.b & 1) == 1) {
            int v = z0.d;
            q.f(list0, "getTypeList(...)");
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
            int v1 = 0;
            for(Object object0: list0) {
                if(v1 >= 0) {
                    T t0 = (T)object0;
                    if(v1 >= v) {
                        t0.getClass();
                        S s0 = T.p(t0);
                        s0.d |= 2;
                        s0.f = true;
                        t0 = s0.e();
                        if(!t0.isInitialized()) {
                            throw new M3(10);
                        }
                    }
                    arrayList0.add(t0);
                    ++v1;
                    continue;
                }
                k.O();
                throw null;
            }
            list0 = arrayList0;
        }
        q.f(list0, "run(...)");
        this.b = list0;
    }

    @Override  // i.n.i.b.a.s.e.T4
    public int a() {
        switch(this.a) {
            case 2: {
                return 1;
            }
            case 3: {
                return 1;
            }
            case 4: {
                return 1;
            }
            default: {
                return 1;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.T4
    public int a(long v) {
        switch(this.a) {
            case 2: {
                return v >= 0L ? -1 : 0;
            }
            case 3: {
                return v >= 0L ? -1 : 0;
            }
            case 4: {
                return -1;
            }
            default: {
                return -1;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.T4
    public long a(int v) {
        switch(this.a) {
            case 2: {
                M7.u(v == 0);
                return 0L;
            }
            case 3: {
                M7.u(v == 0);
                return 0L;
            }
            case 4: {
                return 0L;
            }
            default: {
                return 0L;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.T4
    public List b(long v) {
        switch(this.a) {
            case 2: {
                return v < 0L ? Collections.EMPTY_LIST : this.b;
            }
            case 3: {
                return v < 0L ? Collections.EMPTY_LIST : this.b;
            }
            case 4: {
                return this.b;
            }
            default: {
                return this.b;
            }
        }
    }

    public T c(int v) {
        return (T)this.b.get(v);
    }

    @Override  // Y3.d
    public List getCues(long v) {
        return v < 0L ? Collections.EMPTY_LIST : this.b;
    }

    @Override  // Y3.d
    public long getEventTime(int v) {
        b.c(v == 0);
        return 0L;
    }

    @Override  // Y3.d
    public int getEventTimeCount() {
        return 1;
    }

    @Override  // Y3.d
    public int getNextEventTimeIndex(long v) {
        return v >= 0L ? -1 : 0;
    }
}

