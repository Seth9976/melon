package w8;

import D2.f;
import android.content.Context;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class v0 extends i implements n {
    public final f B;
    public final w0 D;
    public int r;
    public final Context w;

    public v0(Context context0, f f0, w0 w00, Continuation continuation0) {
        this.w = context0;
        this.B = f0;
        this.D = w00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new v0(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((v0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        w0 w00 = this.D;
        f f0 = this.B;
        Context context0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                u0 u00 = new u0(w00, null);
                this.r = 1;
                if(d5.f.Y(context0, f0, u00, this) == a0) {
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
        this.r = 2;
        return w00.g(context0, f0, this) == a0 ? a0 : H.a;
    }
}

