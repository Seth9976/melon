package Vb;

import U4.F;
import android.net.Uri;
import b3.E;
import b3.G;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class n0 extends i implements n {
    public final E B;
    public int r;
    public final o0 w;

    public n0(o0 o00, E e0, Continuation continuation0) {
        this.w = o00;
        this.B = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        E e0 = this.B;
        o0 o00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Uri uri0 = q0.a(F.E(e0));
                this.r = 1;
                object0 = c.a.a(o00.j, uri0, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((byte[])object0) != null) {
            androidx.media3.common.c c0 = e0.d.a();
            c0.c(((byte[])object0), new Integer(6));
            m0 m00 = new m0(o00, e0, new G(c0), null);
            this.r = 2;
            if(BuildersKt.withContext(o00.y, m00, this) == a0) {
                return a0;
            }
        }
        return H.a;
    }
}

