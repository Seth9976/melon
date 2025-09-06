package hd;

import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v6x.response.MusicDnaMonthListRes;
import com.melon.net.res.MusicDnaMainMonthlyLogRes;
import kotlinx.coroutines.Deferred;
import oe.c;

public final class b1 extends c {
    public m1 B;
    public Deferred D;
    public Deferred E;
    public MusicDnaMainMonthlyLogRes G;
    public MusicDnaMonthListRes I;
    public int M;
    public int N;
    public Object S;
    public final m1 T;
    public int V;
    public L0 r;
    public String w;

    public b1(m1 m10, c c0) {
        this.T = m10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.S = object0;
        this.V |= 0x80000000;
        return this.T.onFetchStart(null, this);
    }
}

