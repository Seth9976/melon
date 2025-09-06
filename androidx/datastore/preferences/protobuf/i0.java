package androidx.datastore.preferences.protobuf;

import com.google.protobuf.G2;
import com.google.protobuf.H2;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map.Entry;
import rf.y;

public final class i0 implements Iterator {
    public final int a;
    public int b;
    public boolean c;
    public Iterator d;
    public final AbstractMap e;

    public i0(AbstractMap abstractMap0, int v) {
        this.a = v;
        this.e = abstractMap0;
        this.b = -1;
        super();
    }

    public final Iterator a() {
        switch(this.a) {
            case 0: {
                if(this.d == null) {
                    this.d = ((g0)this.e).b.entrySet().iterator();
                }
                return this.d;
            }
            case 1: {
                if(this.d == null) {
                    this.d = ((G2)this.e).c.entrySet().iterator();
                }
                return this.d;
            }
            default: {
                if(this.d == null) {
                    this.d = ((y)this.e).c.entrySet().iterator();
                }
                return this.d;
            }
        }
    }

    @Override
    public final boolean hasNext() {
        switch(this.a) {
            case 0: {
                int v = this.b + 1;
                g0 g00 = (g0)this.e;
                return v < g00.a.size() || !g00.b.isEmpty() && this.a().hasNext();
            }
            case 1: {
                int v1 = this.b + 1;
                G2 g20 = (G2)this.e;
                return v1 < g20.b || !g20.c.isEmpty() && this.a().hasNext();
            }
            default: {
                return this.b + 1 < ((y)this.e).b.size() || this.a().hasNext();
            }
        }
    }

    @Override
    public final Object next() {
        switch(this.a) {
            case 0: {
                this.c = true;
                int v1 = this.b + 1;
                this.b = v1;
                g0 g00 = (g0)this.e;
                return v1 < g00.a.size() ? ((Map.Entry)g00.a.get(this.b)) : this.a().next();
            }
            case 1: {
                this.c = true;
                int v2 = this.b + 1;
                this.b = v2;
                G2 g20 = (G2)this.e;
                return v2 < g20.b ? ((H2)g20.a[v2]) : this.a().next();
            }
            default: {
                this.c = true;
                int v = this.b + 1;
                this.b = v;
                y y0 = (y)this.e;
                return v < y0.b.size() ? ((Map.Entry)y0.b.get(this.b)) : this.a().next();
            }
        }
    }

    @Override
    public final void remove() {
        AbstractMap abstractMap0 = this.e;
        switch(this.a) {
            case 0: {
                if(!this.c) {
                    throw new IllegalStateException("remove() was called before next()");
                }
                this.c = false;
                ((g0)abstractMap0).b();
                if(this.b < ((g0)abstractMap0).a.size()) {
                    int v1 = this.b;
                    this.b = v1 - 1;
                    ((g0)abstractMap0).h(v1);
                    return;
                }
                this.a().remove();
                return;
            }
            case 1: {
                if(!this.c) {
                    throw new IllegalStateException("remove() was called before next()");
                }
                this.c = false;
                ((G2)abstractMap0).b();
                int v2 = this.b;
                if(v2 < ((G2)abstractMap0).b) {
                    this.b = v2 - 1;
                    ((G2)abstractMap0).i(v2);
                    return;
                }
                this.a().remove();
                return;
            }
            default: {
                if(!this.c) {
                    throw new IllegalStateException("remove() was called before next()");
                }
                this.c = false;
                ((y)abstractMap0).b();
                if(this.b < ((y)abstractMap0).b.size()) {
                    int v = this.b;
                    this.b = v - 1;
                    ((y)abstractMap0).g(v);
                    return;
                }
                this.a().remove();
            }
        }
    }
}

