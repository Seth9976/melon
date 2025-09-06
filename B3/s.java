package b3;

import F4.a;
import I6.V;
import android.net.Uri;
import e3.b;
import java.util.List;
import java.util.UUID;

public final class s {
    public String a;
    public Uri b;
    public String c;
    public t d;
    public a e;
    public List f;
    public String g;
    public V h;
    public r i;
    public long j;
    public G k;
    public x l;
    public B m;

    public final E a() {
        A a1;
        b.j(((Uri)this.e.e) == null || ((UUID)this.e.d) != null);
        Uri uri0 = this.b;
        w w0 = null;
        if(uri0 == null) {
            a1 = null;
        }
        else {
            String s = this.c;
            a a0 = this.e;
            if(((UUID)a0.d) != null) {
                w0 = new w(a0);
            }
            a1 = new A(uri0, s, w0, this.i, this.f, this.g, this.h, this.j);
        }
        String s1 = this.a == null ? "" : this.a;
        t t0 = this.d;
        t0.getClass();
        v v0 = new v(t0);  // 初始化器: Lb3/u;-><init>(Lb3/t;)V
        x x0 = this.l;
        x0.getClass();
        y y0 = new y(x0);
        G g0 = this.k;
        return g0 == null ? new E(s1, v0, a1, y0, G.K, this.m) : new E(s1, v0, a1, y0, g0, this.m);
    }
}

