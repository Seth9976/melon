package androidx.compose.foundation;

import I.v0;
import I.z0;
import K.l;
import K.m;
import K.o;
import K.p;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import ne.a;
import oe.i;
import we.n;

public final class d extends i implements n {
    public Object B;
    public final v0 D;
    public final long E;
    public final l G;
    public final j I;
    public boolean r;
    public int w;

    public d(v0 v00, long v, l l0, j j0, Continuation continuation0) {
        this.D = v00;
        this.E = v;
        this.G = l0;
        this.I = j0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new d(this.D, this.E, this.G, this.I, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        p p0;
        boolean z;
        Object object1;
        Job job0;
        a a0 = a.a;
        j j0 = this.I;
        l l0 = this.G;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                job0 = BuildersKt__Builders_commonKt.launch$default(((CoroutineScope)this.B), null, null, new c(j0, this.E, this.G, null), 3, null);
                this.B = job0;
                this.w = 1;
                object1 = ((z0)this.D).g(this);
                if(object1 != a0) {
                label_23:
                    boolean z1 = ((Boolean)object1).booleanValue();
                    if(job0.isActive()) {
                        this.B = null;
                        this.r = z1;
                        this.w = 2;
                        if(JobKt.cancelAndJoin(job0, this) != a0) {
                            z = z1;
                        label_30:
                            if(!z) {
                                j0.l = null;
                                return H.a;
                            }
                            o o0 = new o(this.E);
                            p p1 = new p(o0);
                            this.B = p1;
                            this.w = 3;
                            if(((m)l0).a(o0, this) != a0) {
                                p0 = p1;
                            label_37:
                                this.B = null;
                                this.w = 4;
                                if(((m)l0).a(p0, this) != a0) {
                                    j0.l = null;
                                    return H.a;
                                }
                                return a0;
                            }
                        }
                    }
                    else {
                        o o1 = j0.l;
                        if(o1 == null) {
                            j0.l = null;
                            return H.a;
                        }
                        p p2 = z1 ? new p(o1) : new K.n(o1);
                        this.B = null;
                        this.w = 5;
                        if(((m)l0).a(p2, this) != a0) {
                            j0.l = null;
                            return H.a;
                        }
                    }
                }
                break;
            }
            case 1: {
                job0 = (Job)this.B;
                d5.n.D(object0);
                object1 = object0;
                goto label_23;
            }
            case 2: {
                z = this.r;
                d5.n.D(object0);
                goto label_30;
            }
            case 3: {
                p0 = (p)this.B;
                d5.n.D(object0);
                goto label_37;
            }
            case 4: 
            case 5: {
                d5.n.D(object0);
                j0.l = null;
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

