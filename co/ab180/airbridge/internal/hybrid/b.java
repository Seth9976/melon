package co.ab180.airbridge.internal.hybrid;

import co.ab180.airbridge.Airbridge;
import co.ab180.airbridge.AirbridgeExKt;
import co.ab180.airbridge.common.Event;
import ie.H;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.D;
import kotlin.Metadata;
import kotlin.jvm.internal.n;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00C6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u000B\u0010\bJ\u0017\u0010\f\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\f\u0010\bJ\u0017\u0010\r\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u000E\u0010\bJ\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u000F\u0010\bJ\u0017\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0012\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0015\u0010\bJ\u0017\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0016\u0010\bJ\u0017\u0010\u0017\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0018\u0010\bJ\u0017\u0010\u0019\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0019\u0010\bR,\u0010\u001D\u001A\u001A\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u001B0\u001A8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0018\u0010\u001C\u00A8\u0006\u001E"}, d2 = {"Lco/ab180/airbridge/internal/hybrid/b;", "", "<init>", "()V", "", "jsonString", "Lie/H;", "h", "(Ljava/lang/String;)V", "p", "f", "o", "e", "q", "g", "n", "k", "d", "m", "j", "c", "b", "l", "i", "a", "r", "", "Lkotlin/reflect/KFunction1;", "Ljava/util/Map;", "methodsByName", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class b {
    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class a extends n implements k {
        public a(b b0) {
            super(1, 0, b.class, b0, "setUserAlias", "setUserAlias(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).m(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class co.ab180.airbridge.internal.hybrid.b.b extends n implements k {
        public co.ab180.airbridge.internal.hybrid.b.b(b b0) {
            super(1, 0, b.class, b0, "removeUserAlias", "removeUserAlias(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).j(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class c extends n implements k {
        public c(b b0) {
            super(1, 0, b.class, b0, "clearUserAlias", "clearUserAlias(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).c(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class d extends n implements k {
        public d(b b0) {
            super(1, 0, b.class, b0, "clearUser", "clearUser(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).b(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class e extends n implements k {
        public e(b b0) {
            super(1, 0, b.class, b0, "setDeviceAlias", "setDeviceAlias(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).l(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class f extends n implements k {
        public f(b b0) {
            super(1, 0, b.class, b0, "removeDeviceAlias", "removeDeviceAlias(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).i(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class g extends n implements k {
        public g(b b0) {
            super(1, 0, b.class, b0, "clearDeviceAlias", "clearDeviceAlias(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).a(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class h extends n implements k {
        public h(b b0) {
            super(1, 0, b.class, b0, "trackEvent", "trackEvent(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).r(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class i extends n implements k {
        public i(b b0) {
            super(1, 0, b.class, b0, "setUserID", "setUserID(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).p(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class j extends n implements k {
        public j(b b0) {
            super(1, 0, b.class, b0, "clearUserID", "clearUserID(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).f(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class co.ab180.airbridge.internal.hybrid.b.k extends n implements k {
        public co.ab180.airbridge.internal.hybrid.b.k(b b0) {
            super(1, 0, b.class, b0, "setUserEmail", "setUserEmail(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).o(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class l extends n implements k {
        public l(b b0) {
            super(1, 0, b.class, b0, "clearUserEmail", "clearUserEmail(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).e(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class m extends n implements k {
        public m(b b0) {
            super(1, 0, b.class, b0, "setUserPhone", "setUserPhone(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).q(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class co.ab180.airbridge.internal.hybrid.b.n extends n implements k {
        public co.ab180.airbridge.internal.hybrid.b.n(b b0) {
            super(1, 0, b.class, b0, "clearUserPhone", "clearUserPhone(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).g(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class o extends n implements k {
        public o(b b0) {
            super(1, 0, b.class, b0, "setUserAttribute", "setUserAttribute(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).n(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class p extends n implements k {
        public p(b b0) {
            super(1, 0, b.class, b0, "removeUserAttribute", "removeUserAttribute(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).k(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
    static final class q extends n implements k {
        public q(b b0) {
            super(1, 0, b.class, b0, "clearUserAttributes", "clearUserAttributes(Ljava/lang/String;)V");
        }

        public final void a(@NotNull String s) {
            ((b)this.receiver).d(s);
        }

        @Override  // we.k
        public Object invoke(Object object0) {
            this.a(((String)object0));
            return H.a;
        }
    }

    private static final Map a;
    @NotNull
    public static final b b;

    static {
        b b0 = new b();
        b.b = b0;
        i b$i0 = new i(b0);
        j b$j0 = new j(b0);
        co.ab180.airbridge.internal.hybrid.b.k b$k0 = new co.ab180.airbridge.internal.hybrid.b.k(b0);
        l b$l0 = new l(b0);
        m b$m0 = new m(b0);
        co.ab180.airbridge.internal.hybrid.b.n b$n0 = new co.ab180.airbridge.internal.hybrid.b.n(b0);
        o b$o0 = new o(b0);
        p b$p0 = new p(b0);
        q b$q0 = new q(b0);
        a b$a0 = new a(b0);
        co.ab180.airbridge.internal.hybrid.b.b b$b0 = new co.ab180.airbridge.internal.hybrid.b.b(b0);
        c b$c0 = new c(b0);
        d b$d0 = new d(b0);
        e b$e0 = new e(b0);
        f b$f0 = new f(b0);
        g b$g0 = new g(b0);
        h b$h0 = new h(b0);
        De.g[] arr_g = new De.g[17];
        arr_g[0] = b$i0;
        arr_g[1] = b$j0;
        arr_g[2] = b$k0;
        arr_g[3] = b$l0;
        arr_g[4] = b$m0;
        arr_g[5] = b$n0;
        arr_g[6] = b$o0;
        arr_g[7] = b$p0;
        arr_g[8] = b$q0;
        arr_g[9] = b$a0;
        arr_g[10] = b$b0;
        arr_g[11] = b$c0;
        arr_g[12] = b$d0;
        arr_g[13] = b$e0;
        arr_g[14] = b$f0;
        arr_g[15] = b$g0;
        int v = 16;
        arr_g[16] = b$h0;
        List list0 = e.k.A(arr_g);
        int v1 = D.N(je.q.Q(10, list0));
        if(v1 >= 16) {
            v = v1;
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
        for(Object object0: list0) {
            linkedHashMap0.put(((De.g)object0).getName(), object0);
        }
        b.a = linkedHashMap0;
    }

    private final void a(String s) {
        co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={clearDeviceAlias}", new Object[0]);
        Airbridge.clearDeviceAlias();
    }

    private final void b(String s) {
        co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={clearUser}", new Object[0]);
        Airbridge.clearUser();
    }

    private final void c(String s) {
        co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={clearUserAlias}", new Object[0]);
        Airbridge.clearUserAlias();
    }

    private final void d(String s) {
        co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={clearUserAttributes}", new Object[0]);
        Airbridge.clearUserAttributes();
    }

    private final void e(String s) {
        co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={clearUserEmail}", new Object[0]);
        Airbridge.clearUserEmail();
    }

    private final void f(String s) {
        co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={clearUserID}", new Object[0]);
        Airbridge.clearUserID();
    }

    private final void g(String s) {
        co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={clearUserPhone}", new Object[0]);
        Airbridge.clearUserPhone();
    }

    public final void h(@NotNull String s) {
        co.ab180.airbridge.internal.hybrid.c.b b0 = new co.ab180.airbridge.internal.hybrid.c.b(s);
        if(b0.e()) {
            String s1 = b0.b();
            String s2 = b0.a();
            co.ab180.airbridge.internal.b.e.e("Received a message from web interface: method={" + s1 + "} payload={" + s2 + '}', new Object[0]);
            if(s2 != null) {
                try {
                    De.g g0 = (De.g)b.a.get(s1);
                    if(g0 != null) {
                        H h0 = (H)((k)g0).invoke(s2);
                    }
                }
                catch(Throwable throwable0) {
                    co.ab180.airbridge.internal.b.e.b("Failed to receive a message from web interface: error={" + throwable0 + '}', new Object[0]);
                }
            }
        }
    }

    private final void i(String s) {
        co.ab180.airbridge.internal.hybrid.c.c c0 = new co.ab180.airbridge.internal.hybrid.c.c(s);
        if(c0.d()) {
            String s1 = c0.a();
            if(s1 != null) {
                co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={removeDeviceAlias}", new Object[0]);
                Airbridge.removeDeviceAlias(s1);
            }
        }
    }

    private final void j(String s) {
        co.ab180.airbridge.internal.hybrid.c.c c0 = new co.ab180.airbridge.internal.hybrid.c.c(s);
        if(c0.d()) {
            String s1 = c0.a();
            if(s1 != null) {
                co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={removeUserAlias}", new Object[0]);
                Airbridge.removeUserAlias(s1);
            }
        }
    }

    private final void k(String s) {
        co.ab180.airbridge.internal.hybrid.c.c c0 = new co.ab180.airbridge.internal.hybrid.c.c(s);
        if(c0.d()) {
            String s1 = c0.a();
            if(s1 != null) {
                co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={removeUserAttribute}", new Object[0]);
                Airbridge.removeUserAttribute(s1);
            }
        }
    }

    private final void l(String s) {
        co.ab180.airbridge.internal.hybrid.c.c c0 = new co.ab180.airbridge.internal.hybrid.c.c(s);
        if(c0.e()) {
            ie.m m0 = c0.b();
            if(m0 != null) {
                co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={setDeviceAlias}", new Object[0]);
                Airbridge.setDeviceAlias(((String)m0.a), ((String)m0.b));
            }
        }
    }

    private final void m(String s) {
        co.ab180.airbridge.internal.hybrid.c.c c0 = new co.ab180.airbridge.internal.hybrid.c.c(s);
        if(c0.e()) {
            ie.m m0 = c0.b();
            if(m0 != null) {
                co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={setUserAlias}", new Object[0]);
                Airbridge.setUserAlias(((String)m0.a), ((String)m0.b));
            }
        }
    }

    private final void n(String s) {
        co.ab180.airbridge.internal.hybrid.c.c c0 = new co.ab180.airbridge.internal.hybrid.c.c(s);
        if(c0.e()) {
            ie.m m0 = c0.b();
            if(m0 != null) {
                Object object0 = m0.b;
                Object object1 = m0.a;
                co.ab180.airbridge.internal.b.b b$b0 = co.ab180.airbridge.internal.b.e;
                b$b0.d("Handled command from web interface: method={setUserAttribute}", new Object[0]);
                if(object0 instanceof Integer) {
                    if(object0 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Airbridge.setUserAttribute(((String)object1), ((int)(((Integer)object0))));
                    return;
                }
                if(object0 instanceof Long) {
                    if(object0 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    Airbridge.setUserAttribute(((String)object1), ((long)(((Long)object0))));
                    return;
                }
                if(object0 instanceof Float) {
                    if(object0 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                    }
                    Airbridge.setUserAttribute(((String)object1), ((float)(((Float)object0))));
                    return;
                }
                if(object0 instanceof Double) {
                    if(object0 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                    }
                    Airbridge.setUserAttribute(((String)object1), ((double)(((Double)object0))));
                    return;
                }
                if(object0 instanceof Boolean) {
                    if(object0 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    Airbridge.setUserAttribute(((String)object1), ((Boolean)object0).booleanValue());
                    return;
                }
                if(object0 instanceof String) {
                    if(object0 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    Airbridge.setUserAttribute(((String)object1), ((String)object0));
                    return;
                }
                b$b0.f(" {" + ((String)object1) + " : " + object0 + "} type is not supported", new Object[0]);
            }
        }
    }

    private final void o(String s) {
        co.ab180.airbridge.internal.hybrid.c.d d0 = new co.ab180.airbridge.internal.hybrid.c.d(s);
        if(d0.h()) {
            String s1 = d0.c();
            if(s1 != null) {
                co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={setUserEmail}", new Object[0]);
                Airbridge.setUserEmail(s1);
            }
        }
    }

    private final void p(String s) {
        co.ab180.airbridge.internal.hybrid.c.d d0 = new co.ab180.airbridge.internal.hybrid.c.d(s);
        if(d0.i()) {
            String s1 = d0.d();
            if(s1 != null) {
                co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={setUserID}", new Object[0]);
                Airbridge.setUserID(s1);
            }
        }
    }

    private final void q(String s) {
        co.ab180.airbridge.internal.hybrid.c.d d0 = new co.ab180.airbridge.internal.hybrid.c.d(s);
        if(d0.j()) {
            String s1 = d0.e();
            if(s1 != null) {
                co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={setUserPhone}", new Object[0]);
                Airbridge.setUserPhone(s1);
            }
        }
    }

    private final void r(String s) {
        co.ab180.airbridge.internal.hybrid.c.a a0 = new co.ab180.airbridge.internal.hybrid.c.a(s);
        Event event0 = a0.b();
        if(event0 != null) {
            co.ab180.airbridge.internal.b.e.d("Handled command from web interface: method={trackEvent}", new Object[0]);
            Map map0 = a0.a();
            AirbridgeExKt.trackEvent(Airbridge.INSTANCE, co.ab180.airbridge.internal.network.model.b.c, event0, map0);
        }
    }
}

