package i.n.i.b.a.s.e;

import E9.t;
import Nf.p;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.iloen.melon.custom.S0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class u8 {
    public final D0 a;
    public final W2 b;
    public final s8 c;
    public final K2 d;
    public final p e;
    public final Gd f;
    public final S0 g;
    public r8 h;
    public R1 i;
    public sa j;
    public Handler k;
    public final Md l;
    public byte[] m;
    public final t n;
    public static final List o;
    public static final r8 p;

    static {
        u8.o = Collections.unmodifiableList(Arrays.asList(new q8[]{new q8(2), new q8(1), new q8(0)}));
        u8.p = new r8(null, null, 0.0f, false);
    }

    public u8(D0 d00, W2 w20, p p0, Gd gd0, Md md0) {
        this.n = new t(this, 18);
        this.a = d00;
        this.b = w20;
        this.e = p0;
        this.i = null;
        this.c = new s8(this, w20);
        this.g = new S0(this, 26);
        this.d = new K2();
        this.f = gd0;
        this.l = md0;
        this.h = u8.p;
        Sd.g.getAndIncrement();
    }

    public final void a() {
        if(this.j != null && this.j.m()) {
            this.j.f();
        }
        Handler handler0 = this.k;
        if(handler0 != null) {
            handler0.removeCallbacks(this.n);
        }
    }

    public static boolean b(u8 u80) {
        sa sa0 = u80.j;
        if(sa0 != null) {
            try {
                sa0.b();
                return false;
            }
            catch(IOException iOException0) {
                Log.e("Ibis.FormatSniffer", "onLoadError: " + iOException0);
                R1 r10 = u80.i;
                u8 u81 = (u8)r10.b;
                if(u81 != null) {
                    u81.a();
                }
                r10.b = null;
                Vb vb0 = (Vb)((Ga)r10.c).b;
                if(!vb0.W.isEmpty()) {
                    long v = SystemClock.elapsedRealtime();
                    y7 y70 = new y7(100, iOException0);
                    P3 p30 = new P3(vb0, new y2(v, i.a, 0, null, 0L, i.a, 0, null, 0L, 0L), y70);
                    vb0.c.post(p30);
                }
                vb0.i(iOException0);
                Handler handler0 = u80.k;
                if(handler0 != null) {
                    handler0.removeCallbacks(u80.n);
                }
                return true;
            }
        }
        return false;
    }
}

