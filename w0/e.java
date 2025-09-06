package W0;

import X0.j;
import X0.k;
import X0.s;
import ie.H;
import k8.Y;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;
import x0.b;

public final class e extends i implements n {
    public float B;
    public final f D;
    public boolean r;
    public int w;

    public e(f f0, Continuation continuation0) {
        this.D = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new e(this.D, continuation0);
        continuation1.B = ((Number)object0).floatValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((Number)object0).floatValue(), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z1;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                float f = this.B;
                f f1 = this.D;
                Object object1 = f1.a.d.a.g(k.e);
                if(object1 == null) {
                    object1 = null;
                }
                if(((n)object1) == null) {
                    throw Y.d("Required value was null.");
                }
                boolean z = ((j)f1.a.d.d(s.t)).c;
                if(z) {
                    f = -f;
                }
                b b0 = new b(((long)Float.floatToRawIntBits(f)) & 0xFFFFFFFFL);
                this.r = z;
                this.w = 1;
                object0 = ((n)object1).invoke(b0, this);
                if(object0 == a0) {
                    return a0;
                }
                z1 = z;
                break;
            }
            case 1: {
                z1 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v = ((b)object0).a;
        return z1 ? new Float(-Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)))) : new Float(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))));
    }
}

