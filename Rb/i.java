package rb;

import E9.w;
import Vb.p0;
import com.iloen.melon.playback.playlist.db.d;
import com.iloen.melon.utils.log.LogU;
import com.melon.data.database.MelonDatabase_Impl;
import com.melon.data.database.entity.PremiumOffPlayLogEntity;
import d5.n;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import oe.c;
import wa.a;

public final class i {
    public final a a;

    public i(a a0) {
        this.a = a0;
    }

    public final Object a(String s, c c0) {
        rb.a a0;
        if(c0 instanceof rb.a) {
            a0 = (rb.a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new rb.a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new rb.a(this, c0);
        }
        Integer integer0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(integer0);
                try {
                    a0.B = 1;
                    d d0 = new d(s, 9);
                    integer0 = new Integer(((int)(((Integer)w.N(((MelonDatabase_Impl)((ea.d)((a)this.a.a).a).a), false, true, d0)))));
                    if(integer0 == a1) {
                        return a1;
                    label_19:
                        n.D(integer0);
                    }
                    return new Integer(integer0.intValue());
                }
                catch(Exception unused_ex) {
                    break;
                }
            }
            case 1: {
                goto label_19;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Integer(-1);
    }

    public final Object b(ArrayList arrayList0, c c0) {
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
        Integer integer0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(integer0);
                try {
                    b0.B = 1;
                    integer0 = this.a.e(arrayList0);
                    if(integer0 == a0) {
                        return a0;
                    label_18:
                        n.D(integer0);
                    }
                    return new Integer(integer0.intValue());
                }
                catch(Exception unused_ex) {
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
        return new Integer(-1);
    }

    public final Object c(int v, String s, c c0) {
        long v4;
        String s1;
        int v3;
        rb.c c1;
        if(c0 instanceof rb.c) {
            c1 = (rb.c)c0;
            int v1 = c1.G;
            if((v1 & 0x80000000) == 0) {
                c1 = new rb.c(this, c0);
            }
            else {
                c1.G = v1 ^ 0x80000000;
            }
        }
        else {
            c1 = new rb.c(this, c0);
        }
        Object object0 = c1.D;
        ne.a a0 = ne.a.a;
        switch(c1.G) {
            case 0: {
                n.D(object0);
                long v2 = System.currentTimeMillis();
                c1.r = s;
                c1.w = v;
                c1.B = v2 - 5184000000L;
                c1.G = 1;
                object0 = this.a(String.valueOf(v2 - 5184000000L), c1);
                if(object0 == a0) {
                    return a0;
                }
                v3 = v;
                s1 = s;
                v4 = v2 - 5184000000L;
                break;
            }
            case 1: {
                v4 = c1.B;
                v3 = c1.w;
                s1 = c1.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return (List)object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Date date0 = new Date(v4);
        LogU.Companion.d("PremiumOffPlayLogUseCase", "fetchPremiumOffPlayLog() - beginOfValidTime:" + date0 + ", deleted:" + ((Number)object0).intValue());
        c1.r = null;
        c1.w = v3;
        c1.B = v4;
        c1.G = 2;
        object0 = this.e(v3, s1, c1);
        return object0 == a0 ? a0 : ((List)object0);
    }

    public final Object d(c c0) {
        long v2;
        rb.d d0;
        if(c0 instanceof rb.d) {
            d0 = (rb.d)c0;
            int v = d0.D;
            if((v & 0x80000000) == 0) {
                d0 = new rb.d(this, c0);
            }
            else {
                d0.D = v ^ 0x80000000;
            }
        }
        else {
            d0 = new rb.d(this, c0);
        }
        Object object0 = d0.w;
        ne.a a0 = ne.a.a;
        switch(d0.D) {
            case 0: {
                n.D(object0);
                long v1 = System.currentTimeMillis();
                d0.r = v1 - 5184000000L;
                d0.D = 1;
                object0 = this.a(String.valueOf(v1 - 5184000000L), d0);
                if(object0 == a0) {
                    return a0;
                }
                v2 = v1 - 5184000000L;
                break;
            }
            case 1: {
                v2 = d0.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return (List)object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Date date0 = new Date(v2);
        LogU.Companion.d("PremiumOffPlayLogUseCase", "fetchPremiumOffPlayLogMemberKeyList() - beginOfValidTime:" + date0 + ", deleted:" + ((Number)object0).intValue());
        d0.r = v2;
        d0.D = 2;
        object0 = this.f(d0);
        return object0 == a0 ? a0 : ((List)object0);
    }

    public final Object e(int v, String s, c c0) {
        e e0;
        if(c0 instanceof e) {
            e0 = (e)c0;
            int v1 = e0.B;
            if((v1 & 0x80000000) == 0) {
                e0 = new e(this, c0);
            }
            else {
                e0.B = v1 ^ 0x80000000;
            }
        }
        else {
            e0 = new e(this, c0);
        }
        List list0 = e0.r;
        ne.a a0 = ne.a.a;
        switch(e0.B) {
            case 0: {
                n.D(list0);
                try {
                    e0.B = 1;
                    Ld.w w0 = new Ld.w(s, v, 5);
                    list0 = (List)w.N(((MelonDatabase_Impl)((ea.d)((a)this.a.a).a).a), true, false, w0);
                    return list0 == a0 ? a0 : list0;
                label_20:
                    n.D(list0);
                    return list0;
                }
                catch(Exception unused_ex) {
                    return je.w.a;
                }
            }
            case 1: {
                goto label_20;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object f(c c0) {
        f f0;
        if(c0 instanceof f) {
            f0 = (f)c0;
            int v = f0.B;
            if((v & 0x80000000) == 0) {
                f0 = new f(this, c0);
            }
            else {
                f0.B = v ^ 0x80000000;
            }
        }
        else {
            f0 = new f(this, c0);
        }
        List list0 = f0.r;
        ne.a a0 = ne.a.a;
        switch(f0.B) {
            case 0: {
                n.D(list0);
                try {
                    f0.B = 1;
                    dc.c c1 = new dc.c(25);
                    list0 = (List)w.N(((MelonDatabase_Impl)((ea.d)((a)this.a.a).a).a), true, false, c1);
                    return list0 == a0 ? a0 : list0;
                label_20:
                    n.D(list0);
                    return list0;
                }
                catch(Exception unused_ex) {
                    return je.w.a;
                }
            }
            case 1: {
                goto label_20;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object g(String s, c c0) {
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
        Integer integer0 = g0.r;
        ne.a a0 = ne.a.a;
        int v1 = 0;
        switch(g0.B) {
            case 0: {
                n.D(integer0);
                try {
                    g0.B = 1;
                    d d0 = new d(s, 8);
                    integer0 = new Integer(((int)(((Integer)w.N(((MelonDatabase_Impl)((ea.d)((a)this.a.a).a).a), true, false, d0)))));
                    if(integer0 == a0) {
                        return a0;
                    label_20:
                        n.D(integer0);
                    }
                    v1 = integer0.intValue();
                }
                catch(Exception unused_ex) {
                }
                break;
            }
            case 1: {
                goto label_20;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Integer(v1);
    }

    public final Object h(PremiumOffPlayLogEntity premiumOffPlayLogEntity0, c c0) {
        h h0;
        if(c0 instanceof h) {
            h0 = (h)c0;
            int v = h0.B;
            if((v & 0x80000000) == 0) {
                h0 = new h(this, c0);
            }
            else {
                h0.B = v ^ 0x80000000;
            }
        }
        else {
            h0 = new h(this, c0);
        }
        Long long0 = h0.r;
        ne.a a0 = ne.a.a;
        switch(h0.B) {
            case 0: {
                n.D(long0);
                try {
                    h0.B = 1;
                    ea.d d0 = (ea.d)((a)this.a.a).a;
                    premiumOffPlayLogEntity0.getClass();
                    p0 p00 = new p0(23, d0, premiumOffPlayLogEntity0);
                    Long long1 = new Long(((long)(((Long)w.N(((MelonDatabase_Impl)d0.a), false, true, p00)))));
                    if(long1 == a0) {
                        return a0;
                    }
                    long0 = long1;
                    return new Long(long0.longValue());
                label_23:
                    n.D(long0);
                    return new Long(long0.longValue());
                }
                catch(Exception unused_ex) {
                    break;
                }
            }
            case 1: {
                goto label_23;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Long(-1L);
    }
}

