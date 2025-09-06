package gb;

import Cb.j;
import Na.d;
import Na.e;
import com.iloen.melon.net.v6x.response.BadgeListRes;
import com.iloen.melon.net.v6x.response.TabConfigRes;
import d5.n;
import java.io.Serializable;
import pa.h;

public final class c {
    public final h a;

    public c(h h0) {
        this.a = h0;
    }

    public final Object a(oe.c c0) {
        a a0;
        if(c0 instanceof a) {
            a0 = (a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new a(this, c0);
        }
        Serializable serializable0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(serializable0);
                try {
                    a0.B = 1;
                    serializable0 = this.a.a(a0);
                    if(serializable0 == a1) {
                        return a1;
                    label_18:
                        n.D(serializable0);
                    }
                    return E9.h.H(new e((j.d(((BadgeListRes)serializable0)) ? ((BadgeListRes)serializable0).getResponse() : null)));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return E9.h.H(new d(exception0));
    }

    public final Object b(oe.c c0) {
        b b0;
        if(c0 instanceof b) {
            b0 = (b)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new b(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new b(this, c0);
        }
        Serializable serializable0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(serializable0);
                try {
                    b0.B = 1;
                    serializable0 = this.a.b(b0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        n.D(serializable0);
                    }
                    return E9.h.H(new e((j.d(((TabConfigRes)serializable0)) ? ((TabConfigRes)serializable0).getResponse() : null)));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return E9.h.H(new d(exception0));
    }
}

