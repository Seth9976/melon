package zc;

import com.melon.net.res.common.SongInfoBase;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;
import we.n;

public final class l implements k {
    public final int a;
    public final n b;
    public final int c;

    public l(int v, int v1, n n0) {
        this.a = v1;
        this.b = n0;
        this.c = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((SongInfoBase)object0), "songInfoBase");
                n n1 = this.b;
                if(n1 != null) {
                    n1.invoke(this.c, ((SongInfoBase)object0));
                }
                return H.a;
            }
            case 1: {
                q.g(((SongInfoBase)object0), "songInfoBase");
                n n2 = this.b;
                if(n2 != null) {
                    n2.invoke(this.c, ((SongInfoBase)object0));
                }
                return H.a;
            }
            default: {
                q.g(((SongInfoBase)object0), "songInfoBase");
                n n0 = this.b;
                if(n0 != null) {
                    n0.invoke(this.c, ((SongInfoBase)object0));
                }
                return H.a;
            }
        }
    }
}

