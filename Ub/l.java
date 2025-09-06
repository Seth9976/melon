package ub;

import Aa.j;
import Na.d;
import Na.e;
import Ua.h;
import com.iloen.melon.net.v6x.request.SearchNextTagListReq.Params;
import com.iloen.melon.net.v6x.response.BannerRes;
import com.iloen.melon.net.v6x.response.SearchHotKeywordAndMenuListRes;
import com.iloen.melon.net.v6x.response.SearchNextTagListRes;
import com.iloen.melon.net.v6x.response.SearchTagListRes;
import com.melon.net.res.SearchMainContentRes;
import d5.n;
import java.io.Serializable;
import ne.a;
import oe.c;

public final class l {
    public final j a;
    public final h b;

    public l(j j0, h h0) {
        this.a = j0;
        this.b = h0;
    }

    public final Object a(c c0) {
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
        Object object0 = g0.r;
        a a0 = a.a;
        switch(g0.B) {
            case 0: {
                n.D(object0);
                try {
                    g0.B = 1;
                    object0 = this.a.c(g0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((SearchMainContentRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public final Object b(c c0) {
        ub.h h0;
        if(c0 instanceof ub.h) {
            h0 = (ub.h)c0;
            int v = h0.B;
            if((v & 0x80000000) == 0) {
                h0 = new ub.h(this, c0);
            }
            else {
                h0.B = v ^ 0x80000000;
            }
        }
        else {
            h0 = new ub.h(this, c0);
        }
        Serializable serializable0 = h0.r;
        a a0 = a.a;
        switch(h0.B) {
            case 0: {
                n.D(serializable0);
                try {
                    h0.B = 1;
                    serializable0 = this.a.d(h0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        n.D(serializable0);
                    }
                    return new e(((SearchHotKeywordAndMenuListRes)serializable0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public final Object c(Params searchNextTagListReq$Params0, c c0) {
        i i0;
        if(c0 instanceof i) {
            i0 = (i)c0;
            int v = i0.B;
            if((v & 0x80000000) == 0) {
                i0 = new i(this, c0);
            }
            else {
                i0.B = v ^ 0x80000000;
            }
        }
        else {
            i0 = new i(this, c0);
        }
        Serializable serializable0 = i0.r;
        a a0 = a.a;
        switch(i0.B) {
            case 0: {
                n.D(serializable0);
                try {
                    i0.B = 1;
                    serializable0 = this.a.e(searchNextTagListReq$Params0, i0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        n.D(serializable0);
                    }
                    return new e(((SearchNextTagListRes)serializable0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public final Object d(c c0) {
        ub.j j0;
        if(c0 instanceof ub.j) {
            j0 = (ub.j)c0;
            int v = j0.B;
            if((v & 0x80000000) == 0) {
                j0 = new ub.j(this, c0);
            }
            else {
                j0.B = v ^ 0x80000000;
            }
        }
        else {
            j0 = new ub.j(this, c0);
        }
        Serializable serializable0 = j0.r;
        a a0 = a.a;
        switch(j0.B) {
            case 0: {
                n.D(serializable0);
                try {
                    j0.B = 1;
                    serializable0 = this.a.g(j0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        n.D(serializable0);
                    }
                    return new e(((SearchTagListRes)serializable0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public final Object e(c c0) {
        k k0;
        if(c0 instanceof k) {
            k0 = (k)c0;
            int v = k0.B;
            if((v & 0x80000000) == 0) {
                k0 = new k(this, c0);
            }
            else {
                k0.B = v ^ 0x80000000;
            }
        }
        else {
            k0 = new k(this, c0);
        }
        Object object0 = k0.r;
        a a0 = a.a;
        switch(k0.B) {
            case 0: {
                n.D(object0);
                try {
                    k0.B = 1;
                    object0 = this.b.J(k0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((BannerRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }
}

