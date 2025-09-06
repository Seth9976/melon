package I;

import J0.L;
import J0.o;
import J0.u;
import J0.v;
import java.util.Collection;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.H;
import ne.a;
import oe.h;
import we.n;

public final class z extends h implements n {
    public int B;
    public Object D;
    public final C E;
    public final H G;
    public final H I;
    public J0.n r;
    public int w;

    public z(C c0, H h0, H h1, Continuation continuation0) {
        this.E = c0;
        this.G = h0;
        this.I = h1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new z(this.E, this.G, this.I, continuation0);
        continuation1.D = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((z)this.create(((L)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object7;
        Object object5;
        Object object2;
        L l1;
        J0.n n0;
        Object object1;
        int v;
        L l0;
        a a0 = a.a;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                l0 = (L)this.D;
                v = 0;
                goto label_62;
            }
            case 1: {
                v = this.w;
                l0 = (L)this.D;
                d5.n.D(object0);
                object1 = object0;
                goto label_69;
            }
            case 2: {
                v = this.w;
                n0 = this.r;
                l1 = (L)this.D;
                d5.n.D(object0);
                object2 = object0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            Object object3 = ((J0.n)object2).a;
            int v1 = ((Collection)object3).size();
            for(int v2 = 0; v2 < v1; ++v2) {
                if(((v)((List)object3).get(v2)).b()) {
                    v = 1;
                    break;
                }
            }
            H h0 = this.G;
            boolean z = I.f(n0, ((v)h0.a).a);
            Object object4 = n0.a;
            H h1 = this.I;
            if(z) {
                int v3 = ((Collection)object4).size();
                int v4 = 0;
                while(true) {
                    object5 = null;
                    if(v4 < v3) {
                        Object object6 = ((List)object4).get(v4);
                        if(((v)object6).d) {
                            object5 = object6;
                        }
                        else {
                            ++v4;
                            continue;
                        }
                    }
                    break;
                }
                if(((v)object5) == null) {
                    v = 1;
                    l0 = l1;
                    goto label_62;
                }
                else {
                    h0.a = (v)object5;
                    h1.a = (v)object5;
                    goto label_61;
                }
                goto label_49;
            }
            else {
            label_49:
                int v5 = ((Collection)object4).size();
                int v6 = 0;
                while(true) {
                    object7 = null;
                    if(v6 < v5) {
                        Object object8 = ((List)object4).get(v6);
                        if(u.d(((v)object8).a, ((v)h0.a).a)) {
                            object7 = object8;
                        }
                        else {
                            ++v6;
                            continue;
                        }
                    }
                    break;
                }
                h1.a = object7;
            }
        label_61:
            l0 = l1;
        label_62:
            if(v == 0) {
                this.D = l0;
                this.r = null;
                this.w = 0;
                this.B = 1;
                object1 = l0.a(o.b, this);
                if(object1 != a0) {
                label_69:
                    Object object9 = ((J0.n)object1).a;
                    int v7 = ((Collection)object9).size();
                    int v8 = 0;
                    while(true) {
                        if(v8 < v7) {
                            if(u.c(((v)((List)object9).get(v8)))) {
                                ++v8;
                                continue;
                            }
                            else {
                                break;
                            }
                        }
                        v = 1;
                        break;
                    }
                    Object object10 = ((J0.n)object1).a;
                    int v9 = ((Collection)object10).size();
                    int v10 = 0;
                    while(v10 < v9) {
                        v v11 = (v)((List)object10).get(v10);
                        if(!v11.b() && !u.e(v11, l0.f.j, l0.d())) {
                            ++v10;
                        }
                        else {
                            v = 1;
                            if(true) {
                                break;
                            }
                        }
                    }
                    if(Z0.d(((J0.n)object1))) {
                        this.E.a = true;
                        v = 1;
                    }
                    this.D = l0;
                    this.r = (J0.n)object1;
                    this.w = v;
                    this.B = 2;
                    object2 = l0.a(o.c, this);
                    if(object2 == a0) {
                        return a0;
                    }
                    l1 = l0;
                    n0 = (J0.n)object1;
                    continue;
                }
                return a0;
            }
            break;
        }
        return ie.H.a;
    }
}

