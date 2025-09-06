package p4;

import android.adservices.appsetid.AppSetId;
import android.adservices.appsetid.AppSetIdManager;
import d5.n;
import e1.u;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class c {
    public final AppSetIdManager a;

    public c(AppSetIdManager appSetIdManager0) {
        q.g(appSetIdManager0, "mAppSetIdManager");
        super();
        this.a = appSetIdManager0;
    }

    @Nullable
    public Object a(@NotNull Continuation continuation0) {
        return c.b(this, continuation0);
    }

    public static Object b(c c0, Continuation continuation0) {
        b b0;
        if(continuation0 instanceof b) {
            b0 = (b)continuation0;
            int v = b0.D;
            if((v & 0x80000000) == 0) {
                b0 = new b(c0, continuation0);
            }
            else {
                b0.D = v ^ 0x80000000;
            }
        }
        else {
            b0 = new b(c0, continuation0);
        }
        Object object0 = b0.w;
        a a0 = a.a;
        switch(b0.D) {
            case 0: {
                n.D(object0);
                b0.r = c0;
                b0.D = 1;
                c0.getClass();
                CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(b0), 1);
                cancellableContinuationImpl0.initCancellability();
                l.a a1 = new l.a(1);
                Y1.c c1 = new Y1.c(cancellableContinuationImpl0);
                n4.b.u(c0.a, a1, c1);
                object0 = cancellableContinuationImpl0.getResult();
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                c0 = b0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        c0.getClass();
        if(n4.b.a(((AppSetId)object0)) == 1) {
            String s = n4.b.r(((AppSetId)object0));
            q.f(s, "response.id");
            return new p4.a(s, 1);
        }
        String s1 = n4.b.r(((AppSetId)object0));
        q.f(s1, "response.id");
        return new p4.a(s1, 2);
    }
}

