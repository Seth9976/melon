package Ya;

import Na.d;
import Na.e;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistPlayDeleteSongRes;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistPlayUpdateOrderRes;
import com.iloen.melon.net.v6x.response.DjSmartPlaylistListRes;
import com.iloen.melon.net.v6x.response.MyMusicLikePlaylistRes;
import com.iloen.melon.net.v6x.response.MyMusicRecentPlaylistRes;
import com.iloen.melon.net.v6x.response.MyMusicSmartPlaylistListRes;
import d5.n;
import d5.v;
import oe.c;
import ua.u;

public final class g {
    public final u a;
    public final v b;

    public g(u u0, v v0) {
        this.a = u0;
        this.b = v0;
    }

    public final Object a(String s, String s1, c c0) {
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
                    object0 = this.b.N(s, s1, a0);
                    if(object0 == a1) {
                        return a1;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((DjSmartPlaylistListRes)object0));
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
        Object object0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                try {
                    b0.B = 1;
                    object0 = this.a.f(b0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MyMusicLikePlaylistRes)object0));
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
        Ya.c c1;
        if(c0 instanceof Ya.c) {
            c1 = (Ya.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new Ya.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new Ya.c(this, c0);
        }
        Object object0 = c1.r;
        ne.a a0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                n.D(object0);
                try {
                    c1.B = 1;
                    object0 = this.a.k(c1);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MyMusicRecentPlaylistRes)object0));
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

    public final Object d(String s, String s1, c c0) {
        Ya.d d0;
        if(c0 instanceof Ya.d) {
            d0 = (Ya.d)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new Ya.d(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new Ya.d(this, c0);
        }
        Object object0 = d0.r;
        ne.a a0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                try {
                    d0.B = 1;
                    object0 = this.a.l(s, s1, d0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MyMusicSmartPlaylistListRes)object0));
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

    public final Object e(String s, String s1, String s2, String s3, String s4, c c0) {
        Ya.e e0;
        if(c0 instanceof Ya.e) {
            e0 = (Ya.e)c0;
            int v = e0.B;
            if((v & 0x80000000) == 0) {
                e0 = new Ya.e(this, c0);
            }
            else {
                e0.B = v ^ 0x80000000;
            }
        }
        else {
            e0 = new Ya.e(this, c0);
        }
        Object object0 = e0.r;
        ne.a a0 = ne.a.a;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                try {
                    e0.B = 1;
                    object0 = this.a.r(s, s1, s2, s3, s4, e0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MyMusicPlaylistPlayUpdateOrderRes)object0));
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

    public final Object f(String s, String s1, String s2, c c0) {
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
        ne.a a0 = ne.a.a;
        switch(f0.B) {
            case 0: {
                n.D(object0);
                try {
                    f0.B = 1;
                    object0 = this.a.s(s, s1, s2, f0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MyMusicPlaylistPlayDeleteSongRes)object0));
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

