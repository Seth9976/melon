package mb;

import A8.j;
import A8.l;
import android.content.Context;
import com.iloen.melon.utils.NameValuePairList;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import ie.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import oe.c;
import va.n;

public final class f {
    public final n a;

    public f(n n0) {
        q.g(n0, "kakaoLoginRepository");
        super();
        this.a = n0;
        new LogU("KakaoLoginUseCase");
    }

    public final Object a(c c0) {
        mb.c c1;
        if(c0 instanceof mb.c) {
            c1 = (mb.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new mb.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new mb.c(this, c0);
        }
        Object object0 = c1.r;
        a a0 = a.a;
        switch(c1.B) {
            case 0: {
                d5.n.D(object0);
                c1.B = 1;
                Object object1 = this.a.b(c1);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                d5.n.D(object0);
                return ((p)object0).a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object b(Context context0, j j0, c c0) {
        d d0;
        if(c0 instanceof d) {
            d0 = (d)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new d(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new d(this, c0);
        }
        Object object0 = d0.r;
        a a0 = a.a;
        switch(d0.B) {
            case 0: {
                d5.n.D(object0);
                n n0 = this.a;
                if(j0 == j.a) {
                    d0.B = 1;
                    Object object1 = n0.f(context0, d0);
                    return object1 == a0 ? a0 : object1;
                }
                d0.B = 2;
                Object object2 = n0.e(context0, d0);
                return object2 == a0 ? a0 : object2;
            }
            case 1: 
            case 2: {
                d5.n.D(object0);
                return ((p)object0).a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object c(Context context0, j j0, String s, NameValuePairList nameValuePairList0, we.a a0, c c0) {
        e e0;
        if(c0 instanceof e) {
            e0 = (e)c0;
            int v = e0.G;
            if((v & 0x80000000) == 0) {
                e0 = new e(this, c0);
            }
            else {
                e0.G = v ^ 0x80000000;
            }
        }
        else {
            e0 = new e(this, c0);
        }
        Object object0 = e0.D;
        a a1 = a.a;
        switch(e0.G) {
            case 0: {
                d5.n.D(object0);
                e0.r = s;
                e0.w = nameValuePairList0;
                e0.B = a0;
                e0.G = 1;
                if(this.b(context0, j0, e0) == a1) {
                    return a1;
                }
                break;
            }
            case 1: {
                a0 = e0.B;
                nameValuePairList0 = e0.w;
                s = e0.r;
                d5.n.D(object0);
                ((p)object0).getClass();
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        l l0 = this.a.c();
        if(l0 != null) {
            if(a0 != null) {
                a0.invoke();
            }
            nameValuePairList0.remove("url");
            NameValuePairList nameValuePairList1 = new NameValuePairList();
            nameValuePairList1.add("kakaoId", String.valueOf(l0.a));
            nameValuePairList1.add("kakaoToken", l0.c);
            nameValuePairList1.add("kakaoRefreshToken", l0.b);
            nameValuePairList1.add("processType", "0");
            nameValuePairList1.addAll(nameValuePairList0);
            Navigator.openUrl(s, OpenType.FullScreen, nameValuePairList1);
        }
        return H.a;
    }

    public final Object d(Continuation continuation0) {
        Object object0 = this.a.g(continuation0);
        return object0 == a.a ? object0 : H.a;
    }
}

