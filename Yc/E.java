package yc;

import androidx.compose.runtime.K0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.l;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.K4;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;
import we.n;
import zc.d;
import zd.m;
import zd.v;

public final class e implements n {
    public final int a;
    public final k b;
    public final Object c;
    public final Object d;

    public e(K0 k00, b0 b00, k k0) {
        this.a = 0;
        super();
        this.c = k00;
        this.d = b00;
        this.b = k0;
    }

    public e(m m0, K4 k40, k k0, int v) {
        this.a = 1;
        super();
        this.c = m0;
        this.d = k40;
        this.b = k0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).getClass();
            v.a(((m)this.c), ((K4)this.d), this.b, ((l)object0), 1);
            return H.a;
        }
        int v = (int)(((Integer)object0));
        q.g(((SongInfoBase)object1), "songInfoBase");
        ((K0)this.c).n(v);
        ((b0)this.d).setValue(d.f);
        k k0 = this.b;
        if(k0 != null) {
            k0.invoke(new yc.n(v, ((SongInfoBase)object1), true));
        }
        return H.a;
    }
}

