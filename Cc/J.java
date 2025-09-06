package Cc;

import G.C;
import G.e;
import G.f;
import G.x0;
import androidx.compose.runtime.M0;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class j extends i implements n {
    public int B;
    public int D;
    public final String E;
    public final e G;
    public final boolean I;
    public final float M;
    public final long N;
    public final boolean S;
    public final b0 T;
    public final M0 V;
    public float r;
    public float w;

    public j(String s, e e0, boolean z, float f, long v, boolean z1, b0 b00, M0 m00, Continuation continuation0) {
        this.E = s;
        this.G = e0;
        this.I = z;
        this.M = f;
        this.N = v;
        this.S = z1;
        this.T = b00;
        this.V = m00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j(this.E, this.G, this.I, this.M, this.N, this.S, this.T, this.V, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        float f1;
        float f;
        int v;
        a a0 = a.a;
        boolean z = this.S;
        b0 b00 = this.T;
        String s = this.E;
        M0 m00 = this.V;
        e e0 = this.G;
    alab1:
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                if(!q.b(s, ((String)b00.getValue()))) {
                    this.D = 1;
                    if(e0.f(this) == a0) {
                        return a0;
                    }
                    goto label_14;
                }
                goto label_22;
            }
            case 1: {
                d5.n.D(object0);
            label_14:
                this.D = 2;
                if(e0.e(new Float(1.0f), this) == a0) {
                    return a0;
                }
                m00.n(0L);
                b00.setValue(s);
                goto label_22;
            }
            case 2: {
                d5.n.D(object0);
                m00.n(0L);
                b00.setValue(s);
            label_22:
                if(this.I) {
                    goto label_34;
                }
                this.D = 5;
                if(e0.f(this) == a0) {
                    return a0;
                }
                goto label_56;
            }
            case 3: {
                v = this.B;
                f = this.w;
                f1 = this.r;
                d5.n.D(object0);
                goto label_47;
            }
            case 4: {
                d5.n.D(object0);
                m00.n(0L);
                while(true) {
                    if(!z) {
                        break alab1;
                    }
                label_34:
                    float f2 = ((Number)e0.d()).floatValue();
                    float f3 = (this.M - f2) / (this.M - 1.0f);
                    int v1 = ((int)(((float)this.N) * f3)) >= 0 ? ((int)(((float)this.N) * f3)) : 0;
                    x0 x00 = f.r(v1, 0, C.d, 2);
                    Cc.i i0 = new Cc.i(this.M, this.N, m00);
                    this.r = f2;
                    this.w = f3;
                    this.B = v1;
                    this.D = 3;
                    if(e.c(e0, new Float(this.M), x00, i0, this, 4) == a0) {
                        return a0;
                    }
                    f1 = f2;
                    f = f3;
                    v = v1;
                label_47:
                    if(z) {
                        this.r = f1;
                        this.w = f;
                        this.B = v;
                        this.D = 4;
                        if(e0.e(new Float(1.0f), this) == a0) {
                            return a0;
                        }
                        m00.n(0L);
                    }
                }
            }
            case 5: {
                d5.n.D(object0);
            label_56:
                this.D = 6;
                if(e0.e(new Float(1.0f), this) == a0) {
                    return a0;
                }
                m00.n(0L);
                return H.a;
            }
            case 6: {
                d5.n.D(object0);
                m00.n(0L);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

