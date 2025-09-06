package androidx.room;

import android.database.SQLException;
import ie.H;
import java.util.Set;
import je.y;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class a0 extends i implements n {
    public final h0 B;
    public int r;
    public Object w;

    public a0(h0 h00, Continuation continuation0) {
        this.B = h00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new a0(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a0)this.create(((T)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        T t0;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                t0 = (T)this.w;
                this.w = t0;
                this.r = 1;
                object0 = t0.a(this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_12;
            }
            case 1: {
                t0 = (T)this.w;
                d5.n.D(object0);
            label_12:
                if(!((Boolean)object0).booleanValue()) {
                    try {
                        Z z0 = new Z(this.B, null);
                        this.w = null;
                        this.r = 2;
                        object0 = t0.b(S.b, z0, this);
                        if(object0 == a0) {
                            return a0;
                        label_19:
                            d5.n.D(object0);
                        }
                        return (Set)object0;
                    }
                    catch(SQLException unused_ex) {
                    }
                }
                break;
            }
            case 2: {
                goto label_19;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return y.a;
    }
}

