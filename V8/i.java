package v8;

import com.android.volley.VolleyError;
import kotlin.jvm.internal.q;
import va.e;

public final class i {
    public final h a;
    public final v9.i b;
    public final Object c;
    public final VolleyError d;

    public i(h h0, v9.i i0, Object object0, VolleyError volleyError0) {
        this.a = h0;
        this.b = i0;
        this.c = object0;
        this.d = volleyError0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof i)) {
            return false;
        }
        if(this.a != ((i)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((i)object0).b)) {
            return false;
        }
        return q.b(this.c, ((i)object0).c) ? q.b(this.d, ((i)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        VolleyError volleyError0 = this.d;
        if(volleyError0 != null) {
            v1 = volleyError0.hashCode();
        }
        return ((v * 0x1F + v2) * 0x1F + v3) * 0x1F + v1;
    }

    @Override
    public final String toString() {
        return e.b("Resource - ", this.a.name());
    }
}

