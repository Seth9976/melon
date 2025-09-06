package com.iloen.melon.utils.log;

import Db.i;
import Hb.c;
import Hb.d;
import Hb.e;
import Hb.f;
import Hb.g;
import Hb.h;
import Hb.j;
import Hb.k;
import Hb.m;
import Hb.n;
import Hb.o;
import Qb.b;
import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u00022\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001A\u00020\t¢\u0006\u0004\b\f\u0010\rJ+\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u00022\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000E\u0010\rJ+\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u00022\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000F\u0010\rJ+\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u00022\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0010\u0010\rJ+\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u00022\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0011\u0010\rR\u0017\u0010\u0017\u001A\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016R$\u0010\u001D\u001A\u00020\t2\u0006\u0010\u0018\u001A\u00020\t8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR$\u0010#\u001A\u00020\u001E2\u0006\u0010\u0018\u001A\u00020\u001E8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/iloen/melon/utils/log/LogU;", "", "", "tag", "<init>", "(Ljava/lang/String;)V", "message", "", "throwable", "", "onlyDebug", "Lie/H;", "verbose", "(Ljava/lang/String;Ljava/lang/Throwable;Z)V", "debug", "info", "warn", "error", "LDb/i;", "a", "LDb/i;", "getNewLog", "()LDb/i;", "newLog", "value", "getUseThreadInfo", "()Z", "setUseThreadInfo", "(Z)V", "useThreadInfo", "Lcom/iloen/melon/utils/log/Category;", "getCategory", "()Lcom/iloen/melon/utils/log/Category;", "setCategory", "(Lcom/iloen/melon/utils/log/Category;)V", "category", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LogU {
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001J+\u0010\t\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000EJ)\u0010\r\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u00022\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0007¢\u0006\u0004\b\r\u0010\u0011J\u001F\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u000EJ)\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u00022\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0007¢\u0006\u0004\b\u0012\u0010\u0011J\u001F\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0013\u0010\u000EJ)\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u00022\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0007¢\u0006\u0004\b\u0013\u0010\u0011J\u001F\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u000EJ)\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u00022\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0007¢\u0006\u0004\b\u0014\u0010\u0011J\u001F\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u000EJ)\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u00022\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0007¢\u0006\u0004\b\u0015\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/utils/log/LogU$Companion;", "", "", "tag", "", "useThreadInfo", "Lcom/iloen/melon/utils/log/Category;", "category", "Lcom/iloen/melon/utils/log/LogU;", "create", "(Ljava/lang/String;ZLcom/iloen/melon/utils/log/Category;)Lcom/iloen/melon/utils/log/LogU;", "message", "Lie/H;", "v", "(Ljava/lang/String;Ljava/lang/String;)V", "", "throwable", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "d", "i", "w", "e", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public static final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
                int[] arr_v = new int[n.values().length];
                try {
                    arr_v[0] = 1;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[1] = 2;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[2] = 3;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[3] = 4;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[4] = 5;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                WhenMappings.$EnumSwitchMapping$0 = arr_v;
            }
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static void a(n n0, String s, String s1, Throwable throwable0) {
            i i0 = new i(s);
            k k0 = new k(false, 0);
            switch(n0.ordinal()) {
                case 0: {
                    b b4 = new b(s1, 2);
                    i0.d(n.a, b4, throwable0, k0);
                    return;
                }
                case 1: {
                    b b3 = new b(s1, 2);
                    i0.d(n.b, b3, throwable0, k0);
                    return;
                }
                case 2: {
                    b b2 = new b(s1, 2);
                    i0.d(n.c, b2, throwable0, k0);
                    return;
                }
                case 3: {
                    b b1 = new b(s1, 2);
                    i0.d(n.d, b1, throwable0, k0);
                    return;
                }
                case 4: {
                    b b0 = new b(s1, 2);
                    i0.d(n.e, b0, throwable0, k0);
                    return;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }

        @NotNull
        public final LogU create(@NotNull String s, boolean z, @NotNull Category category0) {
            q.g(s, "tag");
            q.g(category0, "category");
            LogU logU0 = new LogU(s);
            logU0.setUseThreadInfo(z);
            logU0.setCategory(category0);
            return logU0;
        }

        public static LogU create$default(Companion logU$Companion0, String s, boolean z, Category category0, int v, Object object0) {
            if((v & 2) != 0) {
                z = true;
            }
            if((v & 4) != 0) {
                category0 = Category.None;
            }
            return logU$Companion0.create(s, z, category0);
        }

        public final void d(@NotNull String s, @NotNull String s1) {
            q.g(s, "tag");
            q.g(s1, "message");
            Companion.a(n.b, s, s1, null);
        }

        public final void d(@NotNull String s, @NotNull String s1, @Nullable Throwable throwable0) {
            q.g(s, "tag");
            q.g(s1, "message");
            Companion.a(n.b, s, s1, throwable0);
        }

        public final void e(@NotNull String s, @NotNull String s1) {
            q.g(s, "tag");
            q.g(s1, "message");
            Companion.a(n.e, s, s1, null);
        }

        public final void e(@NotNull String s, @NotNull String s1, @Nullable Throwable throwable0) {
            q.g(s, "tag");
            q.g(s1, "message");
            Companion.a(n.e, s, s1, throwable0);
        }

        public final void i(@NotNull String s, @NotNull String s1) {
            q.g(s, "tag");
            q.g(s1, "message");
            Companion.a(n.c, s, s1, null);
        }

        public final void i(@NotNull String s, @NotNull String s1, @Nullable Throwable throwable0) {
            q.g(s, "tag");
            q.g(s1, "message");
            Companion.a(n.c, s, s1, throwable0);
        }

        public final void v(@NotNull String s, @NotNull String s1) {
            q.g(s, "tag");
            q.g(s1, "message");
            Companion.a(n.a, s, s1, null);
        }

        public final void v(@NotNull String s, @NotNull String s1, @Nullable Throwable throwable0) {
            q.g(s, "tag");
            q.g(s1, "message");
            Companion.a(n.a, s, s1, throwable0);
        }

        public final void w(@NotNull String s, @NotNull String s1) {
            q.g(s, "tag");
            q.g(s1, "message");
            Companion.a(n.d, s, s1, null);
        }

        public final void w(@NotNull String s, @NotNull String s1, @Nullable Throwable throwable0) {
            q.g(s, "tag");
            q.g(s1, "message");
            Companion.a(n.d, s, s1, throwable0);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final i a;

    static {
        LogU.Companion = new Companion(null);
        LogU.$stable = 8;
    }

    public LogU(@NotNull String s) {
        q.g(s, "tag");
        super();
        this.a = new i(s);
    }

    @NotNull
    public static final LogU create(@NotNull String s, boolean z, @NotNull Category category0) {
        return LogU.Companion.create(s, z, category0);
    }

    public static final void d(@NotNull String s, @NotNull String s1) {
        LogU.Companion.d(s, s1);
    }

    public static final void d(@NotNull String s, @NotNull String s1, @Nullable Throwable throwable0) {
        LogU.Companion.d(s, s1, throwable0);
    }

    public final void debug(@NotNull String s, @Nullable Throwable throwable0, boolean z) {
        q.g(s, "message");
        k k0 = new k(z, 0);
        b b0 = new b(s, 3);
        this.a.getClass();
        this.a.d(n.b, b0, throwable0, k0);
    }

    public static void debug$default(LogU logU0, String s, Throwable throwable0, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            throwable0 = null;
        }
        if((v & 4) != 0) {
            z = false;
        }
        logU0.debug(s, throwable0, z);
    }

    public static final void e(@NotNull String s, @NotNull String s1) {
        LogU.Companion.e(s, s1);
    }

    public static final void e(@NotNull String s, @NotNull String s1, @Nullable Throwable throwable0) {
        LogU.Companion.e(s, s1, throwable0);
    }

    public final void error(@NotNull String s, @Nullable Throwable throwable0, boolean z) {
        q.g(s, "message");
        k k0 = new k(z, 0);
        b b0 = new b(s, 3);
        this.a.getClass();
        this.a.d(n.e, b0, throwable0, k0);
    }

    public static void error$default(LogU logU0, String s, Throwable throwable0, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            throwable0 = null;
        }
        if((v & 4) != 0) {
            z = false;
        }
        logU0.error(s, throwable0, z);
    }

    @NotNull
    public final Category getCategory() {
        j j0 = this.a.b.a;
        q.g(j0, "<this>");
        if(j0.equals(Hb.i.b)) {
            return Category.UI;
        }
        if(j0.equals(h.b)) {
            return Category.Playback;
        }
        if(j0.equals(Hb.b.b)) {
            return Category.Analytics;
        }
        if(j0.equals(e.b)) {
            return Category.LocalSync;
        }
        if(j0.equals(c.b)) {
            return Category.Download;
        }
        if(j0.equals(f.b)) {
            return Category.Login;
        }
        if(j0.equals(g.b)) {
            return Category.None;
        }
        if(!j0.equals(d.b)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return Category.Http;
    }

    @NotNull
    public final i getNewLog() {
        return this.a;
    }

    public final boolean getUseThreadInfo() {
        return this.a.b.b;
    }

    public static final void i(@NotNull String s, @NotNull String s1) {
        LogU.Companion.i(s, s1);
    }

    public static final void i(@NotNull String s, @NotNull String s1, @Nullable Throwable throwable0) {
        LogU.Companion.i(s, s1, throwable0);
    }

    public final void info(@NotNull String s, @Nullable Throwable throwable0, boolean z) {
        q.g(s, "message");
        k k0 = new k(z, 0);
        b b0 = new b(s, 3);
        this.a.getClass();
        this.a.d(n.c, b0, throwable0, k0);
    }

    public static void info$default(LogU logU0, String s, Throwable throwable0, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            throwable0 = null;
        }
        if((v & 4) != 0) {
            z = false;
        }
        logU0.info(s, throwable0, z);
    }

    public final void setCategory(@NotNull Category category0) {
        Hb.i i0;
        q.g(category0, "value");
        switch(m.a[category0.ordinal()]) {
            case 1: {
                i0 = Hb.i.b;
                break;
            }
            case 2: {
                i0 = h.b;
                break;
            }
            case 3: {
                i0 = Hb.b.b;
                break;
            }
            case 4: {
                i0 = e.b;
                break;
            }
            case 5: {
                i0 = c.b;
                break;
            }
            case 6: {
                i0 = f.b;
                break;
            }
            case 7: {
                i0 = g.b;
                break;
            }
            case 8: {
                i0 = d.b;
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        this.a.e(i0);
    }

    public final void setUseThreadInfo(boolean z) {
        i i0 = this.a;
        o o0 = i0.b;
        if(o0.b == z) {
            return;
        }
        o o1 = o.a(o0, null, z, 1);
        i0.b = o1;
        i0.c.b = o1;
    }

    public static final void v(@NotNull String s, @NotNull String s1) {
        LogU.Companion.v(s, s1);
    }

    public static final void v(@NotNull String s, @NotNull String s1, @Nullable Throwable throwable0) {
        LogU.Companion.v(s, s1, throwable0);
    }

    public final void verbose(@NotNull String s, @Nullable Throwable throwable0, boolean z) {
        q.g(s, "message");
        k k0 = new k(z, 0);
        b b0 = new b(s, 3);
        this.a.getClass();
        this.a.d(n.a, b0, throwable0, k0);
    }

    public static void verbose$default(LogU logU0, String s, Throwable throwable0, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            throwable0 = null;
        }
        if((v & 4) != 0) {
            z = false;
        }
        logU0.verbose(s, throwable0, z);
    }

    public static final void w(@NotNull String s, @NotNull String s1) {
        LogU.Companion.w(s, s1);
    }

    public static final void w(@NotNull String s, @NotNull String s1, @Nullable Throwable throwable0) {
        LogU.Companion.w(s, s1, throwable0);
    }

    public final void warn(@NotNull String s, @Nullable Throwable throwable0, boolean z) {
        q.g(s, "message");
        k k0 = new k(z, 0);
        b b0 = new b(s, 3);
        this.a.getClass();
        this.a.d(n.d, b0, throwable0, k0);
    }

    public static void warn$default(LogU logU0, String s, Throwable throwable0, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            throwable0 = null;
        }
        if((v & 4) != 0) {
            z = false;
        }
        logU0.warn(s, throwable0, z);
    }
}

