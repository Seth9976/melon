package i.n.i.b.a.s.e;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class a {
    public String a;
    public Uri b;
    public Map c;
    public Map d;
    public List e;
    public List f;
    public List g;
    public M h;
    public long i;
    public long j;
    public long k;
    public float l;
    public float m;

    public final e a() {
        d d0 = this.b == null ? null : new d(this.b, this.c, null, null, this.f, this.g);
        String s = this.a == null ? "" : this.a;
        b b0 = new b(0x8000000000000000L);
        c c0 = new c(this.i, this.j, this.k, this.l, this.m);
        M m0 = this.h;
        return m0 == null ? new e(s, b0, d0, c0, M.e) : new e(s, b0, d0, c0, m0);
    }

    public final void b(List list0) {
        this.f = list0.isEmpty() ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(list0));
    }
}

