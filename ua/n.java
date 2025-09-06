package Ua;

import Na.d;
import Na.e;
import com.iloen.melon.fragments.comments.CmtHelper;
import com.iloen.melon.net.v3x.comments.CancelRecmRes;
import com.iloen.melon.net.v3x.comments.DeleteCmtRes;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes;
import com.iloen.melon.net.v3x.comments.InsertRecmRes;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.CHNLINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.PAGEINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.PAGINGINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.utils.StringUtils;
import ne.a;
import oe.c;

public final class n {
    public final h a;

    public n(h h0) {
        this.a = h0;
    }

    public final Object a(int v, String s, int v1, boolean z, c c0) {
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
                d5.n.D(object0);
                try {
                    i0.B = 1;
                    object0 = this.a.d(v, s, v1, z, i0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(object0);
                    }
                    return new e(((CancelRecmRes)object0));
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

    public final Object b(int v, int v1, String s, c c0) {
        j j0;
        if(c0 instanceof j) {
            j0 = (j)c0;
            int v2 = j0.B;
            if((v2 & 0x80000000) == 0) {
                j0 = new j(this, c0);
            }
            else {
                j0.B = v2 ^ 0x80000000;
            }
        }
        else {
            j0 = new j(this, c0);
        }
        Object object0 = j0.r;
        a a0 = a.a;
        switch(j0.B) {
            case 0: {
                d5.n.D(object0);
                try {
                    j0.B = 1;
                    object0 = this.a.g(v, v1, s, j0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(object0);
                    }
                    return new e(((DeleteCmtRes)object0));
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

    public final Object c(String s, String s1, c c0) {
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
                d5.n.D(object0);
                try {
                    int v1 = StringUtils.getNumberFromString(s);
                    Integer integer0 = CmtHelper.getLatestComment(v1, s1);
                    int v2 = integer0 == null ? -1 : ((int)integer0);
                    h h0 = this.a;
                    if(s1 == null) {
                        s1 = "";
                    }
                    k0.B = 1;
                    object0 = h0.p(v1, s1, new Integer(v2), k0);
                    if(object0 == a0) {
                        return a0;
                    label_24:
                        d5.n.D(object0);
                    }
                    return new e(((InformCmtContsSummRes)object0));
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

    public final Object d(String s, String s1, c c0) {
        Integer integer1;
        Integer integer0;
        int v4;
        String s2;
        a a0;
        Object object0;
        l l0;
        if(c0 instanceof l) {
            l0 = (l)c0;
            int v = l0.M;
            if((v & 0x80000000) == 0) {
                l0 = new l(this, c0);
            }
            else {
                l0.M = v ^ 0x80000000;
            }
        }
        else {
            l0 = new l(this, c0);
        }
        try {
            object0 = l0.G;
            a0 = a.a;
            s2 = "";
            switch(l0.M) {
                case 0: {
                    goto label_14;
                }
                case 1: {
                    goto label_27;
                }
                case 2: {
                    goto label_77;
                }
            }
        }
        catch(Exception exception0) {
            return new d(exception0);
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
    label_14:
        d5.n.D(object0);
        try {
            int v1 = StringUtils.getNumberFromString(s);
            l0.r = this;
            l0.B = 0;
            l0.D = 0;
            l0.E = v1;
            l0.M = 1;
            object0 = this.a.r(v1, (s1 == null ? "" : s1), l0, true);
            if(object0 == a0) {
                return a0;
            }
            n n0 = this;
            int v2 = 0;
            int v3 = 0;
            goto label_32;
        label_27:
            v1 = l0.E;
            v2 = l0.D;
            v3 = l0.B;
            n0 = l0.r;
            d5.n.D(object0);
        label_32:
            h h0 = n0.a;
            result loadPgnRes$result0 = ((LoadPgnRes)object0).result;
            if(loadPgnRes$result0 == null) {
                v4 = 0;
            }
            else {
                CHNLINFO loadPgnRes$result$CHNLINFO0 = loadPgnRes$result0.chnlinfo;
                v4 = loadPgnRes$result$CHNLINFO0 == null ? 0 : loadPgnRes$result$CHNLINFO0.chnlseq;
            }
            if(loadPgnRes$result0 != null) {
                PAGEINFO loadPgnRes$result$PAGEINFO0 = loadPgnRes$result0.pageinfo;
                if(loadPgnRes$result$PAGEINFO0 != null) {
                    String s3 = loadPgnRes$result$PAGEINFO0.contsrefvalue;
                    if(s3 != null) {
                        s2 = s3;
                    }
                }
            }
            if(loadPgnRes$result0 == null) {
                integer0 = null;
            }
            else {
                PAGINGINFO loadPgnRes$result$PAGINGINFO0 = loadPgnRes$result0.paginginfo;
                integer0 = loadPgnRes$result$PAGINGINFO0 == null ? null : new Integer(loadPgnRes$result$PAGINGINFO0.firstpageno);
            }
            result loadPgnRes$result1 = ((LoadPgnRes)object0).result;
            if(loadPgnRes$result1 == null) {
                integer1 = null;
            }
            else {
                PAGEINFO loadPgnRes$result$PAGEINFO1 = loadPgnRes$result1.pageinfo;
                integer1 = loadPgnRes$result$PAGEINFO1 == null ? null : new Integer(loadPgnRes$result$PAGEINFO1.startseq);
            }
            l0.r = null;
            l0.w = (LoadPgnRes)object0;
            l0.B = v3;
            l0.D = v2;
            l0.E = v1;
            l0.M = 2;
            Object object1 = h0.q(v4, s2, integer1, new Integer(0), new Integer(-1), integer0, new Integer(3), l0);
            if(object1 == a0) {
                return a0;
            }
            LoadPgnRes loadPgnRes0 = (LoadPgnRes)object0;
            object0 = object1;
            return new e(new Ua.a(loadPgnRes0, ((ListCmtRes)object0)));
        label_77:
            loadPgnRes0 = l0.w;
            d5.n.D(object0);
            return new e(new Ua.a(loadPgnRes0, ((ListCmtRes)object0)));
        }
        catch(Exception exception0) {
            return new d(exception0);
        }
    }

    public final Object e(int v, String s, int v1, boolean z, c c0) {
        m m0;
        if(c0 instanceof m) {
            m0 = (m)c0;
            int v2 = m0.B;
            if((v2 & 0x80000000) == 0) {
                m0 = new m(this, c0);
            }
            else {
                m0.B = v2 ^ 0x80000000;
            }
        }
        else {
            m0 = new m(this, c0);
        }
        Object object0 = m0.r;
        a a0 = a.a;
        switch(m0.B) {
            case 0: {
                d5.n.D(object0);
                try {
                    m0.B = 1;
                    object0 = this.a.L(v, s, v1, z, m0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(object0);
                    }
                    return new e(((InsertRecmRes)object0));
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

