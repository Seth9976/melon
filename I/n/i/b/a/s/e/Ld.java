package i.n.i.b.a.s.e;

import android.net.Uri;
import com.iloen.melon.fragments.radio.a;
import g3.h;
import java.io.IOException;
import jeb.synthetic.FIN;

public final class ld implements gb {
    public final long a;
    public final W2 b;
    public final int c;
    public final ye d;
    public final kd e;
    public volatile Object f;
    public W2 g;
    public String h;
    public a i;

    public ld(D0 d00, W2 w20, int v, kd kd0) {
        this.d = new ye(d00);
        this.b = w20;
        this.c = v;
        this.e = kd0;
        this.a = Sd.g.getAndIncrement();
        this.g = w20;
        this.h = null;
    }

    public final void a(W2 w20) {
        if(this.h == null) {
            String s = w20.b.getHost();
            Uri uri0 = this.d.a.c();
            if(uri0 != null) {
                s = uri0.getHost();
            }
            this.h = M7.y(s);
        }
    }

    @Override  // i.n.i.b.a.s.e.gb
    public final void b() {
    }

    @Override  // i.n.i.b.a.s.e.gb
    public final void g() {
        this.h = null;
        W2 w20 = this.b;
        a a0 = this.i;
        if(a0 != null) {
            Object object0 = a0.b;
            switch(a0.a) {
                case 12: {
                    w20 = M7.d(((z0)object0).I, w20);
                    break;
                }
                case 20: {
                    w20 = M7.d(((W8)object0).h, w20);
                    break;
                }
                case 21: {
                    w20 = M7.d(((V8)object0).k.h, w20);
                    break;
                }
                default: {
                    w20 = M7.d(((jc)object0).N, w20);
                }
            }
        }
        this.g = w20;
        this.d.b = 0L;
        h h0 = new h(this.d, w20);
        int v = FIN.finallyOpen$NT();
        h0.b();
        Uri uri0 = this.d.a.c();
        uri0.getClass();
        this.a(w20);
        this.f = this.e.j(uri0, h0);
        FIN.finallyCodeBegin$NT(v);
        this.a(w20);
        try {
            h0.close();
            FIN.finallyCodeEnd$NT(v);
        }
        catch(IOException unused_ex) {
        }
    }
}

