package Fd;

import B.a;
import androidx.compose.runtime.l;
import cd.B0;
import cd.R1;
import cd.b2;
import com.iloen.melon.net.v5x.response.FlexibleRes.Chat;
import gd.f8;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.CoroutineContextKt;
import me.g;
import me.i;
import w8.w0;
import we.n;

public final class h implements n {
    public final int a;
    public final boolean b;
    public final Object c;

    public h(Object object0, boolean z, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.b = z;
        super();
    }

    public h(H h0, boolean z) {
        this.a = 2;
        super();
        this.c = h0;
        this.b = z;
    }

    public h(boolean z, Object object0, int v, int v1) {
        this.a = v1;
        this.b = z;
        this.c = object0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                ((D)this.c).p(this.b, ((l)object0), 55);
                return ie.H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                a.d(this.b, ((we.a)this.c), ((l)object0), 1);
                return ie.H.a;
            }
            case 2: {
                return CoroutineContextKt.a(((H)this.c), this.b, ((i)object0), ((g)object1));
            }
            case 3: {
                ((Integer)object1).getClass();
                B0.b(((Chat)this.c), this.b, ((l)object0), 1);
                return ie.H.a;
            }
            case 4: {
                ((Integer)object1).getClass();
                b2.a(this.b, ((R1)this.c), ((l)object0), 1);
                return ie.H.a;
            }
            case 5: {
                ((Integer)object1).getClass();
                e2.a.o(this.b, ((f8)this.c), ((l)object0), 1);
                return ie.H.a;
            }
            default: {
                ((Integer)object1).getClass();
                ((w0)this.c).j(this.b, ((l)object0), 1);
                return ie.H.a;
            }
        }
    }
}

