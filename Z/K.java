package Z;

import K.f;
import K.g;
import K.h;
import K.i;
import K.n;
import K.o;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import p0.p;

public final class k implements FlowCollector {
    public final int a;
    public final p b;

    public k(p p0, int v) {
        this.a = v;
        this.b = p0;
        super();
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        if(this.a != 0) {
            p p0 = this.b;
            if(((K.k)object0) instanceof h) {
                p0.add(((K.k)object0));
                return H.a;
            }
            if(((K.k)object0) instanceof i) {
                p0.remove(((i)(((K.k)object0))).a);
                return H.a;
            }
            if(((K.k)object0) instanceof f) {
                p0.add(((K.k)object0));
                return H.a;
            }
            if(((K.k)object0) instanceof g) {
                p0.remove(((g)(((K.k)object0))).a);
                return H.a;
            }
            if(((K.k)object0) instanceof o) {
                p0.add(((K.k)object0));
                return H.a;
            }
            if(((K.k)object0) instanceof K.p) {
                p0.remove(((K.p)(((K.k)object0))).a);
                return H.a;
            }
            if(((K.k)object0) instanceof n) {
                p0.remove(((n)(((K.k)object0))).a);
            }
            return H.a;
        }
        p p1 = this.b;
        if(((K.k)object0) instanceof h) {
            p1.add(((K.k)object0));
            return H.a;
        }
        if(((K.k)object0) instanceof i) {
            p1.remove(((i)(((K.k)object0))).a);
            return H.a;
        }
        if(((K.k)object0) instanceof f) {
            p1.add(((K.k)object0));
            return H.a;
        }
        if(((K.k)object0) instanceof g) {
            p1.remove(((g)(((K.k)object0))).a);
            return H.a;
        }
        if(((K.k)object0) instanceof o) {
            p1.add(((K.k)object0));
            return H.a;
        }
        if(((K.k)object0) instanceof K.p) {
            p1.remove(((K.p)(((K.k)object0))).a);
            return H.a;
        }
        if(((K.k)object0) instanceof n) {
            p1.remove(((n)(((K.k)object0))).a);
        }
        return H.a;
    }
}

