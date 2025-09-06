package eb;

import android.text.TextUtils;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.response.PvLogDummyRes;
import com.iloen.melon.utils.MenuIdQueue;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.common.ResponseBase;
import com.melon.ui.h0;
import ie.H;
import java.io.Serializable;
import java.util.Map;
import je.x;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import va.e;

public final class n {
    public final f a;
    public final c b;
    public final d5.c c;
    public final LogU d;
    public String e;
    public ResponseBase f;

    public n(f f0, c c0, d5.c c1) {
        this.a = f0;
        this.b = c0;
        this.c = c1;
        LogU logU0 = new LogU("PvLogDummyLog-PV");
        logU0.setCategory(Category.None);
        logU0.setUseThreadInfo(true);
        this.d = logU0;
        this.e = "";
    }

    public final Object a(String s, x x0, oe.c c0) {
        g g0;
        if(c0 instanceof g) {
            g0 = (g)c0;
            int v = g0.B;
            if((v & 0x80000000) == 0) {
                g0 = new g(this, c0);
            }
            else {
                g0.B = v ^ 0x80000000;
            }
        }
        else {
            g0 = new g(this, c0);
        }
        Serializable serializable0 = g0.r;
        a a0 = a.a;
        switch(g0.B) {
            case 0: {
                d5.n.D(serializable0);
                g0.B = 1;
                serializable0 = this.a.a(s, x0, g0);
                if(serializable0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(serializable0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        String s1 = ((PvLogDummyRes)serializable0).logging;
        if(!TextUtils.isEmpty(s1)) {
            String s2 = MenuIdQueue.getInstance().peek();
            q.d(s2);
            String s3 = this.b.a(s1, s2);
            ResponseBase responseBase0 = ((PvLogDummyRes)serializable0).getResponse();
            if(responseBase0 != null) {
                return new eb.q(responseBase0, s3, s2);
            }
        }
        return null;
    }

    public final Object b(String s, Map map0, Q0.n n0, h0 h00, oe.c c0) {
        Exception exception2;
        a a0;
        Serializable serializable0;
        h h0;
        if(c0 instanceof h) {
            h0 = (h)c0;
            int v = h0.E;
            if((v & 0x80000000) == 0) {
                h0 = new h(this, c0);
            }
            else {
                h0.E = v ^ 0x80000000;
            }
        }
        else {
            h0 = new h(this, c0);
        }
        try {
            serializable0 = h0.B;
            a0 = a.a;
            switch(h0.E) {
                case 0: {
                    goto label_15;
                }
                case 1: {
                    goto label_22;
                }
                case 2: {
                    goto label_13;
                }
            }
        }
        catch(Exception exception0) {
            exception2 = exception0;
            LogU.warn$default(this.d, e.b("performDummyLog() error: ", exception2.getMessage()), null, false, 6, null);
            return H.a;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        try {
        label_13:
            d5.n.D(serializable0);
        }
        catch(Exception exception0) {
            exception2 = exception0;
            LogU.warn$default(this.d, e.b("performDummyLog() error: ", exception2.getMessage()), null, false, 6, null);
        }
        return H.a;
    label_15:
        d5.n.D(serializable0);
        try {
            h0.r = n0;
            h0.w = h00;
            h0.E = 1;
            serializable0 = this.a.a(s, map0, h0);
            if(serializable0 == a0) {
                return a0;
            }
            goto label_29;
        }
        catch(Exception exception1) {
            exception2 = exception1;
            LogU.warn$default(this.d, e.b("performDummyLog() error: ", exception2.getMessage()), null, false, 6, null);
            return H.a;
        }
        try {
        label_22:
            h00 = h0.w;
            n0 = h0.r;
            d5.n.D(serializable0);
        }
        catch(Exception exception0) {
            exception2 = exception0;
            LogU.warn$default(this.d, e.b("performDummyLog() error: ", exception2.getMessage()), null, false, 6, null);
            return H.a;
        }
        try {
        label_29:
            i i0 = new i(h00, ((PvLogDummyRes)serializable0), this, n0, null);
            h0.r = null;
            h0.w = null;
            h0.E = 2;
            return BuildersKt.withContext(Dispatchers.getMain(), i0, h0) == a0 ? a0 : H.a;
        }
        catch(Exception exception1) {
            exception2 = exception1;
        }
        LogU.warn$default(this.d, e.b("performDummyLog() error: ", exception2.getMessage()), null, false, 6, null);
        return H.a;
    }

    public final Object c(HttpResponse httpResponse0, we.a a0, oe.c c0) {
        ResponseBase responseBase0;
        String s;
        j j0;
        if(c0 instanceof j) {
            j0 = (j)c0;
            int v = j0.E;
            if((v & 0x80000000) == 0) {
                j0 = new j(this, c0);
            }
            else {
                j0.E = v ^ 0x80000000;
            }
        }
        else {
            j0 = new j(this, c0);
        }
        Object object0 = j0.B;
        a a1 = a.a;
        H h0 = H.a;
        switch(j0.E) {
            case 0: {
                d5.n.D(object0);
                if(httpResponse0.logging.length() == 0) {
                    return h0;
                }
                s = httpResponse0.logging;
                responseBase0 = httpResponse0.getResponse();
                if(((Boolean)a0.invoke()).booleanValue() && (this.e.length() == 0 || !this.e.equals(s))) {
                    String s1 = MenuIdQueue.getInstance().peek();
                    if(responseBase0 != null) {
                        q.d(s1);
                        eb.q q0 = new eb.q(responseBase0, this.b.a(s, s1), s1);
                        j0.r = s;
                        j0.w = responseBase0;
                        j0.E = 1;
                        if(this.c.g(q0, j0) == a1) {
                            return a1;
                        }
                    }
                }
                break;
            }
            case 1: {
                responseBase0 = j0.w;
                String s2 = j0.r;
                d5.n.D(object0);
                s = s2;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        this.e = s;
        this.f = responseBase0;
        return h0;
    }

    public final Object d(String s, Map map0, Q0.n n0, h0 h00, oe.c c0) {
        H h0;
        a a0;
        Object object0;
        k k0;
        if(c0 instanceof k) {
            k0 = (k)c0;
            int v = k0.I;
            if((v & 0x80000000) == 0) {
                k0 = new k(this, c0);
            }
            else {
                k0.I = v ^ 0x80000000;
            }
        }
        else {
            k0 = new k(this, c0);
        }
        try {
            object0 = k0.E;
            a0 = a.a;
            h0 = H.a;
            switch(k0.I) {
                case 0: {
                    goto label_18;
                }
                case 1: {
                    goto label_14;
                }
                case 2: {
                    goto label_51;
                }
                case 3: {
                    goto label_16;
                }
            }
        }
        catch(Exception exception0) {
            LogU.warn$default(this.d, "performLoggingOnForeground() error: " + exception0.getMessage(), null, false, 6, null);
            return h0;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
    label_14:
        d5.n.D(object0);
        return h0;
        try {
        label_16:
            d5.n.D(object0);
        }
        catch(Exception exception0) {
            LogU.warn$default(this.d, "performLoggingOnForeground() error: " + exception0.getMessage(), null, false, 6, null);
        }
        return h0;
    label_18:
        d5.n.D(object0);
        MenuIdQueue menuIdQueue0 = MenuIdQueue.getInstance();
        if(menuIdQueue0.isSkipAction() && s == null) {
            menuIdQueue0.setSkipAction(false);
            LogU.verbose$default(this.d, "performLoggingOnForeground() skip logging", null, false, 6, null);
            return h0;
        }
        if(this.e.length() > 0) {
            String s1 = MenuIdQueue.getInstance().peek();
            ResponseBase responseBase0 = this.f;
            if(responseBase0 != null) {
                String s2 = this.e;
                q.d(s1);
                eb.q q0 = new eb.q(responseBase0, this.b.a(s2, s1), s1);
                k0.r = null;
                k0.w = null;
                k0.B = null;
                k0.I = 1;
                if(this.c.g(q0, k0) == a0) {
                    return a0;
                }
            }
        }
        else if(s != null) {
            try {
                k0.r = n0;
                k0.w = h00;
                k0.B = s;
                k0.D = 0;
                k0.I = 2;
                Serializable serializable0 = this.a.a(s, map0, k0);
                if(serializable0 == a0) {
                    return a0;
                }
                Q0.n n1 = n0;
                int v1 = 0;
                String s3 = s;
                Serializable serializable1 = serializable0;
                h0 h01 = h00;
                goto label_61;
            label_51:
                int v2 = k0.D;
                String s4 = k0.B;
                h0 h02 = k0.w;
                Q0.n n2 = k0.r;
                d5.n.D(object0);
                v1 = v2;
                serializable1 = object0;
                s3 = s4;
                h01 = h02;
                n1 = n2;
            label_61:
                l l0 = new l(h01, ((PvLogDummyRes)serializable1), this, n1, null);
                k0.r = null;
                k0.w = null;
                k0.B = s3;
                k0.D = v1;
                k0.I = 3;
                if(BuildersKt.withContext(Dispatchers.getMain(), l0, k0) == a0) {
                    return a0;
                }
            }
            catch(Exception exception0) {
                LogU.warn$default(this.d, "performLoggingOnForeground() error: " + exception0.getMessage(), null, false, 6, null);
            }
        }
        return h0;
    }

    public final Object e(String s, Continuation continuation0) {
        H h0;
        a a0;
        Object object0;
        m m0;
        if(continuation0 instanceof m) {
            m0 = (m)continuation0;
            int v = m0.B;
            if((v & 0x80000000) == 0) {
                m0 = new m(this, continuation0);
            }
            else {
                m0.B = v ^ 0x80000000;
            }
        }
        else {
            m0 = new m(this, continuation0);
        }
        try {
            object0 = m0.r;
            a0 = a.a;
            h0 = H.a;
            switch(m0.B) {
                case 0: {
                    goto label_16;
                }
                case 1: {
                    goto label_21;
                }
                case 2: {
                    goto label_14;
                }
            }
        }
        catch(Exception exception0) {
            LogU.warn$default(this.d, e.b("performPipDummyLog() error: ", exception0.getMessage()), null, false, 6, null);
            return h0;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        try {
        label_14:
            d5.n.D(object0);
        }
        catch(Exception exception0) {
            LogU.warn$default(this.d, e.b("performPipDummyLog() error: ", exception0.getMessage()), null, false, 6, null);
        }
        return h0;
    label_16:
        d5.n.D(object0);
        try {
            m0.B = 1;
            object0 = this.a(s, x.a, m0);
            if(object0 != a0) {
                goto label_22;
            label_21:
                d5.n.D(object0);
            label_22:
                if(((eb.q)object0) == null) {
                    return h0;
                }
                m0.B = 2;
                if(this.c.h(((eb.q)object0), m0) != a0) {
                    return h0;
                }
            }
            return a0;
        }
        catch(Exception exception0) {
            LogU.warn$default(this.d, e.b("performPipDummyLog() error: ", exception0.getMessage()), null, false, 6, null);
            return h0;
        }
    }
}

