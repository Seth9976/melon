package va;

import com.iloen.melon.utils.log.DevLog;
import com.kakao.sdk.auth.model.OAuthToken;
import ie.p;
import kotlinx.coroutines.sync.Mutex;
import ne.a;
import oe.c;

public final class i extends c {
    public DevLog B;
    public Object D;
    public OAuthToken E;
    public int G;
    public int I;
    public int M;
    public int N;
    public int S;
    public long T;
    public Object V;
    public final n W;
    public int X;
    public Mutex r;
    public String w;

    public i(n n0, c c0) {
        this.W = n0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.V = object0;
        this.X |= 0x80000000;
        Object object1 = this.W.e(null, this);
        return object1 == a.a ? object1 : new p(object1);
    }
}

