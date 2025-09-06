package i.n.i.b.a.s.e;

import d5.e;
import okhttp3.Call.Factory;
import okhttp3.OkHttpClient;

public final class fe implements f8 {
    public final e a;
    public final Factory b;
    public String c;
    public g0 d;

    public fe(OkHttpClient okHttpClient0) {
        this.b = okHttpClient0;
        this.a = new e(11);
    }

    @Override  // i.n.i.b.a.s.e.C0
    public final D0 a() {
        D0 d00 = new ge(this.b, this.c, this.a);
        g0 g00 = this.d;
        if(g00 != null) {
            ((Kb)d00).l(g00);
        }
        return d00;
    }

    @Override  // i.n.i.b.a.s.e.f8
    public final j8 a() {
        j8 j80 = new ge(this.b, this.c, this.a);
        g0 g00 = this.d;
        if(g00 != null) {
            ((Kb)j80).l(g00);
        }
        return j80;
    }
}

