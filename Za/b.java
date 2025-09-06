package Za;

import Na.d;
import Na.e;
import com.iloen.melon.net.v4x.response.MyMusicInsertBanSongRes;
import com.iloen.melon.net.v5x.response.MyMusicRecentListSongRecntRes;
import com.iloen.melon.net.v6x.response.ForUMixPlayRes;
import com.iloen.melon.net.v6x.response.ForuPlayRes;
import d5.n;
import java.io.Serializable;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import lb.a;
import lb.c;
import lb.f;
import lb.g;
import lb.h;
import ua.u;
import va.e0;
import va.o;

public final class b {
    public final u a;

    public b(u u0) {
        this.a = u0;
        super();
    }

    public Flow a(String s, String s1, boolean z) {
        return ((e0)o.a()).m() ? FlowKt.flow(new a(z, this, s, s1, null)) : FlowKt.flowOf(c.a);
    }

    public Object b(String s, String s1, String s2, String s3, oe.c c0) {
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
        Serializable serializable0 = f0.r;
        ne.a a0 = ne.a.a;
        switch(f0.B) {
            case 0: {
                n.D(serializable0);
                try {
                    f0.B = 1;
                    serializable0 = this.a.d(s, s1, s2, s3, f0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        n.D(serializable0);
                    }
                    return new e(((ForUMixPlayRes)serializable0));
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

    public Object c(String s, String s1, oe.c c0) {
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
        ne.a a0 = ne.a.a;
        switch(g0.B) {
            case 0: {
                n.D(object0);
                try {
                    g0.B = 1;
                    object0 = this.a.e(s, s1, g0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((ForuPlayRes)object0));
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

    public Object d(oe.c c0) {
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
        Object object0 = h0.r;
        ne.a a0 = ne.a.a;
        switch(h0.B) {
            case 0: {
                n.D(object0);
                try {
                    h0.B = 1;
                    object0 = this.a.i(h0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MyMusicRecentListSongRecntRes)object0));
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

    public Object e(String s, String s1, String s2, String s3, String s4, oe.c c0) {
        Za.a a0;
        if(c0 instanceof Za.a) {
            a0 = (Za.a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new Za.a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new Za.a(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                try {
                    a0.B = 1;
                    object0 = this.a.m(s, s1, s2, s3, s4, a0);
                    if(object0 == a1) {
                        return a1;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MyMusicInsertBanSongRes)object0));
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

