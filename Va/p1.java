package va;

import android.accounts.Account;
import ie.H;
import java.util.ArrayList;
import je.q;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import ne.a;
import oe.i;
import td.z1;
import we.n;

public final class p1 extends i implements n {
    public final t1 B;
    public int r;
    public Object w;

    public p1(t1 t10, Continuation continuation0) {
        this.B = t10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new p1(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p1)this.create(((ProducerScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ProducerScope producerScope0 = (ProducerScope)this.w;
        a a0 = a.a;
        t1 t10 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Iterable iterable0 = t10.a();
                ArrayList arrayList0 = new ArrayList(q.Q(10, iterable0));
                for(Object object1: iterable0) {
                    String s = ((Account)object1).name;
                    kotlin.jvm.internal.q.f(s, "name");
                    arrayList0.add(s);
                }
                this.w = producerScope0;
                this.r = 1;
                if(producerScope0.send(arrayList0, this) == a0) {
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
        o1 o10 = new o1(producerScope0);
        t10.b.addOnAccountsUpdatedListener(o10, null, true, new String[]{"com.iloen.auth.login"});
        z1 z10 = new z1(2, t10, o10);
        this.w = null;
        this.r = 2;
        return ProduceKt.awaitClose(producerScope0, z10, this) == a0 ? a0 : H.a;
    }
}

