package Ac;

import com.melon.net.res.v3.CommentConfig;
import com.melon.net.res.v3.CommentUiModel;
import ie.H;
import w0.h;
import we.a;
import we.k;

public final class b1 implements a {
    public final int a;
    public final h b;
    public final k c;
    public final CommentConfig d;
    public final CommentUiModel e;

    public b1(h h0, k k0, CommentConfig commentConfig0, CommentUiModel commentUiModel0, int v) {
        this.a = v;
        this.b = h0;
        this.c = k0;
        this.d = commentConfig0;
        this.e = commentUiModel0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                h.a(this.b);
                P1 p10 = new P1(this.d, this.e);
                this.c.invoke(p10);
                return H.a;
            }
            case 1: {
                h.a(this.b);
                N1 n10 = new N1(this.d, this.e);
                this.c.invoke(n10);
                return H.a;
            }
            default: {
                h.a(this.b);
                L1 l10 = new L1(this.d, this.e);
                this.c.invoke(l10);
                return H.a;
            }
        }
    }
}

