package Nf;

import De.w;
import androidx.media3.session.N;
import androidx.recyclerview.widget.p0;
import b3.I;
import g3.g;
import g3.q;
import g3.t;
import i.n.i.b.a.s.e.Ca;
import i.n.i.b.a.s.e.H4;
import i.n.i.b.a.s.e.e8;
import i.n.i.b.a.s.e.i8;
import i.n.i.b.a.s.e.lb;
import java.io.FileNotFoundException;
import java.io.IOException;
import w3.j;
import ze.b;

public class p implements b {
    public int a;

    public p(int v) {
        this.a = v;
        super();
    }

    public int a(int v) {
        int v1 = this.a;
        if(v1 == -1) {
            return v == 7 ? 6 : 3;
        }
        return v1;
    }

    public static long b(Ca ca0) {
        IOException iOException0 = ca0.a;
        if(iOException0 instanceof i8) {
            switch(((i8)iOException0).b) {
                case 403: 
                case 404: 
                case 410: 
                case 0x1A0: 
                case 500: 
                case 503: {
                    return 60000L;
                }
                default: {
                    return 0x8000000000000001L;
                }
            }
        }
        return 0x8000000000000001L;
    }

    // 去混淆评级： 低(40)
    public long c(Ca ca0) {
        return ca0.a instanceof H4 || ca0.a instanceof FileNotFoundException || ca0.a instanceof e8 || ca0.a instanceof lb ? 0x8000000000000001L : ((long)Math.min((ca0.b - 1) * 1000, 5000));
    }

    public static N d(p0 p00, Ca ca0) {
        IOException iOException0 = ca0.a;
        if(iOException0 instanceof t) {
            switch(((t)iOException0).d) {
                case 403: 
                case 404: 
                case 410: 
                case 0x1A0: 
                case 500: 
                case 503: {
                    return p00.a - p00.b <= 1 ? null : new N(2, 60000L);
                }
                default: {
                    return null;
                }
            }
        }
        return null;
    }

    public int e(int v) {
        int v1 = this.a;
        if(v1 == -1) {
            return v == 7 ? 6 : 3;
        }
        return v1;
    }

    public static long f(Ca ca0) {
        Throwable throwable0 = ca0.a;
        if(!(throwable0 instanceof I) && !(throwable0 instanceof FileNotFoundException) && !(throwable0 instanceof q) && !(throwable0 instanceof j)) {
            while(throwable0 != null) {
                if(throwable0 instanceof g && ((g)throwable0).a == 2008) {
                    return 0x8000000000000001L;
                }
                throwable0 = throwable0.getCause();
            }
            return (long)Math.min((ca0.b - 1) * 1000, 5000);
        }
        return 0x8000000000000001L;
    }

    @Override  // ze.b
    public Object getValue(Object object0, w w0) {
        kotlin.jvm.internal.q.g(((d)object0), "thisRef");
        kotlin.jvm.internal.q.g(w0, "property");
        return ((d)object0).a.get(this.a);
    }
}

