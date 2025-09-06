package Ea;

import A0.c;
import Ba.J;
import G8.g;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import com.melon.net.res.common.SongInfoBase;
import d5.n;
import e1.u;
import ie.H;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.q;
import va.e0;
import va.o;
import w7.d;

public final class e {
    public final c a;

    public e(c c0, d d0) {
        this.a = c0;
    }

    public final Object a(String s, String s1, oe.c c0) {
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
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                a0.B = 1;
                object0 = ((J)this.a.b).a(s, s1, a0);
                return object0 == a1 ? a1 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object b(String s, oe.c c0) {
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
        Object object0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                b0.B = 1;
                object0 = ((J)this.a.b).b(s, b0);
                return object0 == a0 ? a0 : ApiResultKt.getOrNull(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrNull(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object c(String s, String s1, String s2, oe.c c0) {
        Ea.c c1;
        if(c0 instanceof Ea.c) {
            c1 = (Ea.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new Ea.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new Ea.c(this, c0);
        }
        Object object0 = c1.r;
        ne.a a0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                n.D(object0);
                c1.B = 1;
                object0 = ((J)this.a.b).c(s, s1, s2, u.v(((e0)o.a()).j()), c1);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object d(List list0, oe.c c0) {
        Iterator iterator0;
        F f0;
        int v1;
        Ea.d d0;
        if(c0 instanceof Ea.d) {
            d0 = (Ea.d)c0;
            int v = d0.G;
            if((v & 0x80000000) == 0) {
                d0 = new Ea.d(this, c0);
            }
            else {
                d0.G = v ^ 0x80000000;
            }
        }
        else {
            d0 = new Ea.d(this, c0);
        }
        Integer integer0 = d0.D;
        ne.a a0 = ne.a.a;
        switch(d0.G) {
            case 0: {
                n.D(integer0);
                v1 = 0;
                f0 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
                iterator0 = list0.iterator();
                goto label_23;
            }
            case 1: {
                v1 = d0.B;
                iterator0 = d0.w;
                f0 = d0.r;
                n.D(integer0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            f0.a += integer0.intValue();
        label_23:
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            String s = ((SongInfoBase)object0).songId;
            String s1 = "";
            if(s == null) {
                s = "";
            }
            String s2 = ((SongInfoBase)object0).albumId;
            if(s2 == null) {
                s2 = "";
            }
            String s3 = ((SongInfoBase)object0).albumName;
            if(s3 != null) {
                s1 = s3;
            }
            q.f("", "toString(...)");
            String s4 = ((SongInfoBase)object0).getArtistNames();
            d0.r = f0;
            d0.w = iterator0;
            d0.B = v1;
            d0.G = 1;
            g.a.m();
            Integer integer1 = new Integer(g.r(s, s2, s1, "", s4));
            if(integer1 == a0) {
                return a0;
            }
            integer0 = integer1;
        }
        return H.a;
    }
}

