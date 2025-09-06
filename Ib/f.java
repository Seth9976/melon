package ib;

import Na.d;
import Na.e;
import com.iloen.melon.net.v6x.response.MusicDnaMonthListRes;
import com.iloen.melon.net.v6x.response.MusicDnaUploadRes;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.MusicDnaMainMonthlyLogRes;
import d5.n;
import e1.u;
import java.io.Serializable;
import oe.c;
import okhttp3.MultipartBody.Part;
import ra.h;
import va.e0;
import va.o;

public final class f {
    public final h a;

    public f(h h0) {
        this.a = h0;
        LogU logU0 = new LogU("MusicDnaMainUseCase");
        logU0.setCategory(Category.None);
        logU0.setUseThreadInfo(true);
    }

    public final Object a(c c0) {
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
                try {
                    a0.B = 1;
                    object0 = this.a.a(a0);
                    if(object0 == a1) {
                        return a1;
                    label_18:
                        n.D(object0);
                    }
                    return Boolean.valueOf(((Boolean)object0).booleanValue());
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
        return false;
    }

    public final Object b(c c0) {
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
                    serializable0 = this.a.b(b0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        n.D(serializable0);
                    }
                    return new e(serializable0);
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

    public final Serializable c(String s, c c0) {
        ib.c c1;
        if(c0 instanceof ib.c) {
            c1 = (ib.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new ib.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new ib.c(this, c0);
        }
        Serializable serializable0 = c1.r;
        Serializable serializable1 = ne.a.a;
        switch(c1.B) {
            case 0: {
                n.D(serializable0);
                try {
                    c1.B = 1;
                    serializable0 = this.a.c(s, c1);
                    if(serializable0 == serializable1) {
                        return serializable1;
                    label_18:
                        n.D(serializable0);
                    }
                    return (MusicDnaMainMonthlyLogRes)serializable0;
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
        return null;
    }

    public final Serializable d(c c0) {
        ib.d d0;
        if(c0 instanceof ib.d) {
            d0 = (ib.d)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new ib.d(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new ib.d(this, c0);
        }
        Object object0 = d0.r;
        Serializable serializable0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                try {
                    d0.B = 1;
                    String s = u.w(((e0)o.a()).j());
                    object0 = this.a.a.a.f(s, d0);
                    if(object0 == serializable0) {
                        return serializable0;
                    label_19:
                        n.D(object0);
                    }
                    return (MusicDnaMonthListRes)object0;
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
        return null;
    }

    public final Serializable e(Part multipartBody$Part0, String s, String s1, String s2, String s3, c c0) {
        ib.e e0;
        if(c0 instanceof ib.e) {
            e0 = (ib.e)c0;
            int v = e0.B;
            if((v & 0x80000000) == 0) {
                e0 = new ib.e(this, c0);
            }
            else {
                e0.B = v ^ 0x80000000;
            }
        }
        else {
            e0 = new ib.e(this, c0);
        }
        Object object0 = e0.r;
        Serializable serializable0 = ne.a.a;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                try {
                    e0.B = 1;
                    String s4 = u.w(((e0)o.a()).j());
                    object0 = this.a.a.a.d(multipartBody$Part0, s, s1, s2, s3, s4, e0);
                    if(object0 == serializable0) {
                        return serializable0;
                    label_19:
                        n.D(object0);
                    }
                    return (MusicDnaUploadRes)object0;
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
        return null;
    }
}

