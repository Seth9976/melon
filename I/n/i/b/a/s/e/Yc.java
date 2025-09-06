package i.n.i.b.a.s.e;

import android.content.Context;
import android.os.Looper;
import androidx.media3.exoplayer.h;

public final class yc {
    public final Context a;
    public final n b;
    public final E4 c;
    public C4 d;
    public me e;
    public Object f;
    public final S1 g;
    public Looper h;
    public final I4 i;
    public final int j;
    public final boolean k;
    public final Xb l;
    public Rd m;
    public final long n;
    public final long o;
    public boolean p;
    public Gd q;
    public Md r;

    public yc(Context context0, n n0) {
        l4 l40;
        k3 k30 = new k3();  // 初始化器: Ljava/lang/Object;-><init>()V
        fi fi0 = new fi(context0);
        new Eb(new jj(context0), k30);
        o5 o50 = new o5();
        synchronized(l4.class) {
            if(l4.G == null) {
                hj.b hj$b0 = new hj.b(context0);
                l4.G = new l4(hj$b0.a, hj$b0.b, hj$b0.c, hj$b0.d, hj$b0.e);
            }
            l40 = l4.G;
        }
        E4 e40 = E4.b;
        S1 s10 = new S1();
        super();
        this.a = context0;
        this.b = n0;
        this.d = fi0;
        this.e = o50;
        this.f = l40;
        this.g = s10;
        Looper looper0 = Looper.myLooper();
        if(looper0 == null) {
            looper0 = Looper.getMainLooper();
        }
        this.h = looper0;
        this.i = I4.b;
        this.j = 1;
        this.k = true;
        this.l = Xb.c;
        this.m = new h(20000L, 500000L);
        this.c = e40;
        this.n = 500L;
        this.o = 2000L;
        this.q = Gd.h0;
        this.r = null;
    }
}

