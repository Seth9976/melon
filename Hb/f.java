package hb;

import Na.d;
import Na.e;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.response.DjTagPlylstListRes;
import com.iloen.melon.net.v5x.response.DjTagInformV5Res;
import com.iloen.melon.net.v6x.response.BrandDetailMagazineListRes;
import com.iloen.melon.net.v6x.response.BrandDetailVideoListRes;
import com.iloen.melon.net.v6x.response.DjBrandDetailDjplaylistListRes;
import com.iloen.melon.net.v6x.response.DjBrandDetailRecmSongListRes;
import com.iloen.melon.net.v6x.response.DjPlaylistListV6Res;
import com.iloen.melon.net.v6x.response.DjPopularTermPlayListsRes;
import d5.n;
import d5.v;
import ne.a;
import oe.c;

public final class f {
    public final v a;

    public f(v v0) {
        this.a = v0;
        super();
    }

    public Object a(String s, String s1, c c0) {
        o o0;
        if(c0 instanceof o) {
            o0 = (o)c0;
            int v = o0.B;
            if((v & 0x80000000) == 0) {
                o0 = new o(this, c0);
            }
            else {
                o0.B = v ^ 0x80000000;
            }
        }
        else {
            o0 = new o(this, c0);
        }
        Object object0 = o0.r;
        a a0 = a.a;
        switch(o0.B) {
            case 0: {
                n.D(object0);
                try {
                    o0.B = 1;
                    object0 = this.a.c(s, s1, o0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((HttpResponse)object0));
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

    public Object b(int v, int v1, String s, c c0) {
        hb.e e0;
        if(c0 instanceof hb.e) {
            e0 = (hb.e)c0;
            int v2 = e0.B;
            if((v2 & 0x80000000) == 0) {
                e0 = new hb.e(this, c0);
            }
            else {
                e0.B = v2 ^ 0x80000000;
            }
        }
        else {
            e0 = new hb.e(this, c0);
        }
        Object object0 = e0.r;
        a a0 = a.a;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                try {
                    e0.B = 1;
                    object0 = this.a.o(v, v1, s, e0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((BrandDetailMagazineListRes)object0));
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

    public Object c(int v, int v1, String s, c c0) {
        g g0;
        if(c0 instanceof g) {
            g0 = (g)c0;
            int v2 = g0.B;
            if((v2 & 0x80000000) == 0) {
                g0 = new g(this, c0);
            }
            else {
                g0.B = v2 ^ 0x80000000;
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
                    object0 = this.a.p(v, v1, s, g0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((DjBrandDetailDjplaylistListRes)object0));
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

    public Object d(int v, int v1, String s, c c0) {
        i i0;
        if(c0 instanceof i) {
            i0 = (i)c0;
            int v2 = i0.B;
            if((v2 & 0x80000000) == 0) {
                i0 = new i(this, c0);
            }
            else {
                i0.B = v2 ^ 0x80000000;
            }
        }
        else {
            i0 = new i(this, c0);
        }
        Object object0 = i0.r;
        a a0 = a.a;
        switch(i0.B) {
            case 0: {
                n.D(object0);
                try {
                    i0.B = 1;
                    object0 = this.a.r(v, v1, s, i0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((DjBrandDetailRecmSongListRes)object0));
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

    public Object e(int v, int v1, String s, c c0) {
        k k0;
        if(c0 instanceof k) {
            k0 = (k)c0;
            int v2 = k0.B;
            if((v2 & 0x80000000) == 0) {
                k0 = new k(this, c0);
            }
            else {
                k0.B = v2 ^ 0x80000000;
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
                    object0 = this.a.t(v, v1, s, k0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((BrandDetailVideoListRes)object0));
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

    public Object f(int v, int v1, String s, String s1, c c0) {
        hb.n n0;
        if(c0 instanceof hb.n) {
            n0 = (hb.n)c0;
            int v2 = n0.B;
            if((v2 & 0x80000000) == 0) {
                n0 = new hb.n(this, c0);
            }
            else {
                n0.B = v2 ^ 0x80000000;
            }
        }
        else {
            n0 = new hb.n(this, c0);
        }
        Object object0 = n0.r;
        a a0 = a.a;
        switch(n0.B) {
            case 0: {
                n.D(object0);
                try {
                    n0.B = 1;
                    object0 = this.a.z(v, v1, s, s1, n0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((DjPlaylistListV6Res)object0));
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

    public Object g(String s, c c0) {
        p p0;
        if(c0 instanceof p) {
            p0 = (p)c0;
            int v = p0.B;
            if((v & 0x80000000) == 0) {
                p0 = new p(this, c0);
            }
            else {
                p0.B = v ^ 0x80000000;
            }
        }
        else {
            p0 = new p(this, c0);
        }
        Object object0 = p0.r;
        a a0 = a.a;
        switch(p0.B) {
            case 0: {
                n.D(object0);
                String s1 = "DAILY";
                switch(s) {
                    case "M": {
                        s1 = "MONTHLY";
                        break;
                    }
                    case "W": {
                        s1 = "WEEKLY";
                    }
                }
                try {
                    p0.B = 1;
                    object0 = this.a.E(s1, p0);
                    if(object0 == a0) {
                        return a0;
                    label_24:
                        n.D(object0);
                    }
                    return new e(((DjPopularTermPlayListsRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_24;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object h(String s, c c0) {
        hb.v v0;
        if(c0 instanceof hb.v) {
            v0 = (hb.v)c0;
            int v1 = v0.B;
            if((v1 & 0x80000000) == 0) {
                v0 = new hb.v(this, c0);
            }
            else {
                v0.B = v1 ^ 0x80000000;
            }
        }
        else {
            v0 = new hb.v(this, c0);
        }
        Object object0 = v0.r;
        a a0 = a.a;
        switch(v0.B) {
            case 0: {
                n.D(object0);
                try {
                    v0.B = 1;
                    object0 = this.a.F(s, v0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((DjTagInformV5Res)object0));
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

    public Object i(String s, String s1, int v, String s2, c c0) {
        u u0;
        if(c0 instanceof u) {
            u0 = (u)c0;
            int v1 = u0.B;
            if((v1 & 0x80000000) == 0) {
                u0 = new u(this, c0);
            }
            else {
                u0.B = v1 ^ 0x80000000;
            }
        }
        else {
            u0 = new u(this, c0);
        }
        Object object0 = u0.r;
        a a0 = a.a;
        switch(u0.B) {
            case 0: {
                n.D(object0);
                try {
                    u0.B = 1;
                    object0 = this.a.G(s, s1, v, s2, u0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((DjTagPlylstListRes)object0));
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

