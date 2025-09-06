package db;

import Na.d;
import com.iloen.melon.net.v4x.response.AuthLocationRes;
import d5.n;
import kotlin.jvm.internal.q;
import ne.a;

public final class g implements c {
    public final ma.g a;

    public g(ma.g g0) {
        q.g(g0, "locationRepository");
        super();
        this.a = g0;
    }

    public final Object b(long v, oe.c c0) {
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
        Object object0 = e0.r;
        a a0 = a.a;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                try {
                    e0.B = 1;
                    object0 = this.a.a(v, e0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new Na.e(((db.a)object0));
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

    public final Object c(oe.c c0) {
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
        Object object0 = f0.r;
        a a0 = a.a;
        switch(f0.B) {
            case 0: {
                n.D(object0);
                try {
                    f0.B = 1;
                    object0 = this.a.b(f0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new Na.e(((AuthLocationRes)object0));
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

