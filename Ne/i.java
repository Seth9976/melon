package Ne;

import Me.F;
import Sf.r;
import d5.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import je.n;
import je.p;
import je.v;
import kotlin.jvm.internal.q;
import qf.c;

public final class i implements h {
    public final int a;
    public final Object b;

    public i(List list0, int v) {
        this.a = v;
        this.b = list0;
        super();
    }

    public i(c c0) {
        this.a = 2;
        q.g(c0, "fqNameToMatch");
        super();
        this.b = c0;
    }

    public i(h[] arr_h) {
        this.a = 1;
        List list0 = n.z0(arr_h);
        super();
        this.b = list0;
    }

    @Override  // Ne.h
    public final boolean c(c c0) {
        switch(this.a) {
            case 0: {
                return f.I(this, c0);
            }
            case 1: {
                q.g(c0, "fqName");
                for(Object object0: ((Iterable)p.c0(((List)this.b)).b)) {
                    if(((h)object0).c(c0)) {
                        return true;
                    }
                    if(false) {
                        break;
                    }
                }
                return false;
            }
            default: {
                return f.I(this, c0);
            }
        }
    }

    @Override  // Ne.h
    public final b e0(c c0) {
        switch(this.a) {
            case 0: {
                return f.w(this, c0);
            }
            case 1: {
                q.g(c0, "fqName");
                return (b)Sf.n.i0(Sf.n.o0(p.c0(((List)this.b)), new F(c0, 1)));
            }
            default: {
                q.g(c0, "fqName");
                return c0.equals(((c)this.b)) ? hf.b.a : null;
            }
        }
    }

    @Override  // Ne.h
    public final boolean isEmpty() {
        switch(this.a) {
            case 0: {
                return ((List)this.b).isEmpty();
            }
            case 1: {
                Iterable iterable0 = (List)this.b;
                if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                    for(Object object0: iterable0) {
                        if(!((h)object0).isEmpty()) {
                            return false;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
                return true;
            }
            default: {
                return false;
            }
        }
    }

    @Override
    public final Iterator iterator() {
        switch(this.a) {
            case 0: {
                return ((List)this.b).iterator();
            }
            case 1: {
                return new Sf.f(new Sf.h(p.c0(((List)this.b)), k.a, r.b));
            }
            default: {
                return v.a;
            }
        }
    }

    @Override
    public String toString() {
        return this.a == 0 ? ((List)this.b).toString() : super.toString();
    }
}

