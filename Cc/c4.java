package Cc;

import H0.e;
import Q.K;
import androidx.compose.runtime.l;
import com.melon.net.res.VoiceAlarm.Track;
import ie.H;
import r0.q;
import we.n;

public final class c4 implements n {
    public final int a;
    public final q b;
    public final long c;
    public final long d;
    public final Object e;

    public c4(q q0, Object object0, long v, long v1, int v2, int v3) {
        this.a = v3;
        this.b = q0;
        this.e = object0;
        this.c = v;
        this.d = v1;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).getClass();
            e.c(this.b, ((K)this.e), this.c, this.d, ((l)object0), 1);
            return H.a;
        }
        ((Integer)object1).getClass();
        d4.c(this.b, ((Track)this.e), this.c, this.d, ((l)object0), 7);
        return H.a;
    }
}

