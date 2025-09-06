package l2;

import com.google.firebase.messaging.u;
import d5.n;
import ie.H;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import ne.a;
import oe.i;
import we.k;

public final class m extends i implements k {
    public Object B;
    public Object D;
    public Iterator E;
    public int G;
    public int I;
    public final M M;
    public final u N;
    public Object r;
    public Serializable w;

    public m(M m0, u u0, Continuation continuation0) {
        this.M = m0;
        this.N = u0;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new m(this.M, this.N, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((m)this.create(((Continuation)object0))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object1;
        C c0;
        kotlin.jvm.internal.H h0;
        Mutex mutex0;
        Mutex mutex1;
        C c1;
        kotlin.jvm.internal.H h1;
        l l0;
        Iterator iterator0;
        Mutex mutex2;
        C c2;
        kotlin.jvm.internal.H h3;
        kotlin.jvm.internal.H h2;
        a a0 = a.a;
        u u0 = this.N;
        int v = 0;
        M m0 = this.M;
        switch(this.I) {
            case 0: {
                n.D(object0);
                mutex2 = MutexKt.Mutex$default(false, 1, null);
                c2 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
                h2 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                this.r = mutex2;
                this.w = c2;
                this.B = h2;
                this.D = h2;
                this.I = 1;
                object0 = M.f(m0, true, this);
                if(object0 != a0) {
                    h3 = h2;
                label_40:
                    h2.a = ((d)object0).b;
                    l l1 = new l(mutex2, c2, h3, m0);
                    List list0 = (List)u0.c;
                    if(list0 == null) {
                        mutex0 = mutex2;
                    }
                    else {
                        mutex1 = mutex2;
                        c1 = c2;
                        h1 = h3;
                        l0 = l1;
                        iterator0 = list0.iterator();
                    label_49:
                        while(iterator0.hasNext()) {
                            Object object2 = iterator0.next();
                            this.r = mutex1;
                            this.w = c1;
                            this.B = h1;
                            this.D = l0;
                            this.E = iterator0;
                            this.I = 2;
                            if(((we.n)object2).invoke(l0, this) == a0) {
                                return a0;
                            }
                            if(false) {
                                break;
                            }
                        }
                        h3 = h1;
                        c2 = c1;
                        mutex0 = mutex1;
                    }
                    u0.c = null;
                    this.r = c2;
                    this.w = h3;
                    this.B = mutex0;
                    this.D = null;
                    this.E = null;
                    this.I = 3;
                    if(mutex0.lock(null, this) != a0) {
                        h0 = h3;
                        c0 = c2;
                    label_75:
                        c0.a = true;
                        mutex0.unlock(null);
                        object1 = h0.a;
                        if(object1 != null) {
                            v = object1.hashCode();
                        }
                        i0 i00 = m0.g();
                        this.r = object1;
                        this.w = null;
                        this.B = null;
                        this.G = v;
                        this.I = 4;
                        object0 = i00.a();
                        if(object0 != a0) {
                            return new d(object1, v, ((Number)object0).intValue());
                        }
                    }
                }
                break;
            }
            case 1: {
                h2 = (kotlin.jvm.internal.H)this.D;
                h3 = (kotlin.jvm.internal.H)this.B;
                c2 = (C)this.w;
                mutex2 = (Mutex)this.r;
                n.D(object0);
                goto label_40;
            }
            case 2: {
                iterator0 = this.E;
                l0 = (l)this.D;
                h1 = (kotlin.jvm.internal.H)this.B;
                c1 = (C)this.w;
                mutex1 = (Mutex)this.r;
                n.D(object0);
                goto label_49;
            }
            case 3: {
                mutex0 = (Mutex)this.B;
                h0 = (kotlin.jvm.internal.H)this.w;
                c0 = (C)this.r;
                n.D(object0);
                goto label_75;
            }
            case 4: {
                int v1 = this.G;
                object1 = this.r;
                n.D(object0);
                return new d(object1, v1, ((Number)object0).intValue());
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

