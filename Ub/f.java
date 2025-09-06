package ub;

import Aa.j;
import Na.d;
import Na.e;
import com.iloen.melon.net.v6x.response.SearchAutoCompleteContentResponse;
import com.iloen.melon.net.v6x.response.SearchRecentKeywordGetResponse;
import com.melon.data.service.SearchApi.RecentKeywordBody;
import d5.n;
import ie.H;
import java.io.Serializable;
import java.util.List;
import je.w;
import oe.c;

public final class f {
    public final j a;

    public f(j j0) {
        this.a = j0;
    }

    public final Object a(c c0) {
        int v2;
        f f0;
        int v1;
        a a0;
        if(c0 instanceof a) {
            a0 = (a)c0;
            int v = a0.G;
            if((v & 0x80000000) == 0) {
                a0 = new a(this, c0);
            }
            else {
                a0.G = v ^ 0x80000000;
            }
        }
        else {
            a0 = new a(this, c0);
        }
        Object object0 = a0.D;
        ne.a a1 = ne.a.a;
        switch(a0.G) {
            case 0: {
                n.D(object0);
                v1 = 0;
                try {
                    a0.r = this;
                    a0.w = 0;
                    a0.B = 0;
                    a0.G = 1;
                    return this.a.a(a0) == a1 ? a1 : new e(H.a);
                }
                catch(Exception unused_ex) {
                    f0 = this;
                    v2 = 0;
                    goto label_30;
                }
                return a1;
            }
            case 1: {
                try {
                    v1 = a0.B;
                    v2 = a0.w;
                    f0 = a0.r;
                    n.D(object0);
                    return new e(H.a);
                }
                catch(Exception unused_ex) {
                }
                try {
                label_30:
                    a0.r = null;
                    a0.w = v2;
                    a0.B = v1;
                    a0.G = 2;
                    if(f0.a.a(a0) == a1) {
                        return a1;
                    label_36:
                        n.D(object0);
                    }
                    return new e(H.a);
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 2: {
                goto label_36;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public final Object b(String s, c c0) {
        b b0;
        if(c0 instanceof b) {
            b0 = (b)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new b(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new b(this, c0);
        }
        Serializable serializable0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(serializable0);
                try {
                    b0.B = 1;
                    serializable0 = this.a.b(s, b0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        n.D(serializable0);
                    }
                    return new e(((SearchAutoCompleteContentResponse)serializable0));
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

    public final Object c(c c0) {
        ub.c c1;
        if(c0 instanceof ub.c) {
            c1 = (ub.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new ub.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new ub.c(this, c0);
        }
        Serializable serializable0 = c1.r;
        ne.a a0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                n.D(serializable0);
                try {
                    c1.B = 1;
                    serializable0 = this.a.f(c1);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        n.D(serializable0);
                    }
                    return new e(((SearchRecentKeywordGetResponse)serializable0));
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

    public final Object d(String s, String s1, String s2, String s3, List list0, String s4, String s5, String s6, c c0) {
        ub.d d0;
        if(c0 instanceof ub.d) {
            d0 = (ub.d)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new ub.d(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new ub.d(this, c0);
        }
        Object object0 = d0.r;
        ne.a a0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                try {
                    RecentKeywordBody searchApi$RecentKeywordBody0 = new RecentKeywordBody(s, s1, s2, s3, list0, s4, s5, s6);
                    d0.B = 1;
                    if(this.a.h(searchApi$RecentKeywordBody0, d0) == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(H.a);
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

    public final Object e(String s, c c0) {
        ub.e e0;
        if(c0 instanceof ub.e) {
            e0 = (ub.e)c0;
            int v = e0.B;
            if((v & 0x80000000) == 0) {
                e0 = new ub.e(this, c0);
            }
            else {
                e0.B = v ^ 0x80000000;
            }
        }
        else {
            e0 = new ub.e(this, c0);
        }
        Object object0 = e0.r;
        ne.a a0 = ne.a.a;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                try {
                    RecentKeywordBody searchApi$RecentKeywordBody0 = new RecentKeywordBody("", "", "", s, w.a, "", "", "");
                    e0.B = 1;
                    if(this.a.h(searchApi$RecentKeywordBody0, e0) == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(H.a);
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

