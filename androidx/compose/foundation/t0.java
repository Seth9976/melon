package androidx.compose.foundation;

import G.C;
import G.X;
import G.Y;
import G.e;
import G.o;
import G.x0;
import P0.f;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class t0 extends i implements n {
    public Object B;
    public final v0 D;
    public o r;
    public int w;

    public t0(v0 v00, Continuation continuation0) {
        this.D = v00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new t0(this.D, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((t0)this.create(((Float)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Throwable throwable0;
        Float float1;
        o o1;
        v0 v00 = this.D;
        e e0 = v00.l;
        a a0 = a.a;
        H h0 = H.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                float1 = (Float)this.B;
                if(float1 != null) {
                    int v = v00.a;
                    int v1 = v00.c;
                    int v2 = v00.b;
                    float f = v00.d;
                    x0 x00 = new x0(((int)(((float)Math.ceil(((float)float1) / (Math.abs(f.v(v00).S.Y(f)) / 1000.0f))))), v2, C.d);
                    long v3 = (long)(-(v1 - v2));
                    o1 = v == 0x7FFFFFFF ? G.f.n(x00, null, v3, 2) : new Y(v, x00, X.a, v3);
                    this.B = float1;
                    this.r = o1;
                    this.w = 1;
                    if(e0.e(new Float(0.0f), this) == a0) {
                        return a0;
                    }
                    try {
                    label_36:
                        this.B = null;
                        this.r = null;
                        this.w = 2;
                        if(e.c(v00.l, float1, o1, null, this, 12) == a0) {
                            return a0;
                        }
                    }
                    catch(Throwable throwable0) {
                    label_42:
                        this.B = throwable0;
                        this.r = null;
                        this.w = 4;
                        if(e0.e(new Float(0.0f), this) != a0) {
                            throw throwable0;
                        }
                        return a0;
                    }
                label_47:
                    this.w = 3;
                    if(e0.e(new Float(0.0f), this) == a0) {
                        return a0;
                    }
                }
                break;
            }
            case 1: {
                o o0 = this.r;
                Float float0 = (Float)this.B;
                d5.n.D(object0);
                o1 = o0;
                float1 = float0;
                goto label_36;
            }
            case 2: {
                try {
                    d5.n.D(object0);
                    goto label_47;
                }
                catch(Throwable throwable0) {
                    goto label_42;
                }
            }
            case 3: {
                d5.n.D(object0);
                return h0;
            }
            case 4: {
                throwable0 = (Throwable)this.B;
                d5.n.D(object0);
                throw throwable0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }
}

