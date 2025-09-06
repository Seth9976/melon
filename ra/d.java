package Ra;

import E9.w;
import Nb.i;
import Ua.h;
import Vb.p0;
import com.melon.data.database.MelonDatabase_Impl;
import com.melon.data.database.entity.BannerPopupEntity;
import d5.n;
import java.util.List;
import oe.c;

public final class d {
    public final h a;

    public d(h h0) {
        this.a = h0;
    }

    public final Object a(String s, String s1, List list0, c c0) {
        a a0;
        if(c0 instanceof a) {
            a0 = (a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new a(this, c0);
        }
        Integer integer0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(integer0);
                try {
                    a0.B = 1;
                    integer0 = this.a.f(s, s1, list0);
                    if(integer0 == a1) {
                        return a1;
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

    public final Object b(String s, String s1, c c0) {
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
        List list0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(list0);
                try {
                    b0.B = 1;
                    list0 = (List)w.N(((MelonDatabase_Impl)((ea.a)((h)this.a.a).a).a), true, false, new i(s, s1, 2));
                    return list0 == a0 ? a0 : list0;
                label_19:
                    n.D(list0);
                    return list0;
                }
                catch(Exception unused_ex) {
                    return je.w.a;
                }
            }
            case 1: {
                goto label_19;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object c(BannerPopupEntity bannerPopupEntity0, c c0) {
        Ra.c c1;
        if(c0 instanceof Ra.c) {
            c1 = (Ra.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new Ra.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new Ra.c(this, c0);
        }
        Long long0 = c1.r;
        ne.a a0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                n.D(long0);
                try {
                    c1.B = 1;
                    ea.a a1 = (ea.a)((h)this.a.a).a;
                    bannerPopupEntity0.getClass();
                    p0 p00 = new p0(20, a1, bannerPopupEntity0);
                    Long long1 = new Long(((long)(((Long)w.N(((MelonDatabase_Impl)a1.a), false, true, p00)))));
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

