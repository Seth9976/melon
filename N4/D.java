package n4;

import android.adservices.adid.AdId;
import android.adservices.adid.AdIdManager;
import d5.n;
import e1.u;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class d {
    public final AdIdManager a;

    public d(AdIdManager adIdManager0) {
        q.g(adIdManager0, "mAdIdManager");
        super();
        this.a = adIdManager0;
    }

    @Nullable
    public Object a(@NotNull Continuation continuation0) {
        return d.b(this, continuation0);
    }

    public static Object b(d d0, Continuation continuation0) {
        c c0;
        if(continuation0 instanceof c) {
            c0 = (c)continuation0;
            int v = c0.D;
            if((v & 0x80000000) == 0) {
                c0 = new c(d0, continuation0);
            }
            else {
                c0.D = v ^ 0x80000000;
            }
        }
        else {
            c0 = new c(d0, continuation0);
        }
        Object object0 = c0.w;
        a a0 = a.a;
        switch(c0.D) {
            case 0: {
                n.D(object0);
                c0.r = d0;
                c0.D = 1;
                d0.getClass();
                CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(c0), 1);
                cancellableContinuationImpl0.initCancellability();
                l.a a1 = new l.a(1);
                Y1.c c1 = new Y1.c(cancellableContinuationImpl0);
                b.t(d0.a, a1, c1);
                object0 = cancellableContinuationImpl0.getResult();
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d0 = c0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d0.getClass();
        String s = b.q(((AdId)object0));
        q.f(s, "response.adId");
        return new n4.a(s, b.z(((AdId)object0)));
    }
}

