package I;

import J0.L;
import J0.v;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import ne.a;
import oe.h;
import oe.i;
import we.k;
import we.n;
import we.o;
import x0.b;

public final class o1 extends h implements n {
    public Object B;
    public final CoroutineScope D;
    public final i E;
    public final r G;
    public final z0 I;
    public Job r;
    public int w;

    public o1(CoroutineScope coroutineScope0, o o0, k k0, z0 z00, Continuation continuation0) {
        this.D = coroutineScope0;
        this.E = (i)o0;
        this.G = (r)k0;
        this.I = z00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new o1(this.D, ((o)this.E), ((k)this.G), this.I, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o1)this.create(((L)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Job job1;
        L l1;
        Job job0;
        a a0 = a.a;
        CoroutineScope coroutineScope0 = this.D;
        z0 z00 = this.I;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                L l0 = (L)this.B;
                n1 n10 = new n1(z00, null);
                job0 = BuildersKt__Builders_commonKt.launch$default(this.D, null, CoroutineStart.UNDISPATCHED, n10, 1, null);
                this.B = l0;
                this.r = job0;
                this.w = 1;
                Object object1 = G1.c(l0, this, 3);
                if(object1 == a0) {
                    return a0;
                }
                l1 = l0;
                object0 = object1;
                goto label_20;
            }
            case 1: {
                job0 = this.r;
                l1 = (L)this.B;
                d5.n.D(object0);
            label_20:
                ((v)object0).a();
                i i0 = this.E;
                if(i0 != G1.a) {
                    G1.e(coroutineScope0, job0, new k1(((o)i0), z00, ((v)object0), null));
                }
                this.B = job0;
                this.r = null;
                this.w = 2;
                object0 = G1.g(l1, J0.o.b, this);
                if(object0 == a0) {
                    return a0;
                }
                job1 = job0;
                break;
            }
            case 2: {
                job1 = (Job)this.B;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((v)object0) == null) {
            G1.e(coroutineScope0, job1, new l1(z00, null));
            return H.a;
        }
        ((v)object0).a();
        G1.e(coroutineScope0, job1, new m1(z00, null));
        b b0 = new b(((v)object0).c);
        ((k)this.G).invoke(b0);
        return H.a;
    }
}

