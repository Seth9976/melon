package Fd;

import A0.c;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.jvm.internal.q;
import p8.g;
import w0.h;
import we.a;

public final class t implements a {
    public final int a;
    public final h b;
    public final D c;
    public final Z d;
    public final String e;
    public final int f;

    public t(h h0, D d0, Z z0, int v, String s) {
        this.a = 0;
        super();
        this.b = h0;
        this.c = d0;
        this.d = z0;
        this.f = v;
        this.e = s;
    }

    public t(h h0, D d0, Z z0, String s, int v) {
        this.a = 1;
        super();
        this.b = h0;
        this.c = d0;
        this.d = z0;
        this.e = s;
        this.f = v;
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            D d0 = this.c;
            c c0 = ((Y)d0.getViewModel()).c;
            String s = this.e;
            q.g(s, "keyword");
            int v = this.f;
            if(this.d == Z.a) {
                c0.getClass();
                g g0 = c0.z();
                g0.a = "";
                g0.d = ActionKind.Search;
                g0.y = "";
                g0.z = "";
                g0.c(v + 1);
                g0.X = s;
                g0.Y = "autofill";
                g0.a().track();
            }
            else {
                c0.getClass();
                g g1 = c0.z();
                g1.a = "";
                g1.d = ActionKind.Search;
                g1.y = "";
                g1.z = "";
                g1.c(v + 1);
                g1.Y = "autofill";
                g1.a().track();
            }
            d0.sendUserEvent(new M(s));
            return H.a;
        }
        h.a(this.b);
        D d1 = this.c;
        Y y0 = (Y)d1.getViewModel();
        String s1 = y0.k;
        c c1 = y0.c;
        int v1 = this.f;
        if(this.d == Z.a) {
            c1.getClass();
            q.g(s1, "keyword");
            g g2 = c1.z();
            g2.a = "";
            g2.d = ActionKind.Search;
            g2.y = "";
            g2.z = "";
            g2.c(v1 + 1);
            g2.X = s1;
            g2.Y = "suggest";
            g2.a().track();
        }
        else {
            c1.getClass();
            q.g(s1, "keyword");
            g g3 = c1.z();
            g3.a = "";
            g3.d = ActionKind.Search;
            g3.y = "";
            g3.z = "";
            g3.c(v1 + 1);
            g3.X = s1;
            g3.Y = "suggest";
            g3.a().track();
        }
        d1.sendUserEvent(new M(this.e));
        d1.sendUserEvent(new L(this.e, false));
        return H.a;
    }
}

